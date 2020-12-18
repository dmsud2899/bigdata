<%@ page import = "com.study.jsp.MemberDto" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.study.jsp.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 20-1</title>
</head>
<body>
	<%
		MemberDao memberDAO = new MemberDao();
		ArrayList<MemberDto> dtos = memberDAO.memberSelect();
		
		for(int i=0; i<dtos.size(); i++)
		{
			MemberDto dto = dtos.get(i);
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
			String phone = dto.getPhone();
			String gender = dto.getGender();
			
			out.println("아이디 : " + id + 
		", 비밀번호 : " + pw + 
		", 이름 : " + name +
		", 연락처 : " + phone +
		", 성별 : " + gender + "<br>");
			
		}
	%>
	<hr>
	<a href = ./memberInsert.jsp>멤버 추가</a>
</body>
</html>