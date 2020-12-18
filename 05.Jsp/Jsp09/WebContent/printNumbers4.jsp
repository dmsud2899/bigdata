<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>PrintNumbers4</title>
</head>
<body>

<%
	//request = 내부객체
	String max = request.getParameter("max");
	if ( max!= null)
	{
		try
		{
			int maxValue = Integer.parseInt(max);
			for(int i=0; i<maxValue; i++)
			{
				out.println(i+"<br>");
			}
		}
		catch(NumberFormatException ne)
		{
			out.println("<h1>'max' value should be NUMBER !!!<h1>");
		}
	}
	else
	{
		out.println("<h1>You must set 'max' parameter!!!");
	}
	//run 시키고 url 마지막에 ?max=5
%>

</body>
</html>