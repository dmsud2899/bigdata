import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
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
		try
		{
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			//----------------------------------------------------
			StringBuffer sb = new StringBuffer();
			sb.append("create table test1 ( ");
			sb.append(" id varchar2(10), ");
			sb.append(" age number ) ");
			
			int updateCount = 
					stmt.executeUpdate(sb.toString());	//0으로 나오면 제대로 작동한 것
			System.out.println("createCount : " + updateCount);
			
			//----------------------------------------------------
			sb.setLength(0);		//buffer내용 지움
			sb.append("insert into test1 ");	
			sb.append("values ('홍길동', 10)"); //string할 때 에러가 안나오려면 'value' 앞 띄어쓰기
			updateCount = stmt.executeUpdate(sb.toString());	//buffer쓸 떄 string으로 형변환
			System.out.println("insertCount : " + updateCount); //된게 없으면 0
			
			//----------------------------------------------------
			sb.setLength(0);
			sb.append("select * from test1");
			ResultSet rs = stmt.executeQuery(sb.toString()); //query: 홍길동이 여러명 일 수도 있으니까
			while(rs.next())	//while: 홍길동이 여러명 일 수도 있으니까
			{
				System.out.print("id : " + rs.getString(1) + ", ");
				System.out.println("age : " + rs.getString("age"));
			}
			
			//----------------------------------------------------
			sb.setLength(0);
			sb.append("update test1 ");		//sql 명령문이 붙어서 오류나는 것 대비 하여 띄어쓰기
			sb.append(" set id = '전우치', ");
			sb.append(" age = 20 ");
			sb.append(" where id = '홍길동'");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("updateCount : " + updateCount);
			
			//----------------------------------------------------
			sb.setLength(0);
			sb.append("select * from test1");
			rs = stmt.executeQuery(sb.toString());
			while(rs.next())
			{
				System.out.print("id : " + rs.getString(1) + ", ");
				System.out.println("age : " + rs.getString("age"));
			}
						
			//----------------------------------------------------
			sb.setLength(0);
			sb.append("delete from test1");		//delete된 숫자 만큼, 없으면 0
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("deleteCount : " + updateCount);
			
			//----------------------------------------------------
			sb.setLength(0);
			sb.append("drop table test1");		//되면 숫자 0, 안되면 에러인 마이너스 숫자
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("dropCount : " + updateCount);
			
			//----------------------------------------------------
			rs.close();		//메모리에 올라온 result set을 닫아줌
			stmt.close();	//droptable
			con.close();	//안하면, connection을 혼자 계속 유지 하게 됨
			
		}
		catch(SQLException sqle)
		{
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
	}

}





