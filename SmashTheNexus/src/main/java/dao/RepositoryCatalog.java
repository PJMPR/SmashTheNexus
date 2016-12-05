package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.MatchMapper;
import dao.mappers.TeamMapper;
import dao.mappers.TeamMemberMapper;
import dao.uow.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog{

	IUnitOfWork uow;
	Connection connection;
	
	
	public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
		super();
		this.uow = uow;
		this.connection = connection;
	}

	
	public IMatchRepository matches() {
		return new MatchRepository(connection, new MatchMapper(), uow);
	}


	public ITeamRepository teams() {
		return new TeamRepository(connection, new TeamMapper(), uow);
	}


	public ITeamMemberRepository teamMembers() {
		return new TeamMemberRepository(connection, new TeamMemberMapper(), uow);
	}

	public void saveAndClose() {
		try{
		uow.commit();
		connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

}
