<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 10-2</title>
</head>
<body>

	<h1> include.jsp 페이지 입니다.</h1>
	<%@ include file = "include01.jsp" %>
	<h1>다시 include.jsp 페이지 입니다.</h1>

</body>
</html>
<!-- 
include지시자 : 
현재 페이지 내에 다른 페이지를 삽입할 때 사용,
file 속성을 이용
 -->