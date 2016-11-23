package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.model.Team;

public class TeamRepository {

	private Connection connection;

	private String createTableSql = "CREATE TABLE team(" + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
			+ "name varchar(50)," + "wins int," + "loses int," + "form_date int," + "short_name varchar(5)," + ")";

	private Statement createTable;

	private String insertSql = "INSERT INTO team(name, wins, loses, form_date, short_name) VALUES(?,?,?,?,?)";
	private String deleteSql = "DELETE FROM team WHERE id = ?";
	private String updateSql = "UPDATE team SET name=?,wins=?,loses=?,form_date=?,short_name=? WHERE id=?";
	private String selectByIdSql = "SELECT * FROM team WHERE id=?";
	private String selectAllSql = "SELECT * FROM team";

	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement selectById;
	private PreparedStatement selectAll;

	public TeamRepository(Connection connection) {
		this.connection = connection;

		try {
			createTable = connection.createStatement();

			boolean tableExists = false;
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			while (rs.next()) {
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("team")) {
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

	public Team get(int teamId) {
		try {
			selectById.setInt(1, teamId);
			ResultSet rs = selectById.executeQuery();
			while (rs.next()) {
				Team result = new Team();
				result.setID(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setWins(rs.getInt("wins"));
				result.setLoses(rs.getInt("loses"));
				result.setFormDate(rs.getInt("form_date"));
				result.setShortName(rs.getString("short_name"));
				return result;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Team> getAll() {
		try {
			List<Team> result = new ArrayList<Team>();
			ResultSet rs = selectAll.executeQuery();
			while (rs.next()) {
				Team t = new Team();
				t.setID(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setWins(rs.getInt("wins"));
				t.setLoses(rs.getInt("loses"));
				t.setFormDate(rs.getInt("form_date"));
				t.setShortName(rs.getString("short_name"));
				result.add(t);
			}
			return result;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void delete(Team t) {
		try {
			delete.setInt(1, t.getID());
			delete.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void add(Team t) {
		try {
			insert.setString(1, t.getName());
			insert.setInt(2, t.getWins());
			insert.setInt(3, t.getLoses());
			insert.setInt(4, t.getFormDate());
			insert.setString(5, t.getShortName());
			insert.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void update(Team t) {
		try {
			update.setString(1, t.getName());
			update.setInt(2, t.getWins());
			update.setInt(3, t.getLoses());
			update.setInt(4, t.getFormDate());
			update.setString(5, t.getShortName());
			update.setInt(6, t.getID());
			update.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
