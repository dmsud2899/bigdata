import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test2
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
		Scanner sc = new Scanner(System.in);
		try
		{
			Connection con = null;
			Statement stmt = con.createStatement();
			PreparedStatement pstmt1 = null;
			ResultSet rs = null;
			
			//-----------------------------------------------------
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			String sql = "select * from employee"
						+ "where salary > ?"
						+ "and dno = ?";
			pstmt1 = con.prepareStatement(sql);
			rs = pstmt1.executeQuery(sql);
			
			System.out.print("부서번호 : ");
			String num1 = sc.next();
			System.out.print("급여 : ");
			String num2 = sc.next();
			pstmt1.setString(1, num1);
			pstmt1.setString(2, num2);
			
			System.out.println("사원번호\t사원이름\t급여\t부서번호");
			System.out.println("--------------------------------------");
			while(rs.next())
			{
				System.out.print(rs.getString("eno") + '\t');
				System.out.print(rs.getString("ename") + '\t');
				System.out.print(rs.getString(1) + '\t');
				System.out.println(rs.getString(2));
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException sqle)
		{
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
	}


}

/////////////다시


