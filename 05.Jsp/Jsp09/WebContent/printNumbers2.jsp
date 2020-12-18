<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>PrintNumbers2</title>
</head>
<body>

<%
	//내부객체 : 객체를 생성하지 않고 바로 사용할 수 있는 객체
	//JSP에서 제공되는 내부객체는 JSP컨테이너에 의해 Servlet으로 변화될 때 자동 객체 생성
	//request = 내부객체
	String max = request.getParameter("max");
	int maxValue = Integer.parseInt(max);
	
	for(int i=0; i<maxValue; i++)
	{
		out.println(i+"<br>");
	}
	//run 시키고 url 마지막에 ?max=5
%>

</body>
</html>