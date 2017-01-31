package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IRepository;
import domain.model.Match;

public class MatchMapper implements IMapResultSetIntoEntity<Match> {

	private IRepository<Match> matchRepo;
	
	public IRepository<Match> getMatchRepo() {
		return matchRepo;
	}
	public Match map(ResultSet rs) throws SQLException {
		Match match = new Match();
		match.setId(rs.getInt("id"));
		match.setDate(rs.getDate("date"));
		match.setResult(rs.getString("result"));
		match.setBestOf(rs.getInt("bestOf"));
		return match;
	}

	public void setMatchRepo(IRepository<Match> matchRepo) {
		this.matchRepo = matchRepo;
	}

}
