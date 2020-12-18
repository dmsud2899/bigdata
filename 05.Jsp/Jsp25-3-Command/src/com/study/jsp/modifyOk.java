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


public class modifyOk implements Service {
	
    public modifyOk() 
    {

    }

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("modifyOk");
		
		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String eMail= request.getParameter("eMail");
		String address= request.getParameter("address");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MemberDto dto = new MemberDto();

		HttpSession session = request.getSession();
		
		id =(String)session.getAttribute("id");
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.seteMail(eMail);
		dto.setAddress(address);
		
		MemberDao dao = MemberDao.getInstance();
		int ri = dao.upadateMember(dto);
		
		if(ri == 1)
		{
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language = \"javascript\">");
			writer.println("	alert(\"정보가 수정되었습니다.\");");
			writer.println("	document.location.href=\"main.jsp\";");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
		else
		{
			writer.println("<html><head></head><body>");
			writer.println("<script language = \"javascript\">");
			writer.println("	alert(\"정보수정에 실패하였습니다.\");");
			writer.println("	history.go(-1);");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
	}

}
