<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 21-1</title>
<script src = "http://code.jquery.com/jquery.js"></script>
	<script>
	function form_check()
	{
		submit_ajax();
	}
	
	function submit_ajax()
	{
		var queryString = $("#members").serialize();
		$.ajax
		({
			url: '/Jsp21-2-Ajax/members',
			type: 'POST',
			data: queryString,
			dataType: 'json',
			success: function(json)
			{
				var results = eval(json);
				console.log(results);
				if(results[0].result =="ok")
				{
					window.location.replace("login.jsp");
				}
				else
				{
					alert(results[0].desc);
				}
			}	
		});
	}
	</script>
</head>
<body>
	<form action="joinOk.jsp" method="post" name="reg_frm">
		아이디 :  <input type="text" name="id" size="20"><br>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br>
		이름 : <input type="text" name="name" size="20"><br>
		메일 : <input type="text" name="eMail" size="20"><br>
		주소 : <input type="text" name="address" size="50"><br>
		<input type = "button" value="회원가입" onclick="infoConfirm()">&nbsp;
		<input type = "reset" value="로그인" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>