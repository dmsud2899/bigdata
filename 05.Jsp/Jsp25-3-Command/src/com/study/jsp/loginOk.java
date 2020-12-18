package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginOk implements Service {
	
    public loginOk() 
    {

    }

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("loginOk");
		
		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MemberDao dao = MemberDao.getInstance();
		if(dao.userCheck(id,pw) == MemberDao.MEMBER_LOGIN_SUCCESS)
		{
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language = \"javascript\">");
			writer.println("	alert(\"로그인에 성공하였습니다.\");");
			writer.println("	document.location.href=\"main.jsp\";");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
			
			MemberDto dto = dao.getMember(id);
			name = dto.getName();
			HttpSession session = request.getSession();
			
			session.setAttribute("id", id);
			session.setAttribute("name", name);
		}
		else if(dao.userCheck(id,pw) == MemberDao.MEMBER_LOGIN_PW_NO_GOOD)
		{
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language = \"javascript\">");
			writer.println("	alert(\"비밀번호가 일치하지 않습니다.\");");
			writer.println("	history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
		else if(dao.userCheck(id,pw) == MemberDao.MEMBER_LOGIN_IS_NOT)
		{
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language = \"javascript\">");
			writer.println("	alert(\"존재하지 않는 아이디입니다.\");");
			writer.println("	history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
	}

}
