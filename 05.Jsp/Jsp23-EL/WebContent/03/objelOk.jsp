<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Serlvet 23-3 내장객체</title>
</head>
<body>	
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	
	아이디 : <%=id %><br>
	비밀번호 : <%=pw %><br>
	
	<hr>
	
	아이디 : ${param.id }<br>
	비밀번호 : ${param.pw }<br>
	아이디: ${param["id"] }<br>
	비밀번호: ${param["pw"] }
	
	<hr>
	
	applicationScope : ${applicationScope.application_name }<br>
	sessionScope : ${sessionScope.session_name }<br>
	requestScope : ${requestScopte.request_name }<br>
	pageScope : ${pageScope.page_name }
	
	<hr>
	
	context 초기화 파라미터<br>
	${initParam.con_name }<br>
	${initParam.con_id }<br>
	${initParam.con_pw }<br>
</body>
</html>