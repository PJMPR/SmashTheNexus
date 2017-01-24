package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Team;

@WebServlet("/teamServlet2")
public class teamServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Team team2 = new Team();
		team2.setId(1);
		team2.setName(request.getParameter("name"));
		team2.setWins(Integer.parseInt(request.getParameter("wins")));
		team2.setLoses(Integer.parseInt(request.getParameter("loses")));
		team2.setFormDate(Integer.parseInt(request.getParameter("formDate")));
		team2.setShortName(request.getParameter("shortName"));

		HttpSession session = request.getSession();
		session.setAttribute("t2", team2);
		response.sendRedirect("addTeamMember2.html");
	}

}
