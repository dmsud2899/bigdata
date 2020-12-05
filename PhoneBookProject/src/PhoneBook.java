import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class PhoneBook
{

	static Scanner sc = new Scanner(System.in);
	static Map<String, PhoneInfo> map = new HashMap<>();	
	
	static Connection con = null;
	static PreparedStatement stmt = null;
	static PreparedStatement add = null;
	static PreparedStatement sel = null;
	static PreparedStatement del = null;
	static PreparedStatement save = null;
	static ResultSet rs = null;
	static String sql = null;
	
	public static void showMenu()
	{
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 입력");
		System.out.println("2.전화번호 검색");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.종료");
		System.out.print("선택 : ");
	}
	
	public static void addNumber()
	{
		try
		{
			PreparedStatement add = null;
			String sql = "insert into phbook values(?, ?, ?)";
			add = con.prepareStatement(sql);
			System.out.print("이름 : ");
			String phId = sc.next();
			System.out.print("전화번호 : ");
			String phNum = sc.next();
			System.out.print("이메일 : ");
			String email = sc.next();
			add.setString(1,  phId);
			add.setString(2,  phNum);
			add.setString(3,  email);
			rs = add.executeQuery();		//update
			
			PhoneInfo pInfo;
			if (email != null && !email.equals(""))			
				pInfo = new PhoneInfo(phId, phNum, email);
			else
				pInfo = new PhoneInfo(phId, phNum);
			
			pInfo.showPhoneInfo();
			map.put(phId,pInfo);							
			System.out.println("오늘 등록수 : " + map.size());
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public static void selNumber()
	{
		try
		{
			sql = "select * from phbook "
				+ " where phId = ?";
			sel = con.prepareStatement(sql);
			System.out.println("----------------------------------------");
			System.out.print("검색할 이름 : ");
			String phId = sc.next();
			sel.setString(1,  phId);
			sel.executeUpdate();
			PhoneInfo pInfo = map.get(phId);
			
			if(pInfo != null)
				pInfo.showPhoneInfo();
			else
				System.out.println("[" + phId + "] 데이터가 없습니다.");
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
	}
	
	public static void delNumber()
	{
		try
		{
			sql = "delete from phbook "
					+ "where phId = ?";
			del = con.prepareStatement(sql);
			System.out.println("----------------------------------------");
			System.out.print("삭제할 이름 : ");
			String phId = sc.next();
			del.setString(1,  phId);
			del.executeUpdate();
			PhoneInfo pInfo = map.remove(phId);
			
			if(pInfo != null)
				{
					System.out.println("삭제되었습니다.");
					pInfo.showPhoneInfo();
				}
			else
				System.out.println("[" + phId + "] 데이터가 없습니다.");
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
	}
	
	public static void saveInfo()
	{
		try
		{
			con.commit();
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public static void readInfo()
	{										
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		PhoneBook mpb = new PhoneBook();
		int choice;
		try
		{
			while(true)
			{
				readInfo();	
				showMenu();
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice)
				{
					case 1:
						addNumber();
						break;
					case 2:
						selNumber();
						break;
					case 3:
						delNumber();
						break;
					case 4:
						saveInfo();
						System.out.println("프로그램을 종료합니다.");
						return;	
					default:
						System.out.println("잘 못 입력하셨습니다.");
						break;
								
							
				}
			}
		}
		finally
		{
			try
			{
				if (rs != null) rs.close();		
				if (add != null) add.close();
				if (sel != null) sel.close();
				if (del != null) del.close();
				if (save != null) save.close();
				if (con != null) con.close();
			}
			catch(SQLException sqle) {}
		}
		
	}
}

