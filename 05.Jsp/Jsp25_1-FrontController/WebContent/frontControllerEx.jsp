<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet :.do서블릿</title>
<!-- 확장자 형태로 서버의 해당 컴포넌트를 찾아 실행하는 구조 -->
</head>
<body>
	<a href="insert.do">insert</a>
	<hr />
	<a href="http://localhost:8081<%=request.getContextPath() %>/update.do">update</a>
	<hr />
	<a href="http://localhost:8081/Jsp25_1/select.do">select</a>
	<hr />
	<a href="<%=request.getContextPath() %>/delete.do">delete</a>
</body>
</html>