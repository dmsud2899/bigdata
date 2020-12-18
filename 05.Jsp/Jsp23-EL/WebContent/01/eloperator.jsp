<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet23-1</title>
</head>
<body>
<!-- EL이란 표현식 또는 액션 태그를 대신해서 값을 표현하는 언어 -->
	<!-- ${value} -->
	${1+2}<br>
	${1-2 }<br>
	${1*2 }<br>
	${1>2 }<br>
	${1<2 }<br>
	${(1>2) ? 1:2 }<br>
	${(1>2) || (1<2) }<br>
</body>
</html>