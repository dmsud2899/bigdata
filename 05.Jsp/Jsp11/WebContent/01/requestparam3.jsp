<%@ page import = "java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 11-1</title>
</head>
<body>
	
	<%
		String name, id, pw, major, protocol;
		String[] hobbys;
	%>
	
	<%
		String sType = request.getMethod();
	if(sType.equals("POST"))
	{
		response.sendRedirect("error40A.html");
	}
	request.setCharacterEncoding("UTF-8");


	
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		major = request.getParameter("major");
		protocol = request.getParameter("protocol");
		
		hobbys = request.getParameterValues("hooby");
	
	%>

</body>
</html>