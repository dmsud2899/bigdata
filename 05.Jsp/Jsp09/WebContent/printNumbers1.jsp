<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>PrintNumbers1</title>
</head>
<body>


<%
	//html src에서 자바코드는 안보임 > 만들어진 상태에서 내려감
	for(int i=0; i<10; i++)
	{
		out.println(i+"<br>");
	}
%>

</body>
</html>