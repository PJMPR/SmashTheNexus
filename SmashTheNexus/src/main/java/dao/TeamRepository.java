package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.uow.IUnitOfWork;
import domain.model.Team;


public class TeamRepository extends RepositoryBase<Team> implements ITeamRepository{

	public TeamRepository(Connection connection, IMapResultSetIntoEntity<Team> mapper, IUnitOfWork uow) {
		super(connection, mapper, uow);
	}

	@Override
	protected void setInsert(Team entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setInt(2, entity.getWins());
		insert.setInt(3, entity.getLoses());
		insert.setInt(4, entity.getFormDate());
		insert.setString(5, entity.getShortName());
		
	}

	@Override
	protected void setUpdate(Team entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setInt(2, entity.getWins());
		update.setInt(3, entity.getLoses());
		update.setInt(4, entity.getFormDate());
		update.setString(5, entity.getShortName());
		
	}

	@Override
	protected String tableName() {
		return "team";
	}

	@Override
	protected String createTableSql() {
		return "CREATE TABLE team(" + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
		+ "name varchar(50)," + "wins int," + "loses int," + "form_date int," + "short_name varchar(5)," + ")";
	}

	@Override
	protected String insertSql() {
		return "INSERT INTO team(name, wins, loses, form_date, short_name) VALUES(?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		return "UPDATE team SET name=?,wins=?,loses=?,form_date=?,short_name=? WHERE id=?";
	}

	public List<Team> withShortName(String shortName) {
		// TODO Auto-generated method stub
		return null;
	}

}
