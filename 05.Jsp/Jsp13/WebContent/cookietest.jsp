<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 13</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for(int i=0; i<cookies.length; i++)
			{
				out.println(cookies[i].getName() + " : " +
							cookies[i].getValue() + "<br>");
			}

		}
	%>

</body>
</html>