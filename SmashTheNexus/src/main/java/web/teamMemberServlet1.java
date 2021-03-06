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

@WebServlet("/teamMemberServlet1")
public class teamMemberServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Team team1 = (Team) session.getAttribute("t1");
		if(team1 == null){
			response.sendRedirect("addTeam1.html");
		}
		TeamMember teamMember1 = new TeamMember();
		teamMember1.setName(request.getParameter("name1"));
		teamMember1.setSurname(request.getParameter("surname1"));
		teamMember1.setNick(request.getParameter("nick1"));
		teamMember1.setAge(Integer.parseInt(request.getParameter("age1")));
		teamMember1.setCountry(request.getParameter("country1"));
		teamMember1.setFavouriteChampion(request.getParameter("favouriteChampion1"));
		session.setAttribute("t1m1", teamMember1);
		TeamMember teamMember2 = new TeamMember();
		teamMember2.setName(request.getParameter("name2"));
		teamMember2.setSurname(request.getParameter("surname2"));
		teamMember2.setNick(request.getParameter("nick2"));
		teamMember2.setAge(Integer.parseInt(request.getParameter("age2")));
		teamMember2.setCountry(request.getParameter("country2"));
		teamMember2.setFavouriteChampion(request.getParameter("favouriteChampion2"));
		session.setAttribute("t1m2", teamMember2);
		TeamMember teamMember3 = new TeamMember();
		teamMember3.setName(request.getParameter("name3"));
		teamMember3.setSurname(request.getParameter("surname3"));
		teamMember3.setNick(request.getParameter("nick3"));
		teamMember3.setAge(Integer.parseInt(request.getParameter("age3")));
		teamMember3.setCountry(request.getParameter("country3"));
		teamMember3.setFavouriteChampion(request.getParameter("favouriteChampion3"));
		session.setAttribute("t1m3", teamMember3);
		TeamMember teamMember4 = new TeamMember();
		teamMember4.setName(request.getParameter("name4"));
		teamMember4.setSurname(request.getParameter("surname4"));
		teamMember4.setNick(request.getParameter("nick4"));
		teamMember4.setAge(Integer.parseInt(request.getParameter("age4")));
		teamMember4.setCountry(request.getParameter("country4"));
		teamMember4.setFavouriteChampion(request.getParameter("favouriteChampion4"));
		session.setAttribute("t1m4", teamMember4);
		TeamMember teamMember5 = new TeamMember();
		teamMember5.setName(request.getParameter("name5"));
		teamMember5.setSurname(request.getParameter("surname5"));
		teamMember5.setNick(request.getParameter("nick5"));
		teamMember5.setAge(Integer.parseInt(request.getParameter("age5")));
		teamMember5.setCountry(request.getParameter("country5"));
		teamMember5.setFavouriteChampion(request.getParameter("favouriteChampion5"));
		session.setAttribute("t1m5", teamMember5);
		response.sendRedirect("addTeam2.html");
	}

}
