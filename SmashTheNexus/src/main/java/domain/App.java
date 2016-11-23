package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.MatchRepository;
import dao.TeamMemberRepository;
import dao.TeamRepository;
import domain.model.Team;
import domain.model.TeamMember;

public class App 
{
    public static void main( String[] args )
    {
    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	try {
			Connection connection = DriverManager.getConnection(url);
			MatchRepository matchrepo = new MatchRepository(connection);
			TeamMemberRepository tmrepo = new TeamMemberRepository(connection);
			TeamRepository trepo = new TeamRepository(connection);
		
			TeamMember Aaa = new TeamMember();
			Aaa.setName("Marta");
			Aaa.setSurname("Skrajda");
			Aaa.setNick("Scrayth");
			
			

	        System.out.println( "zapisuje gracza" );
			tmrepo.add(Aaa);
			
		}
    	
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "Koniec" );
        
    }
}
