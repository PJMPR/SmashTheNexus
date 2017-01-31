package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Team;

@WebServlet("/teamServlet1")
public class teamServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Team team1 = new Team();
		team1.setName(request.getParameter("name"));
		team1.setWins(Integer.parseInt(request.getParameter("wins")));
		team1.setLoses(Integer.parseInt(request.getParameter("loses")));
		team1.setFormDate(Integer.parseInt(request.getParameter("formDate")));
		team1.setShortName(request.getParameter("shortName"));

		HttpSession session = request.getSession();
		session.setAttribute("t1", team1);
		response.sendRedirect("addTeamMember1.html");
	}

}
