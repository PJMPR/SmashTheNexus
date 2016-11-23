package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.MatchRepository;
import dao.TeamMemberRepository;
import dao.TeamRepository;

public class App 
{
    public static void main( String[] args )
    {
    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	try {
			Connection connection = DriverManager.getConnection(url);
			MatchRepository matchrepo = new MatchRepository(connection);
			TeamMemberRepository tmrepo = new TeamMemberRepository(connection);
			TeamRepository accountRepo = new TeamRepository(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "Koniec" );
        
    }
}
