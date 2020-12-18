<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Jsp10</title>
</head>
<body>
<%!
	int i = 10;
	String str = "abc";
	
	private int sum(int a, int b)
	{
		return a+b;
	}
	//JSP페이지 내에서 사용되는 변수의 값 또는 메소드 호출 결과값을 출력하기 위해
	//사용. 결과값은 String타입이며, ','를 사용할 수 없음
%>

숫자 i의 값은 <%= i %>입니다. <br>
문자변수에는 <%= str %>값이 저장되어 있습니다.<br>
두 수의 합은 <%= sum(1,5) %>입니다.
</body>
</html>