<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp/Servlet 12-3 : 파라미터를 보내고 싶을 때</title>
</head>
<body>
	<jsp:forward page="forward_param.jsp">
		<jsp:param name ="id" value="abcdef" />
		<jsp:param name ="pw" value="1234" />
	</jsp:forward>
</body>
</html>
