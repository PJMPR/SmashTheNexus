package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.model.Match;

public class MatchRepository {

	private Connection connection;

	private String createTableSql = "CREATE TABLE match(" + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
			+ "match_date date," + "first_team varchar(50)," + "second_team varchar(50)," + "result VARCHAR(20),"
			+ "best_of int," + ")";

	private Statement createTable;

	private String insertSql = "INSERT INTO match(match_date,first_team,second_team,result,best_of) VALUES(?,?,?,?,?)";
	private String deleteSql = "DELETE FROM match WHERE id = ?";
	private String updateSql = "UPDATE match set match_date=?,first_team=?,second_team=?,result=?,best_of=? WHERE id=?";
	private String selectByIdSql = "SELECT * FROM match WHERE id=?";
	private String selectAllSql = "SELECT * FROM match";

	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement selectById;
	private PreparedStatement selectAll;

	public MatchRepository(Connection connection) {
		this.connection = connection;

		try {
			createTable = connection.createStatement();

			boolean tableExists = false;
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			while (rs.next()) {
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("match")) {
					tableExists = true;
					break;
				}
			}
			if (!tableExists) {
				createTable.executeUpdate(createTableSql);
				insert = connection.prepareStatement(insertSql);
				delete = connection.prepareStatement(deleteSql);
				update = connection.prepareStatement(updateSql);
				selectById = connection.prepareStatement(selectByIdSql);
				selectAll = connection.prepareStatement(selectAllSql);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Match get(int matchId) {
		try {
			selectById.setInt(1, matchId);
			ResultSet rs = selectById.executeQuery();
			while (rs.next()) {
				Match result = new Match();
				result.setID(rs.getInt("id"));
				result.setDate(rs.getDate("match_date"));
				result.setFirstTeam(rs.getString("first_team"));
				result.setSecondTeam(rs.getString("second_team"));
				result.setResult(rs.getString("result"));
				result.setBestOf(rs.getInt("best_of"));
				return result;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Match> getAll() {
		try {
			List<Match> result = new ArrayList<Match>();
			ResultSet rs = selectAll.executeQuery();
			while (rs.next()) {
				Match m = new Match();
				m.setID(rs.getInt("id"));
				m.setDate(rs.getDate("match_date"));
				m.setFirstTeam(rs.getString("first_team"));
				m.setSecondTeam(rs.getString("second_team"));
				m.setResult(rs.getString("result"));
				m.setBestOf(rs.getInt("best_of"));
				result.add(m);
			}
			return result;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void delete(Match m) {
		try {
			delete.setInt(1, m.getID());
			delete.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void add(Match m) {
		try {
			insert.setDate(1, (Date) m.getDate());
			insert.setString(2, m.getFirstTeam());
			insert.setString(3, m.getSecondTeam());
			insert.setString(4, m.getResult());
			insert.setInt(5, m.getBestOf());
			insert.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void update(Match m) {
		try {
			update.setDate(1, (Date) m.getDate());
			update.setString(2, m.getFirstTeam());
			update.setString(3, m.getSecondTeam());
			update.setString(4, m.getResult());
			update.setInt(5, m.getBestOf());
			update.setInt(6, m.getID());
			update.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
