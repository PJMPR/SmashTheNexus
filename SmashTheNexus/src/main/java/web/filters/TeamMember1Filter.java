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

import domain.model.TeamMember;

@WebFilter(urlPatterns={"/addTeam2.html","/addTeamMember2.html","/addMatch.html","/matchServlet","/teamMemberServlet2","/teamServlet2","/view.jsp"})
public class TeamMember1Filter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		TeamMember t1m1 = (TeamMember) session.getAttribute("t1m1");
		if(t1m1==null){
			((HttpServletResponse) response).sendRedirect("/addTeamMember1.html");
		}
		else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}