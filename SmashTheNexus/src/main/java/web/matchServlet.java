package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Match;

@WebServlet("/matchServlet")
public class matchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Match match = new Match();
		match.setDate(Date.valueOf(request.getParameter("date")));
		match.setResult(request.getParameter("result"));
		match.setBestOf(Integer.parseInt(request.getParameter("bestOf")));
		session.setAttribute("match", match);
		response.sendRedirect("view.jsp");
	}

}
