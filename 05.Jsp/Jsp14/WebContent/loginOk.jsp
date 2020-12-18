<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 14</title>
</head>
<body>

	<%
	// 쿠키와 달리 클라이언트의 특정 위치에 저장되는 것이 아니라
	// 서버상에 객체로 존재함
	// 따라서 세션은 서버에서만 접근 가능하여 보안이 좋고,
	// 저장할 수 있는 데이터에 한계가 없음
		String id, pw, name;
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		
		if(id.equals("abcde") && pw.equals("12345"))
		{
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	%>

</body>
</html>