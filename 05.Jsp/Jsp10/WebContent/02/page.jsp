<%@ page import ="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp10</title>
</head>
<body>
<%
	int[] iArr = {10, 20, 30};
	out.println( Arrays.toString(iArr) );
	
	//JSP페이지의 전체적인 속성을 지정할 때 사용
	//page, include, taglib가 있으며, <%@ 속성 형태로 사용
%>
</body>
</html>