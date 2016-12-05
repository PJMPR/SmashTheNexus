package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.model.Team;

public class App 
{
    public static void main( String[] args )
    {
    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	try {
			Connection connection = DriverManager.getConnection(url);
			IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);
			Team team1 = new Team();
			team1.setName("aaa");
			team1.setWins(0);
			team1.setLoses(0);
			team1.setFormDate(2015);
			team1.setShortName("a");
			catalog.teams().add(team1);
			catalog.teams().withShortName("a");
			catalog.saveAndClose();
		}
    	
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "Koniec" );
        
    }
}
