package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.model.Match;
import domain.model.Team;
import domain.model.TeamMember;

public class App {
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);
			
			Team team1 = new Team();
			team1.setName("Flashing Fangs");
			team1.setWins(1);
			team1.setLoses(0);
			team1.setFormDate(2015);
			team1.setShortName("FFN");
			catalog.teams().add(team1);

			Team team2 = new Team();
			team2.setName("Ragnarok");
			team2.setWins(0);
			team2.setLoses(1);
			team2.setFormDate(2013);
			team2.setShortName("RGN");
			catalog.teams().add(team2);
			
			TeamMember t1tm1 = new TeamMember();
			t1tm1.setName("Jack");
			t1tm1.setSurname("Smith");
			t1tm1.setNick("Guarm");
			t1tm1.setAge(20);
			t1tm1.setCountry("England");
			t1tm1.setFavouriteChampion("Cassiopeia");
			catalog.teamMembers().add(t1tm1);
			
			TeamMember t1tm2 = new TeamMember();
			t1tm2.setName("Johanna");
			t1tm2.setSurname("Claw");
			t1tm2.setNick("Clawreen");
			t1tm2.setAge(17);
			t1tm2.setCountry("Canada");
			t1tm2.setFavouriteChampion("Rengar");
			catalog.teamMembers().add(t1tm2);
			
			TeamMember t1tm3 = new TeamMember();
			t1tm3.setName("Jan");
			t1tm3.setSurname("Tarczyński");
			t1tm3.setNick("Shield");
			t1tm3.setAge(23);
			t1tm3.setCountry("Poland");
			t1tm3.setFavouriteChampion("Leona");
			catalog.teamMembers().add(t1tm3);
			
			TeamMember t1tm4 = new TeamMember();
			t1tm4.setName("Elżbieta");
			t1tm4.setSurname("Strzelnicka");
			t1tm4.setNick("SwiftArrow");
			t1tm4.setAge(19);
			t1tm4.setCountry("Poland");
			t1tm4.setFavouriteChampion("Kindred");
			catalog.teamMembers().add(t1tm4);
			
			TeamMember t1tm5 = new TeamMember();
			t1tm5.setName("Akira");
			t1tm5.setSurname("Kenmura");
			t1tm5.setNick("FastSlam");
			t1tm5.setAge(18);
			t1tm5.setCountry("Japan");
			t1tm5.setFavouriteChampion("Illaoi");
			catalog.teamMembers().add(t1tm5);
			
			TeamMember t2tm1 = new TeamMember();
			t2tm1.setName("Ronald");
			t2tm1.setSurname("Bush");
			t2tm1.setNick("Cleave");
			t2tm1.setAge(20);
			t2tm1.setCountry("England");
			t2tm1.setFavouriteChampion("Olaf");
			catalog.teamMembers().add(t2tm1);
			
			TeamMember t2tm2 = new TeamMember();
			t2tm2.setName("Eyir");
			t2tm2.setSurname("Lightshield");
			t2tm2.setNick("DieAlone");
			t2tm2.setAge(17);
			t2tm2.setCountry("Norway");
			t2tm2.setFavouriteChampion("Braum");
			catalog.teamMembers().add(t2tm2);
			
			TeamMember t2tm3 = new TeamMember();
			t2tm3.setName("Olaf");
			t2tm3.setSurname("Nothex");
			t2tm3.setNick("Olvarn");
			t2tm3.setAge(23);
			t2tm3.setCountry("Norway");
			t2tm3.setFavouriteChampion("Orianna");
			catalog.teamMembers().add(t2tm3);
			
			TeamMember t2tm4 = new TeamMember();
			t2tm4.setName("Catherine");
			t2tm4.setSurname("Sheer");
			t2tm4.setNick("Druid");
			t2tm4.setAge(19);
			t2tm4.setCountry("Poland");
			t2tm4.setFavouriteChampion("Ivern");
			catalog.teamMembers().add(t2tm4);
			
			TeamMember t2tm5 = new TeamMember();
			t2tm5.setName("Tokura");
			t2tm5.setSurname("Shizuka");
			t2tm5.setNick("Machinizer");
			t2tm5.setAge(18);
			t2tm5.setCountry("Japan");
			t2tm5.setFavouriteChampion("Corki");
			catalog.teamMembers().add(t2tm5);
			
			Match m1 = new Match();
			m1.setDate(new Date(2016-1900,11-1,11));
			m1.setResult("3:0");
			m1.setBestOf(3);
			catalog.matches().add(m1);

			catalog.saveAndClose();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Koniec");

	}
}
