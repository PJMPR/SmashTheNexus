package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IRepository;
import domain.model.TeamMember;

public class TeamMemberMapper implements IMapResultSetIntoEntity<TeamMember>{

private IRepository<TeamMember> teamMemberRepo;

	
	public IRepository<TeamMember> getTeamMemberRepo() {
		return teamMemberRepo;
	}
	public TeamMember map(ResultSet rs) throws SQLException {
		TeamMember teamMember = new TeamMember();
		teamMember.setName(rs.getString("name"));
		teamMember.setSurname(rs.getString("surname"));
		teamMember.setNick(rs.getString("nick"));
		teamMember.setAge(rs.getInt("age"));
		teamMember.setCountry(rs.getString("country"));
		teamMember.setFavouriteChampion(rs.getString("fav_champ"));
		return teamMember;
		
	}
	public void setTeamMemberRepo(IRepository<TeamMember> teamMemberRepo) {
		this.teamMemberRepo = teamMemberRepo;
	}

}
