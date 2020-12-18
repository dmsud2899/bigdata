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
		
		session.invalidate();
		// 세션의 모든 데이터 삭제
		// 빈객로 남아있게 됨
		
		response.sendRedirect("login.html");
	%>

</body>
</html>

<!-- 
쿠키의 문제점 : 파일이기 때문에 다른 사람이 가져가서 사용할 수 있음
 -->