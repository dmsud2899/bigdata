<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 13</title>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");
	
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null)
	{
		for(int i=0; i<cookies.length; i++)
		{
			cookies[i].setMaxAge(0); //쿠키 유횩기간 0
			response.addCookie(cookies[i]);
		}
	}
	
	response.sendRedirect("login.html");
	
	%>

</body>
</html>

<!-- 
쿠키의 문제점 : 파일이기 때문에 다른 사람이 가져가서 사용할 수 있음
 -->