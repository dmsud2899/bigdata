<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 12-1</title>
</head>
<body>
	<h1>main.jsp 페이지입니다.</h1>
	<jsp:forward page ="sub.jsp" /> 
	<!--
	액션태그 :  forward 
	현재 페이지에서 다른 특정 페이지로 전환할 때 사용.
	request send 
	-->
</body>
</html>