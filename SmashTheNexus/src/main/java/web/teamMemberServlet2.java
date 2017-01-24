package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Team;
import domain.model.TeamMember;

@WebServlet("/teamMemberServlet2")
public class teamMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Team team2 = (Team) session.getAttribute("t2");
		if(team2 == null){
			response.sendRedirect("addTeam2.html");
		}
		TeamMember teamMember1 = new TeamMember();
		teamMember1.setName(request.getParameter("name1"));
		teamMember1.setSurname(request.getParameter("surname1"));
		teamMember1.setNick(request.getParameter("nick1"));
		teamMember1.setAge(Integer.parseInt(request.getParameter("age1")));
		teamMember1.setCountry(request.getParameter("country1"));
		teamMember1.setFavouriteChampion(request.getParameter("favouriteChampion1"));
		teamMember1.setTeamID(team2.getId());
		session.setAttribute("t2m1", teamMember1);
		TeamMember teamMember2 = new TeamMember();
		teamMember2.setName(request.getParameter("name2"));
		teamMember2.setSurname(request.getParameter("surname2"));
		teamMember2.setNick(request.getParameter("nick2"));
		teamMember2.setAge(Integer.parseInt(request.getParameter("age2")));
		teamMember2.setCountry(request.getParameter("country2"));
		teamMember2.setFavouriteChampion(request.getParameter("favouriteChampion2"));
		teamMember2.setTeamID(team2.getId());
		session.setAttribute("t2m2", teamMember2);
		TeamMember teamMember3 = new TeamMember();
		teamMember3.setName(request.getParameter("name3"));
		teamMember3.setSurname(request.getParameter("surname3"));
		teamMember3.setNick(request.getParameter("nick3"));
		teamMember3.setAge(Integer.parseInt(request.getParameter("age3")));
		teamMember3.setCountry(request.getParameter("country3"));
		teamMember3.setFavouriteChampion(request.getParameter("favouriteChampion3"));
		teamMember3.setTeamID(team2.getId());
		session.setAttribute("t2m3", teamMember3);
		TeamMember teamMember4 = new TeamMember();
		teamMember4.setName(request.getParameter("name4"));
		teamMember4.setSurname(request.getParameter("surname4"));
		teamMember4.setNick(request.getParameter("nick4"));
		teamMember4.setAge(Integer.parseInt(request.getParameter("age4")));
		teamMember4.setCountry(request.getParameter("country4"));
		teamMember4.setFavouriteChampion(request.getParameter("favouriteChampion4"));
		teamMember4.setTeamID(team2.getId());
		session.setAttribute("t2m4", teamMember4);
		TeamMember teamMember5 = new TeamMember();
		teamMember5.setName(request.getParameter("name5"));
		teamMember5.setSurname(request.getParameter("surname5"));
		teamMember5.setNick(request.getParameter("nick5"));
		teamMember5.setAge(Integer.parseInt(request.getParameter("age5")));
		teamMember5.setCountry(request.getParameter("country5"));
		teamMember5.setFavouriteChampion(request.getParameter("favouriteChampion5"));
		teamMember5.setTeamID(team2.getId());
		session.setAttribute("t2m5", teamMember5);
		response.sendRedirect("addMatch.html");
	}

}
