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
		request.setCharacterEncoding("UTF-8");
	
		Object obj1 = session.getAttribute("id");
		String sId = (String)obj1;
		//object가 어떤 형태로 들어올지 모름. 따라서 일단 빈 객체를 생성
		//id는 어차피 글자이기 때문에 string으로 형변환

		
		if(sId == null)
		{
			response.sendRedirect("login.html");
		}
		else
		{
			out.println(sId + "님 안녕하세요." + "<br>");
		}
	%>
	
	<a href = "logOut.jsp">로그아웃</a> <br><p>
	<a href = "sessiontest.jsp">세션 테스트</a>

</body>
</html>