package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IRepository;
import domain.model.Team;

public class TeamMapper implements IMapResultSetIntoEntity<Team> {

	private IRepository<Team> teamRepo;
	
	public IRepository<Team> getMatchRepo() {
		return teamRepo;
	}
	public Team map(ResultSet rs) throws SQLException {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setName(rs.getString("name"));
		team.setWins(rs.getInt("wins"));
		team.setLoses(rs.getInt("loses"));
		team.setFormDate(rs.getInt("form_date"));
		team.setShortName(rs.getString("short_name"));
		return team;
	}

	public void setTeamRepo(IRepository<Team> teamRepo) {
		this.teamRepo = teamRepo;
	}

}
