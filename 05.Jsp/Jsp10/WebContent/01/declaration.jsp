<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp10</title>
</head>
<body>
	
<%! //JSP 페이지 내에서 사용되는 변수 또는 메소드를 선언할 때 사용
	//여기서 선언된 변수 및 메소드는 전역의 의미
	int i = 10;
	String str = "ABCDE";
%>

<%!	//함수도선언
	private int sum (int a, int b)
	{
		return a+b;
	}
%>

<%	//지역변수
	out.println("i = " + i + "<br>");
	out.println("str = " + str + "<br>");
	out.println("sum = " + sum(1,5) + "<br>");
%>
	
</body>
</html>