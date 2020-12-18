package com.study.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDao
{
// context.html수정했기 때문에 필요 없음
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String uid = "scott";
//	private String upw = "tiger";

	private DataSource dataSource;
	
	public MemberDao()
	{
		try
		{
			// oracel에서 start시키고 하는 것처럼 드라이버는 로드해야 함
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			// lookup 함수의 파라미터는 context.xml에 설정된 name과 동일해야 함
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch(Exception e)
		{
			System.out.println("=======================\n");
			e.printStackTrace();
		}
	}


	public ArrayList<MemberDto> memberSelect()
	{
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while (rs.next())
			{
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				
				MemberDto dto = new MemberDto(id, pw, name, phone, gender);
				dtos.add(dto);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return dtos;
		
	}
	
	//MemberDAO에 insert기능 추가
	public int memberInsert(MemberDto dto)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into member values (?,?,?,?,?)";
		int nResult = 0;
		
		try
		{
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getGender());
			pstmt.executeUpdate();
			nResult = 1;
		}
		catch(Exception e)
		{
//			System.out.println(e.getMessage());
//			ORA-0001: unique constraint (SCOTT.SYS_C007030) violated
//			if (e.getMessage().contains("ORA-00001"))
//			{
//				out.println("중복되는 회원아이디 데이터가 있습니다.")
//			}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return nResult;
	}
}
