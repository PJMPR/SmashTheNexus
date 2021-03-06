package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.uow.Entity;
import dao.uow.IUnitOfWork;
import dao.uow.IUnitOfWorkRepository;
import domain.model.IHaveId;

public abstract class RepositoryBase<TEntity extends IHaveId> implements IRepository<TEntity>, IUnitOfWorkRepository {

	protected Connection connection;
	protected IUnitOfWork uow;
	protected Statement createTable;

	protected PreparedStatement insert;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	protected PreparedStatement selectById;
	protected PreparedStatement selectAll;
	protected PreparedStatement selectLastId;

	protected IMapResultSetIntoEntity<TEntity> mapper;

	protected RepositoryBase(Connection connection, IMapResultSetIntoEntity<TEntity> mapper, IUnitOfWork uow) {
		this.uow = uow;
		this.connection = connection;
		this.mapper = mapper;
		try {
			createTable = connection.createStatement();
			createTableIfNotExists();
			insert = connection.prepareStatement(insertSql());
			delete = connection.prepareStatement(deleteSql());
			update = connection.prepareStatement(updateSql());
			selectById = connection.prepareStatement(selectByIdSql());
			selectAll = connection.prepareStatement(selectAllSql());
			selectLastId = connection.prepareStatement(selectLastIdSql());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLastId() {
		try {
			ResultSet rs = selectLastId.executeQuery();
			while (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public TEntity get(int id) {
		try {

			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while (rs.next()) {
				return mapper.map(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<TEntity> getAll() {
		try {
			List<TEntity> result = new ArrayList<TEntity>();
			ResultSet rs = selectAll.executeQuery();
			while (rs.next()) {
				result.add(mapper.map(rs));
			}
			return result;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void add(TEntity entity) {
		uow.markAsNew(new Entity(entity), this);

	}

	public void delete(TEntity entity) {
		uow.markAsDeleted(new Entity(entity), this);

	}

	public void update(TEntity entity) {
		uow.markAsChanged(new Entity(entity), this);
	}

	public void persistAdd(Entity entity) {
		try {
			setInsert((TEntity) entity.getEntity());
			insert.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void persistUpdate(Entity entity) {
		try {
			setUpdate((TEntity) entity.getEntity());
			update.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void persistDelete(Entity entity) {
		try {
			delete.setInt(1, ((TEntity) entity.getEntity()).getId());
			delete.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void createTableIfNotExists() throws SQLException {
		boolean tableExists = false;
		ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
		while (rs.next()) {
			if (rs.getString("TABLE_NAME").equalsIgnoreCase(tableName())) {
				tableExists = true;
				break;
			}
		}
		if (!tableExists)
			createTable.executeUpdate(createTableSql());
	}

	protected String deleteSql() {
		return "DELETE FROM " + tableName() + " WHERE id = ?";
	}

	protected String selectByIdSql() {
		return "SELECT * FROM " + tableName() + " WHERE id=?";
	}

	protected String selectAllSql() {
		return "SELECT * FROM " + tableName();
	}
	
	protected String selectLastIdSql() {
		return "SELECT TOP 1 id FROM " + tableName()+ " ORDER BY id DESC";
	}

	protected abstract void setInsert(TEntity entity) throws SQLException;

	protected abstract void setUpdate(TEntity entity) throws SQLException;

	protected abstract String tableName();

	protected abstract String createTableSql();

	protected abstract String insertSql();

	protected abstract String updateSql();
}
