package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Team;

@WebFilter(urlPatterns={"/addTeamMember1.html","/addTeam2.html","/addTeamMember2.html","/addMatch.html","/teamMemberServlet1","/teamMemberServlet2","/teamServlet2","/matchServlet","/view.jsp"})
public class Team1Filter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Team t1 = (Team) session.getAttribute("t1");
		if(t1==null){
			((HttpServletResponse) response).sendRedirect("/addTeam1.html");
		}
		else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}