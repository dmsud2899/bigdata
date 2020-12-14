import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibRentSys
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
	
	Connection con;
	Statement logon;
	Statement logm;
	PreparedStatement pstmt1;	//메뉴1
	PreparedStatement pstmt2;
	PreparedStatement pstmt3;

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException,UnknownHostException
	{
		LibRentSys lrs = new LibRentSys();
		lrs.doRunInsert();
//		lrs.connectDatabase();
//		lrs.doRun();
	}
	
	public void doRunInsert()
	{
		int choice;
		connectDatabase2();
		
		while(true)
		{
			showMain();
			try
			{
				choice = sc.nextInt();
				sc.nextLine();
				
				if(choice == 1)
					doRunInsert2();
				else if(choice == 2)
					connectDatabase();
				else if (choice == 3)
					selBoard();
				else if(choice == 0)
				{
						System.out.println("프로그램을 종료합니다.");
						return;	
				}
				else
				{
						System.out.println("잘 못 입력하셨습니다.");
						break;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("숫자를 입력하세요.");
				break;
			}
		}
	}
	
	public void showMain()		
	{							
		System.out.println(" \n\n\n");
		System.out.println("---------------------");
		System.out.println("     메뉴   선택       ");
		System.out.println(" ===================");
		System.out.println("   1)회원  서비스   ");
		System.out.println("   2)관리자서비스   ");
		System.out.println("   3)공지사항");
		System.out.println("   0)종료           ");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	} 
	
	public void doRunInsert2()
	{
		int choice;
		
		while(true)
		{
			showMain2();
			choice = sc.nextInt();
			sc.nextLine();
		
			if(choice == 1)
				joinMember();
			else if (choice == 2)
				selMember2();
			else if (choice == 3)
				delMember2();
			else if (choice == 4)
				selNumber2();
			else if (choice == 5)
				selAll();
			else if (choice == 6)
				selMonBook();
			else if (choice == 0)
			{
					System.out.println("\n\n\n프로그램을 종료합니다.\n\n\n");
					return;	
			}
			else
			{
					System.out.println("잘 못 입력하셨습니다.");
					break;		
			}
		}
	}
	
	public void showMain2()
	{
		System.out.println(" \n\n\n");
		System.out.println(" --------------------");
		System.out.println("  ▷ 회원  서비스 ◁");
		System.out.println(" ===================");
		System.out.println("   1)회원  등록    ");
		System.out.println("   2)회원  조회   ");
		System.out.println("   3)회원  탈퇴   ");
		System.out.println("   4)도서  조회   ");
		System.out.println("   5)전체도서조회   ");
		System.out.println("   6)인기도서조회 ");
		System.out.println("   0)종료          ");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	}
	
	public void joinMember()	//회원DB
	{
		// pwd의 sql데이터가 null은 안되는 걸로 설정해서
		// ID중복체크는 마지막에 확인 가능
		System.out.print("ID : ");
		String id = sc.next();
		
		while(true)
		{
			System.out.print("비밀 번호 : ");
			String pwd = sc.next();
			sc.nextLine();
			System.out.print("비밀 번호 확인 : ");
			String pwd2 = sc.next();
			sc.nextLine();
			if(!pwd.equals(pwd2))
			{
				System.out.println("\n\n\n===========================");
				System.out.println("비밀번호가 일치하지 않습니다.\n"
						+ "다시 입력하세요.");
				System.out.println("===========================\n\n\n");
			}
			else
			{
				
				String sql = "insert into SCOTT.memberdbv(id ,pwd , phonenum) "
						+ "values(?, ?, ?) ";
				
				try
				{
					sc.nextLine();
					String sex = sc.next();
					System.out.print("전화 번호 : ");
					String phoneNum = sc.next();
					pstmt4 = con.prepareStatement(sql);
					pstmt4.setString(1,  id);
					pstmt4.setString(2,  pwd);
					pstmt4.setString(3,  phoneNum);
					int updateCount = pstmt4.executeUpdate();
					System.out.println("\n\n\n회원가입이 완료되었습니다.\n\n\n");	
				}
				catch(Exception e)
				{
					System.out.println("\n\n\n중복된 ID입니다.\n\n\n" + e);	
				}
				break;
			}
		}
	}
	
	public void selMember2()
	{
		System.out.print("Id : ");
		String id = sc.nextLine();
		System.out.print("Pwd : ");
		String pwd = sc.nextLine();
		
		String sql = "select * from SCOTT.memberdbv "
				+ " where id = ?"
				+ " and pwd = ?";
		
		try
		{
			pstmt5 = con.prepareStatement(sql);
			pstmt5.setString(1, id);
			pstmt5.setString(2, pwd);
			ResultSet rs = pstmt5.executeQuery();
			
			if(rs.next())
			{
				System.out.println("\n\n\n"+rs.getString(1)+ "님 환영합니다.\n\n\n");
			}
			else
				System.out.println("\n\n\n아이디가 존재하지 않습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("알 수 없는 에러가 발생했습니다.\n" + e);	
		}
	}
	
	public void delMember2()
	{
		System.out.println("===============================");
		System.out.print("탈퇴할 Id를 입력해주세요 : ");
		String name = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pwd = sc.next();
		System.out.println("정말 탈퇴하시겠습니까? Y / N");
		System.out.println("===============================");
		System.out.print("입력 : ");
		String real = sc.next();
//		sc.nextLine();
		if(real.equals("N"))
		{
			System.out.println("메인으로 돌아갑니다.");
			return;
		}
		
		String sql = "delete from SCOTT.memberdbv "
				+ "where id = ? "
				+ "and pwd = ? "
				+ "and black = 0 "
				+ "and rentNum = 0 ";
		try
		{
			pstmt6 = con.prepareStatement(sql);
			pstmt6.setString(1,  name);
			pstmt6.setString(2,  pwd);
			int updateCount = pstmt6.executeUpdate();
			System.out.println("\n\n\n탈퇴되었습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("데이터베이스 삭제 에러입니다.\n" + e);
		}
	}

	public void selNumber2()
	{
		System.out.print("조회할 도서명 : ");
		String name = sc.nextLine();
		
		String sql = "select * from SCOTT.bookdb "
				+ " where bookName = ?";
				
		try
		{
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, name);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) 
			{
				System.out.println("===============================");
				System.out.println("도서명 : " + rs.getString(1));
				System.out.println("도서 번호 : " + rs.getString(2));
				if (rs.getInt(3) == 0)
				{
					System.out.println("권 수 : 대여중");
				}
				else
					System.out.println("권 수: 대출가능");
			}
			System.out.println("\n\n\n조회를 완료하였습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n"
					+ "알 수 없는 에러가 발생했습니다.\n" + e
					+ "\n\n\n");	
		}
		
	}

	public void selAll()
	{
		String sql = "select * from SCOTT.bookdb ";
				
		try
		{
			pstmt2 = con.prepareStatement(sql);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) 
			{
				System.out.println("===============================");
				System.out.println("도서명 : " + rs.getString(1));
				System.out.println("도서 번호 : " + rs.getString(2));
				if (rs.getInt(3) == 0)
				{
					System.out.println("권 수 : 대여중");
				}
				else
					System.out.println("권 수: 대출가능");
			}
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n"
					+ "알 수 없는 에러가 발생했습니다.\n" + e
					+ "\n\n\n");	
		}
		
	}
	
	PreparedStatement monBook;
	public void selMonBook()
	{
		String sql = "select * from "
				+ "(select bookName "
				+ "from scott.monBook "
				+ "group by bookName "
				+ "order by COUNT(*) desc) "
				+ "where rownum < 6 ";
				
		try
		{
			monBook = con.prepareStatement(sql);
			ResultSet rs = monBook.executeQuery(sql);
			
			for(int i=1; i <6; i++)
			{
				System.out.println("========================================");
				while(rs.next()) 
				{
						System.out.println( i++ + "위 : " + rs.getString(1));
				}
				System.out.println("========================================");
			}
		}
		catch(Exception e)
		{
			System.out.println("알 수 없는 에러가 발생했습니다.\n" + e);	
		}
		
	}
	
	public void connectDatabase2()
	{										
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"client",
					"3333");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void connectDatabase()
	{										
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PWD: ");
		String pwd = sc.next();
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					id,
					pwd);
			logon = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n로그인 정보가 틀렸습니다. \n\n\n");
			return;
		}
		
		doRun();
	}
	
	Statement board;
	public void selBoard()
	{
		String sql = "select id, redate, title, content "
				+ "from scott.board";
				
		try
		{
			board = con.prepareStatement(sql);
			ResultSet rs = board.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("==================================");
				System.out.println("제목 : " + rs.getString(3));
				System.out.println("==================================");
				System.out.println("작성자 : " + rs.getString(1));
				System.out.println("내용 : \n" + rs.getString(4));
				System.out.println("==================================");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void doRun()
	{
		int choice;
		
		while(true)
		{
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
		
			switch (choice)
			{
				case 1:
					doRun1();
					break;
				case 2:
					doRun2();
					break;
				case 3:
					doRun3();
					break;
				case 9:
					doRunInsert();
					break;
				case 0:
					System.out.println("\n\n\n이전메뉴로 돌아갑니다.\n\n\n");
					return;	
				default:
					System.out.println("\n\n\n잘 못 입력하셨습니다.\n\n\n");
					break;
							
						
			}
		}
	}
	
	public void showMenu()		
	{							
		System.out.println(" \n\n\n");
		System.out.println(" -------------------");
		System.out.println("   ▷ 메뉴  	선택 ◁");
		System.out.println(" ===================");
		System.out.println("   1)도서   관리    ");	
		System.out.println("   2)회원   관리    ");
		System.out.println("   3)대여   관리    ");
		System.out.println("   9)돌아   가기    ");
		System.out.println("   0)종료           ");
		System.out.println(" ===================");
		System.out.println(" * 블랙회원 처리    ");
		System.out.println(" * 도서관리         ");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	} 
	
	public void doRun1()
	{
		int choice;
		
		while(true)
		{
			showMenu1();
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
					doRun5();
				case 9:
					doRun();
				case 0:
					System.out.println("\n\n\n이전 메뉴로 돌아갑니다.\n\n\n");
					return;	
				default:
					System.out.println("잘 못 입력하셨습니다.");
					break;
							
						
			}
		}
	}
	
	public void showMenu1()		
	{			
//		(◕▿◕✿)	ღවꇳවღ			
		System.out.println(" \n\n\n");
		System.out.println(" -------------------");
		System.out.println("   ▷ 도서  	관리 ◁");
		System.out.println(" ===================");
		System.out.println("   1)도서   입력");
		System.out.println("   2)도서   검색");
		System.out.println("   3)도서   삭제");		
		System.out.println("   4)도서   수정 * 준비중");
		System.out.println("   9)돌아   가기");
		System.out.println("   0)종료");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	}
	
	public void addNumber()
	{
		System.out.print("도서명 : ");
		String bookName = sc.nextLine();
		System.out.print("도서 번호 : ");
		String bookNumber = sc.next();
		sc.nextLine();	
		System.out.print("권수 : ");
		String howMany = sc.next();
		
		String sql = "insert into bookDb values(? ,?, ?)  ";
		
		try
		{
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,  bookName);
			pstmt1.setString(2,  bookNumber);
			pstmt1.setString(3,  howMany);
			int updateCount = pstmt1.executeUpdate();
			System.out.println("\n\n\n데이터베이스에 추가되었습니다.\n\n\n");	
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("\n\n\n존재하는 도서 번호입니다.\n\n\n");	
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다.\n" + e +"\n\n\n");	
		}
	}
	
	public void selNumber()
	{
		System.out.print("조회할 도서명 : ");
		String name = sc.nextLine();
		
		String sql = "select * from bookDb "
				+ " where bookName = ?";
				
		try
		{
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, name);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) 
			{
				System.out.println("===============================");
				System.out.println("도서명 : " + rs.getString(1));
				System.out.println("도서 번호 : " + rs.getString(2));
				if (rs.getString(3) != null)
				{
					System.out.println("권 수 : " + rs.getString(3));
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n"
					+ "알 수 없는 에러가 발생했습니다.\n" + e
					+ "\n\n\n");	
		}
		
	}
	
	public void delNumber()
	{
		System.out.print("삭제할 도서번호 : ");
		String name = sc.nextLine();
		
		String sql = "delete from bookDb "
				+ "where bookNum = ?";
		try
		{
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setString(1,  name);
			int updateCount = pstmt3.executeUpdate();
			System.out.println("\n\n\n"
					+ "데이터베이스에서 삭제되었습니다."
					+ "\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n"
					+ "데이터베이스 삭제 에러입니다.\n" + e
					+ "\n\n\n");
		}
	}
	
	public void doRun2()
	{
		int choice;
		
		while(true)
		{
			showMenu2();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
				case 1:
					addMember();
					break;
				case 2:
					selMember();
					break;
				case 3:
					delMember();
					break;
				case 4:
					black();
					break;
				case 9:
					doRun();
				case 0:
					System.out.println("\n\n\n 이전 메뉴로 돌아갑니다. \n\n\n");
					return;	
				default:
					System.out.println("\n\n\n잘 못 입력하셨습니다.\n\n\n");
					break;
							
						
			}
		}
	}
	
	public void showMenu2()
	{
		System.out.println(" \n\n\n");
		System.out.println(" -------------------");
		System.out.println("  ▷  회원  관리 ◁");
		System.out.println(" ===================");
		System.out.println("   1)회원   가입");
		System.out.println("   2)회원   조회");
		System.out.println("   3)회원   탈퇴");
		System.out.println("   4)블랙   회원");
		System.out.println("   9)돌아   가기");
		System.out.println("   0)종료");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	}
	
	PreparedStatement pstmt4;	//메뉴2
	PreparedStatement pstmt5;	
	PreparedStatement pstmt6;	
	
	public void addMember()	//회원DB
	{
		// pwd의 sql데이터가 null은 안되는 걸로 설정해서
		// ID중복체크는 마지막에 확인 가능
		System.out.print("ID : ");
		String id = sc.next();
		
		while(true)
		{
			System.out.print("비밀 번호 : ");
			String pwd = sc.next();
			sc.nextLine();
			System.out.print("비밀 번호 확인 : ");
			String pwd2 = sc.next();
			if(!pwd.equals(pwd2))
			{
				System.out.println("\n\n\n비밀번호가 일치하지 않습니다.\n"
						+ "다시 입력하세요.\n\n\n");
			}
			else
			{
				
				String sql2 = "insert into memberDb (id, pwd, phoneNum) "
						+ "values(?, ?, ?) ";
				
				try
				{
					sc.nextLine();
					System.out.print("전화 번호 : ");
					String phoneNum = sc.next();
					pstmt4 = con.prepareStatement(sql2);
					pstmt4.setString(1,  id);
					pstmt4.setString(2,  pwd);
					pstmt4.setString(3,  phoneNum);
					int updateCount = pstmt4.executeUpdate();
					System.out.println("\n\n\n데이터베이스에 추가되었습니다.\n\n\n");	
				}
				catch(Exception e)
				{
					System.out.println("\n\n\n중복된 ID입니다.\n\n\n");	
				}
				break;
			}
		}
	}
	
	public void selMember()
	{
		System.out.print("조회할 id : ");
		String id = sc.nextLine();
		
		String sql = "select * from memberDb "
				+ " where id = ?";
		
		try
		{
			pstmt5 = con.prepareStatement(sql);
			pstmt5.setString(1, id);
			ResultSet rs = pstmt5.executeQuery();
			
			if(rs.next())
			{
				System.out.println("id : " + rs.getString(1));
				System.out.println("pwd : " + rs.getString(2));
				if (rs.getString(3) != null)
				{
					System.out.println("phoneNum : " + rs.getString(3));
				}
				if (rs.getString(5) != null)
				{
					System.out.println("black : " + rs.getString(5));
				}
			}
			else
				System.out.println("\n\n\n아이디가 존재하지 않습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n알 수 없는 에러가 발생했습니다.\n" + e
					+ "\n\n\n");	
		}
	}
	
	public void delMember()
	{
		System.out.println("===============================");
		System.out.print("탈퇴할 id : ");
		String name = sc.next();
		System.out.println("정말 탈퇴하시겠습니까? Y / N");
		System.out.println("===============================");
		System.out.print("입력: ");
		String real = sc.next();
		sc.nextLine();
		if(real.equals("N"))
		{
			System.out.println("\n\n\n메인으로 돌아갑니다.\n\n\n");
			return;
		}
		
		String sql = "delete from memberDb "
				+ "where id = ?"
				+ "and black != 1 "
				+ "and rentNum != 1 ";
		try
		{
			pstmt6 = con.prepareStatement(sql);
			pstmt6.setString(1,  name);
			int updateCount = pstmt6.executeUpdate();
			System.out.println("\n\n\n탈퇴되었습니다.\n"
					+ "이용해주셔서 감사합니다\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 삭제 에러입니다.\n" + e
					+ "\n\n\n");
		}
	}
	
	public void doRun3()
	{
		int choice;
		
		while(true)
		{
			showMenu3();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
				case 1:
					doRun4();
					break;
				case 2:
					selRent();
					break;
				case 3:
					delRent();
					break;
				case 4:
					extend();
					break;
				case 9:
					doRun();
				case 0:
					System.out.println("\n\n\n이전 메뉴로 돌아갑니다.\n\n\n");
					return;	
				default:
					System.out.println("\n\n\n잘 못 입력하셨습니다.\n\n\n");
					break;
							
						
			}
		}
	}
	
	public void showMenu3()
	{
		System.out.println(" \n\n\n");
		System.out.println(" -------------------");
		System.out.println("   ▷ 대여  관리 ◁");
		System.out.println(" ===================");
		System.out.println("   1)대여   입력");
		System.out.println("   2)대여   조회"); //bookNum의 대여 현황 조회
		System.out.println("   3)도서   반납");
		System.out.println("   4)대여   연장");
		System.out.println("   9)돌아   가기");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	}
	
	public void doRun4()
	{
		int choice;
		
		while(true)
		{
			showMenu4();
			choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1)
					selMember();
			else if(choice == 2)
					rule();
			else if(choice == 3)
					addRent();
			else if(choice == 9)
			{
				System.out.println("\n\n\n이전 메뉴로 돌아갑니다.\n\n\n");
				return;	
			}
			else
			{
					System.out.println("\n\n\n잘 못 입력하셨습니다.\n\n\n");
					break;
			}		
		}
	}
	
	public void showMenu4()
	{
		System.out.println(" \n\n\n");
		System.out.println(" -------------------");
		System.out.println("   ▷ 대여   입력 ◁");
		System.out.println(" ===================");
		System.out.println("   1)회원   조회");
		System.out.println("   2)대여   조회"); //회원의 대여 현황 조회
		System.out.println("   3)대여   진행");
		System.out.println("   9)돌아   가기");
		System.out.println(" ===================");
		System.out.println(" * 순서대로 진행");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	}
	
	PreparedStatement pstmt7;	
	PreparedStatement pstmt8;	
	PreparedStatement pstmt9;
	//while문 없으면 그냥 statement를 사용하는게 시스템비용 줄여줌
	
	public void addRent() //대여DB 
	{	
		//rentDb
		System.out.print("회원ID: ");
		String id = sc.next();
		System.out.print("도서 번호: ");
		String bookNumber = sc.next();
		sc.nextLine();
		
		String sql = "insert into rentDb(id, bookNum, rentDate, rentDue, black, extend) "
				+ " values(?, ?, sysdate, sysdate+7, 0, 0) ";
		
		try
		{
			pstmt7 = con.prepareStatement(sql);
			pstmt7.setString(1,  id);
			pstmt7.setString(2,  bookNumber);
			int updateCount = pstmt7.executeUpdate();
			System.out.println("대여되었습니다.");
		}
		catch(Exception e)
		{
			System.out.println("데이터베이스 에러입니다. \n" + e);
			return;
		} 
		
		//bookDb	
		String sql2 ="update bookDb "
				+ "set howmany = 0 "
				+ "where howmany != 0"
				+ "and bookNum= ? ";
		String sql4 = "update rentDb r "
				+ "set r.bookname= "
				+ "    (select bookname"
				+ "    from bookDb b"
				+ "    where r.bookNum = b.bookNum)";
		try
		{
			pstmt7 = con.prepareStatement(sql2);
			pstmt7.setString(1,  bookNumber);
			int updateCount = pstmt7.executeUpdate();
			if(updateCount == 1)
				System.out.println("\n\n\n데이터베이스에 입력되었습니다. \n\n\n");	
			else
			{
				System.out.println("\n\n\n이미 대여된 도서입니다.\n\n\n");
				return;
			}
			pstmt7 = con.prepareStatement(sql4);
			updateCount = pstmt7.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다.\n" + e
								+"\n\n\n");	
		}
		
		//memberDb 대여수 업데이트
		String sql3 = "update memberDb m "
				+ "set m.rentnum = "
				+ "(select count(bookNum) "
				+ "    from rentDb r "
				+ "    where r.id = m.id)";
		try
		{
			pstmt7 = con.prepareStatement(sql3);
			int updateCount = pstmt7.executeUpdate();
			System.out.println("회원DB에 대여사항 업데이트 : " + updateCount);
			System.out.println("===============================\n\n\n");
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
	}
	
	public void selRent()
	{
		System.out.print("대여조회할 도서번호 : ");
		String bookNum = sc.nextLine();
		
		String sql = "select * from rentDb "
				+ " where bookNum = ?";
				
		try
		{
			pstmt8 = con.prepareStatement(sql);
			pstmt8.setString(1, bookNum);
			ResultSet rs = pstmt8.executeQuery();
			
			while(rs.next()) 
			{
				System.out.println("\n\n\n===============================");
				System.out.println("대여 ID : " + rs.getString(1));
				System.out.println("도서명 : " + rs.getString(2));
				System.out.println("도서 대여일 : " + rs.getString(4));
				System.out.println("반납 예정일 : " + rs.getString(5));
				if (rs.getString(7) != null)
				{
					System.out.println("블랙회원입니다. ");
				}
				System.out.println("===============================\n\n\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("알 수 없는 에러가 발생했습니다.\n" + e);	
		}
		
	}
	
	public void delRent()
	{
		//bookDb /북데이터베이스에 반납처리
		System.out.print("반납할 도서 번호: ");
		String bookNum = sc.next();
		String sql ="update bookDb "
				+ " set howmany = 1"
				+ " where bookNum= ? ";
		try
		{
			pstmt9 = con.prepareStatement(sql);
			pstmt9.setString(1,  bookNum);
			int updateCount = pstmt9.executeUpdate();
			System.out.println("\n\n\n데이터베이스에 입력되었습니다.\n\n\n");	
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다." + e
								+ "\n\n\n");	
		}
		
		//rentDb /반납처리(블랙회원 제외)
		String sql2 = "delete from rentDb "
				+ " where not black = 1"
				+ " and bookNum = ?";	
		try
		{
			pstmt9 = con.prepareStatement(sql2);
			pstmt9.setString(1,  bookNum);
			int updateCount = pstmt9.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다.\n" + e
								+ "\n\n\n");
			return;
		}
		
		//rentDb /블랙회원 반납처리
		String sql3 = "update rentDb "
				+ "set returnDate = sysdate "
				+ "where black = 1 "
				+ "and bookNum = ? ";	
		try
		{
			pstmt9 = con.prepareStatement(sql3);
			pstmt9.setString(1,  bookNum);
			int updateCount = pstmt9.executeUpdate();
			System.out.println("\n\n\n반납되었습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다.\n" + e
								+ "\n\n\n");
			return;
		}
		
	}
	
	PreparedStatement pstmt10;
	
	public void black() 
	{
		// 블랙처리 1단계 = 1주일 (일반회원)
		System.out.println("블랙회원을 관리합니다.");
		System.out.println("===============================");
		String sql = "select count(rentDue)  "
				+ "from rentDb "
				+ "where round(sysdate - to_date(rentDue)) > 1 "
				+ "and black != 1 "
				+ "and extend != 1";
		try
		{
			pstmt10 = con.prepareStatement(sql);
			ResultSet rs = pstmt10.executeQuery();
			if(rs.next())
			{
				System.out.println("신규 블랙 처리 대상자 : " + rs.getInt(1));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
		
		// 블랙처리 2단계 = 미납일수 x 2
		String sql2 = "select count( round(to_date(returnDate) - to_date(rentDue)) * 2) "
				+ "as blackExpect "
				+ "from rentDb "
				+ "where blackDue is null ";
		try
		{
			pstmt10 = con.prepareStatement(sql2);
			ResultSet rs = pstmt10.executeQuery();
			if(rs.next())
			{
				System.out.println("블랙 처리 대상자 : " + rs.getInt(1));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
		
		//블랙처리 해제하기
		String sql3 = "select count(blackDue) from rentDb "
				+ "where round(sysdate - to_date(blackDue)) >= 0 ";
		try
		{
			pstmt10 = con.prepareStatement(sql3);
			ResultSet rs = pstmt10.executeQuery();
			if(rs.next())
			{
				System.out.println("블랙 해제 대상자 : " + rs.getInt(1));
			}
			System.out.println("===============================");
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
		
		// 블랙처리 완료하기
		System.out.print("\n\n\n진행하려면 'ok'를 입력해주세요. : ");
		String ok = sc.next();
		String sql4 ="update rentDb "
				+ "set black = 1 "
				+ "where black != 1 "
				+ "and rentDue in "
				+ "(select rentDue as 대여일 "
				+ "from rentDb "
				+ "where round(sysdate - to_date(rentDue)) > 1 )";
		
		String sql5 = "update rentDb "
				+ "set blackDue "
				+ "	   = to_date(returnDate) + round(to_date(returnDate) - to_date(extendEnd))*2 "
				+ "where returnDate is not null "
				+ "and blackDue is null "
				+ "and extend = 0 ";
		
		String sql8 = "update rentDb "
				+ "set blackDue = "
				+ "to_date(returnDate) + round(to_date(returnDate) - to_date(extendEnd))*2 "
				+ "where returnDate is not null "
				+ "and blackDue is null "
				+ "and extend = 1 ";
		
		String sql6 = "delete from rentDb "
				+ "where round(sysdate - to_date(blackDue)) >= 0 ";
		
		String sql7 = "update memberDb m"
				+ " set m.black ="
				+ "   (select count(black) "
				+ "    from rentDb r "
				+ "    where r.id = m.id "
				+ "    and r.black = 1)";
		try
		{	
			if(ok.equals("ok"))
			{
				System.out.println("\n\n\n===============================");
				pstmt10 = con.prepareStatement(sql4);
				int updateCount = pstmt10.executeUpdate();
				System.out.println("신규 블랙 처리 : " + updateCount);
				pstmt10 = con.prepareStatement(sql5);
				updateCount = pstmt10.executeUpdate();
				System.out.println("블랙 처리 : " + updateCount);
				pstmt10 = con.prepareStatement(sql8);
				updateCount = pstmt10.executeUpdate();
				System.out.println("연장회원 블랙 처리 : " + updateCount);
				System.out.println("대여초과한 회원들을 블랙처리하였습니다.");
				System.out.println("===============================");
				pstmt10 = con.prepareStatement(sql6);
				updateCount = pstmt10.executeUpdate();
				System.out.println("블랙 해제 : " + updateCount);
				System.out.println("블랙기한이 완료된 회원들을 블랙해제하였습니다.");
				pstmt10 = con.prepareStatement(sql7);
				updateCount = pstmt10.executeUpdate();
				System.out.println("회원DB에 블랙사항을 업데이트하였습니다. ");
				System.out.println("===============================");
			}
			else
				System.out.println("\n\n\n메인으로 돌아갑니다.\n\n\n");
				return;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
	}
	
	PreparedStatement pstmt11;
	public void extend() 
	{
		// 1회에 한해 연장 가능
		System.out.print("연장할 id: ");
		String id = sc.next();
		String sql = "select count(extend) as cnt "
				+ "from rentDb "
				+ "where extend = 1 "
				+ "and id = ? ";
		try
		{
			pstmt11 = con.prepareStatement(sql);
			pstmt11.setString(1,  id);
			ResultSet rs = pstmt11.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1) != 0)
				{
					System.out.println("\n\n\n이미 연장하였습니다.\n\n\n");
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다. \n\n\n" );
			return;
		}
		
		// 연장 진행
		String sql2 = "update rentDb "
				+ "set extend = 1, "
				+ "       extendStart = sysdate, "
				+ "       extendend = sysdate+7 "
				+ "where black != 1 "	// 블랙회원은 연장 불가
				+ "and round(sysdate - to_date(rentDue)) <= 1 " // 기간만료회원은 연장 불가
				+ "and id = ? ";
		try
		{
			pstmt11 = con.prepareStatement(sql2);
			pstmt11.setString(1,  id);
			ResultSet rs = pstmt11.executeQuery();
			if(rs.next())
				System.out.println("\n\n\n연장되었습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n실패하였습니다. 회원정보를 확인해주세요.\n\n\n" );
			return;
		}
		
	}
	
	PreparedStatement pstmt12;
	public void rule()
	{
		// 대여한 도서 권수 확인 : 3권 초과하면 대여 불가
		System.out.print("조회할 id: ");
		String id = sc.next();
		String sql ="select count(bookNum) from rentDb "
				+ " where id= ?";
		try
		{
			pstmt12 = con.prepareStatement(sql);
			pstmt12.setString(1,  id);
			ResultSet rs = pstmt12.executeQuery();
			if(rs.next())
			{
				System.out.println("\n\n\n대여한 도서 권수 : " + rs.getInt(1));
				if(rs.getInt(1) >= 3)
				{
					System.out.println("\n대여 가능한 도서 권수를 초과했습니다.\n\n\n");
					return;
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
		
		// 블랙회원 확인 : 블랙회원은 대출불가
		String sql2 ="select black "
				+ "from rentDb "
				+ "where id = ? ";
		try
		{
			pstmt12 = con.prepareStatement(sql2);
			pstmt12.setString(1,  id);
			ResultSet rs = pstmt12.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1) != 1)
					System.out.println("일반회원, 대출가능합니다. ");
				else
					System.out.println("블랙회원, 대출불가합니다. ");
					return;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return;
		} 
		
	}
	
	public void doRun5()
	{
		int choice;
		
		while(true)
		{
			showMenu5();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
				case 1:
					modifyNum();
					break;
				case 2:
					modifyName();
					break;
				case 3:
					modifyHowmany();
					break;
				case 9:
					doRun1();
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;	
				default:
					System.out.println("잘 못 입력하셨습니다.");
					break;
							
						
			}
		}
	}
	
	public void showMenu5()		
	{							
		System.out.println(" \n\n\n");
		System.out.println(" -------------------");
		System.out.println("   ▷ 도서   수정 ◁");
		System.out.println(" ===================");
		System.out.println("   1)도서   번호");
		System.out.println("   2)도서   이름");
		System.out.println("   3)도서   권수");		
		System.out.println("   9)돌아   가기");
		System.out.println("   0)종료");
		System.out.println(" ===================");
		System.out.println(" \n\n\n");
		System.out.print("선택 : ");
	}
	
	PreparedStatement pstmt13;
	public void modifyNum() 
	{
		System.out.print("수정할 도서번호: ");
		String num = sc.next();
		System.out.print("새로운 도서번호: ");
		String renum = sc.next();
		String sql = "update bookDb "
				+ "set bookNum = ? "
				+ "where bookNum in "
				+ "(select bookNum "
				+ "    from bookDb"
				+ "    where bookNum = ?)";
		try
		{
			pstmt13 = con.prepareStatement(sql);
			pstmt13.setString(1,  renum);
			pstmt13.setString(2,  num);
			int updateCnt = pstmt13.executeUpdate();
			System.out.println("\n\n\n수정하였습니다.\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다. \n\n\n" );
			return;
		}
	}
	
	public void modifyName()
	{
		System.out.print("새로운 도서명: ");
		String rename = sc.next();
		System.out.print("수정할 도서번호: ");
		String num = sc.nextLine();
		String sql2 = "update bookDb "
				+ "set bookName = ? "
				+ "where bookNum = ? ";
		try
		{
			pstmt13 = con.prepareStatement(sql2);
			pstmt13.setString(1,  rename);
			pstmt13.setString(2,  num);
			int updateCnt = pstmt13.executeUpdate();
			System.out.println("\n\n\n수정하였습니다. \n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n데이터베이스 에러입니다. " +e 
								+"\n\n\n");
			return;
		}
	}
	
	public void modifyHowmany() 
	{
		System.out.println("\n\n\n업데이트 준비중입니다.\n\n\n");
	}
}








