<%@page import="domain.model.Match"%>
<%@page import="domain.model.TeamMember"%>
<%@page import="domain.model.Team"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
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
	%>
<h1>Mecz:</h1>
<h2><%=match.getDate() %></h2>
<h2><%=match.getResult() %></h2>
<h2><%=match.getBestOf() %></h2>
<h1>Drużyna 1:</h1>
<h2><%=t1.getName() %></h2>
<h2><%=t1.getWins() %></h2>
<h2><%=t1.getLoses() %></h2>
<h2><%=t1.getFormDate() %></h2>
<h2><%=t1.getShortName() %></h2>
<h1>Członkowie:</h1>
<h2><%=t1m1.getName() %></h2>
<h2><%=t1m1.getSurname() %></h2>
<h2><%=t1m1.getNick() %></h2>
<h2><%=t1m1.getAge() %></h2>
<h2><%=t1m1.getCountry() %></h2>
<h2><%=t1m1.getFavouriteChampion() %></h2>
<h2><%=t1m2.getName() %></h2>
<h2><%=t1m2.getSurname() %></h2>
<h2><%=t1m2.getNick() %></h2>
<h2><%=t1m2.getAge() %></h2>
<h2><%=t1m2.getCountry() %></h2>
<h2><%=t1m2.getFavouriteChampion() %></h2>
<h2><%=t1m3.getName() %></h2>
<h2><%=t1m3.getSurname() %></h2>
<h2><%=t1m3.getNick() %></h2>
<h2><%=t1m3.getAge() %></h2>
<h2><%=t1m3.getCountry() %></h2>
<h2><%=t1m3.getFavouriteChampion() %></h2>
<h2><%=t1m4.getName() %></h2>
<h2><%=t1m4.getSurname() %></h2>
<h2><%=t1m4.getNick() %></h2>
<h2><%=t1m4.getAge() %></h2>
<h2><%=t1m4.getCountry() %></h2>
<h2><%=t1m4.getFavouriteChampion() %></h2>
<h2><%=t1m5.getName() %></h2>
<h2><%=t1m5.getSurname() %></h2>
<h2><%=t1m5.getNick() %></h2>
<h2><%=t1m5.getAge() %></h2>
<h2><%=t1m5.getCountry() %></h2>
<h2><%=t1m5.getFavouriteChampion() %></h2>
<h1>Drużyna 2:</h1>
<h2><%=t2.getName() %></h2>
<h2><%=t2.getWins() %></h2>
<h2><%=t2.getLoses() %></h2>
<h2><%=t2.getFormDate() %></h2>
<h2><%=t2.getShortName() %></h2>
<h1>Członkowie:</h1>
<h2><%=t2m1.getName() %></h2>
<h2><%=t2m1.getSurname() %></h2>
<h2><%=t2m1.getNick() %></h2>
<h2><%=t2m1.getAge() %></h2>
<h2><%=t2m1.getCountry() %></h2>
<h2><%=t2m1.getFavouriteChampion() %></h2>
<h2><%=t2m2.getName() %></h2>
<h2><%=t2m2.getSurname() %></h2>
<h2><%=t2m2.getNick() %></h2>
<h2><%=t2m2.getAge() %></h2>
<h2><%=t2m2.getCountry() %></h2>
<h2><%=t2m2.getFavouriteChampion() %></h2>
<h2><%=t2m3.getName() %></h2>
<h2><%=t2m3.getSurname() %></h2>
<h2><%=t2m3.getNick() %></h2>
<h2><%=t2m3.getAge() %></h2>
<h2><%=t2m3.getCountry() %></h2>
<h2><%=t2m3.getFavouriteChampion() %></h2>
<h2><%=t2m4.getName() %></h2>
<h2><%=t2m4.getSurname() %></h2>
<h2><%=t2m4.getNick() %></h2>
<h2><%=t2m4.getAge() %></h2>
<h2><%=t2m4.getCountry() %></h2>
<h2><%=t2m4.getFavouriteChampion() %></h2>
<h2><%=t2m5.getName() %></h2>
<h2><%=t2m5.getSurname() %></h2>
<h2><%=t2m5.getNick() %></h2>
<h2><%=t2m5.getAge() %></h2>
<h2><%=t2m5.getCountry() %></h2>
<h2><%=t2m5.getFavouriteChampion() %></h2>
<form action="dbServlet" method="get">
<input type="submit" value="Dodaj">
</form>
</body>
</html>