import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionEx
{
	static 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			con.setAutoCommit(false);
			
			//-----------------------------------------------------
			String sql = "insert into test2 values('홍길동', '1111')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("11111");
			
			sql = "insert into test2 values('전우치', '2222')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("2222");
			
			sql = "insert into test2 values('손오공', '3333')";	// )없애서 에러 유도
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("3333");
			
			success = true;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch(SQLException sqle) {}
		}
	}

}


