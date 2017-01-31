package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.model.Match;
import domain.model.Team;
import domain.model.TeamMember;

@WebServlet("/dbServlet")
public class dbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);
			HttpSession session = request.getSession();
			Team t1 = (Team) session.getAttribute("t1");
			TeamMember t1m1 = (TeamMember) session.getAttribute("t1m1");
			TeamMember t1m2 = (TeamMember) session.getAttribute("t1m2");
			TeamMember t1m3 = (TeamMember) session.getAttribute("t1m3");
			TeamMember t1m4 = (TeamMember) session.getAttribute("t1m4");
			TeamMember t1m5 = (TeamMember) session.getAttribute("t1m5");
			Team t2 = (Team) session.getAttribute("t2");
			TeamMember t2m1 = (TeamMember) session.getAttribute("t2m1");
			TeamMember t2m2 = (TeamMember) session.getAttribute("t2m2");
			TeamMember t2m3 = (TeamMember) session.getAttribute("t2m3");
			TeamMember t2m4 = (TeamMember) session.getAttribute("t2m4");
			TeamMember t2m5 = (TeamMember) session.getAttribute("t2m5");
			Match match = (Match) session.getAttribute("match");
			catalog.teams().add(t1);
			catalog.saveAndClose();
			int team1Id = catalog.teams().getLastId();
			t1.setId(team1Id);
			t1m1.setTeam(t1);
			t1m2.setTeam(t1);
			t1m3.setTeam(t1);
			t1m4.setTeam(t1);
			t1m5.setTeam(t1);
			catalog.teamMembers().add(t1m1);
			catalog.saveAndClose();
			catalog.teamMembers().add(t1m2);
			catalog.saveAndClose();
			catalog.teamMembers().add(t1m3);
			catalog.saveAndClose();
			catalog.teamMembers().add(t1m4);
			catalog.saveAndClose();
			catalog.teamMembers().add(t1m5);
			catalog.saveAndClose();
			catalog.teams().add(t2);
			catalog.saveAndClose();
			int team2Id = catalog.teams().getLastId();
			t2.setId(team2Id);
			t2m1.setTeam(t2);
			t2m2.setTeam(t2);
			t2m3.setTeam(t2);
			t2m4.setTeam(t2);
			t2m5.setTeam(t2);
			catalog.teamMembers().add(t2m1);
			catalog.saveAndClose();
			catalog.teamMembers().add(t2m2);
			catalog.saveAndClose();
			catalog.teamMembers().add(t2m3);
			catalog.saveAndClose();
			catalog.teamMembers().add(t2m4);
			catalog.saveAndClose();
			catalog.teamMembers().add(t2m5);
			catalog.saveAndClose();
			match.setFirstTeam(t1);
			match.setSecondTeam(t2);
			catalog.matches().add(match);
			catalog.saveAndClose();
			session.removeAttribute("t1");
			session.removeAttribute("t2");
			session.removeAttribute("t1m1");
			session.removeAttribute("t1m2");
			session.removeAttribute("t1m3");
			session.removeAttribute("t1m4");
			session.removeAttribute("t1m5");
			session.removeAttribute("t2m1");
			session.removeAttribute("t2m2");
			session.removeAttribute("t2m3");
			session.removeAttribute("t2m4");
			session.removeAttribute("t2m5");
			session.removeAttribute("match");
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}