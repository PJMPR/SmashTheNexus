package dao;


import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.IMapResultSetIntoEntity;
import dao.uow.IUnitOfWork;
import domain.model.Team;
import domain.model.TeamMember;

public class TeamMemberRepository extends RepositoryBase<TeamMember> implements ITeamMemberRepository {

	private TeamRepository repo;
	
	public TeamMemberRepository(Connection connection, IMapResultSetIntoEntity<TeamMember> mapper, IUnitOfWork uow) {
		super(connection, mapper, uow);
	}

	@Override
	protected void setInsert(TeamMember entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getSurname());
		insert.setString(3, entity.getNick());
		insert.setInt(4, entity.getTeamID());
		insert.setInt(5, entity.getAge());
		insert.setString(6, entity.getCountry());
		insert.setString(7, entity.getFavouriteChampion());
		insert.executeUpdate();
		
	}

	@Override
	protected void setUpdate(TeamMember entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getSurname());
		update.setString(3, entity.getNick());
		update.setInt(4, entity.getTeamID());
		update.setInt(5, entity.getAge());
		update.setString(6, entity.getCountry());
		update.setString(7, entity.getFavouriteChampion());
		update.setInt(8, entity.getId());
		update.executeUpdate();		
	}

	@Override
	protected String tableName() {
		return "team_member";
	}

	@Override
	protected String createTableSql() {
		return "CREATE TABLE team_member(" + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "name varchar(50)," + "surname varchar(50)," + "nick varchar(50)," + "Team_Id int," 
				+ "age int,"
				+ "country varchar(30),"
				+ "favourite_champion varchar(30),"+ ")";
	}

	@Override
	protected String insertSql() {
		return "INSERT INTO team_member(name, surname, nick, team_id, age, country, favourite_champion) VALUES(?,?,?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		return "UPDATE team_member SET name=?,surname=?,nick=?,team_id=?,age=?,country=?,favourite_champion=? WHERE id=?";
	}
	
	public void assignToTeam(TeamMember teamMemberWithoutTeam) {

		Team t1 = repo.get(teamMemberWithoutTeam.getId());
		teamMemberWithoutTeam.setTeamID(t1.getId());

	}
}
