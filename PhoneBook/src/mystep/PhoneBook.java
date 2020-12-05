package mystep;
import java.io.FileInputStream;		
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook
{

	static Scanner sc = new Scanner(System.in);
	static Map<String, PhoneInfo> map = new HashMap<>();
		
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
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		PhoneInfo pInfo;
		if (email != null && !email.equals(""))			
			pInfo = new PhoneInfo(name, phoneNumber, email);
		else
			pInfo = new PhoneInfo(name, phoneNumber);
		
		pInfo.showPhoneInfo();
		map.put(name,pInfo);							
		System.out.println("맵의 크기 : " + map.size());
		System.out.println("----------------------------------------");
	}
	
	public static void selNumber()
	{
		System.out.println("----------------------------------------");
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
				
		PhoneInfo pInfo = map.get(name);
			
		if(pInfo != null)
			pInfo.showPhoneInfo();
		else
			System.out.println("[" + name + "] 데이터가 없습니다.");
	}
	
	public static void delNumber()
	{
		System.out.println("----------------------------------------");
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();
		
		PhoneInfo pInfo = map.remove(name);
			
		if(pInfo != null)
			System.out.println("삭제되었습니다.");
		else
			System.out.println("[" + name + "] 데이터가 없습니다.");
		}
	
	public static void saveInfo()
	{
		try(ObjectOutputStream oo =
				new ObjectOutputStream(new FileOutputStream("PhoneBook2.bin")))
		{										
			Set<String> ks = map.keySet();	
			for(String s : ks)
			{
				PhoneInfo pInfo = map.get(s);
				oo.writeObject(pInfo);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void readInfo()
	{
		try(ObjectInputStream oi =
				new ObjectInputStream(new FileInputStream("PhoneBook2.bin")))
		{
			while(true)
			{
				PhoneInfo pInfo = (PhoneInfo) oi.readObject();
				if(pInfo == null)
					break;
				map.put(pInfo.name, pInfo);
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{	
		//	e.printStackTrace();
		}
	}
	
	public static void loading()
	{
		try 
		{
			System.out.println("\n\n\n\n\n■\n\n\n\n\n");
			Thread.sleep(500);
			System.out.println("\n\n\n\n\n■■\n\n\n\n\n");
			Thread.sleep(500);
			System.out.println("\n\n\n\n\n■■■\n\n\n\n\n");
			Thread.sleep(500);
			System.out.println("\n\n\n\n\n■■■■\n\n\n\n\n");
			Thread.sleep(500);
			System.out.println("\n\n\n\n\n■■■■■\n\n\n\n\n");
			Thread.sleep(500);
			System.out.println("\n\n\n\n\n■■■■■ One sec ...\n\n\n\n\n");
			Thread.sleep(500);
		}
		catch(InterruptedException e)			
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		int choice;
		
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
					System.out.print("9.Home 0.종료\r입력: ");
					int home = sc.nextInt();
					if(home == 0)
					{
						saveInfo();
						System.out.println("프로그램을 종료합니다.");
						return;
					}
					else 
					{
					loading();
					break;
					}
				case 2:
					selNumber();
					System.out.print("9.Home 0.종료\r입력: ");
					home = sc.nextInt();
					if(home == 0)
					{
						saveInfo();
						System.out.println("프로그램을 종료합니다.");
						return;
					}
					else 
					{
					loading();
					break;
					}
				case 3:
					delNumber();
					System.out.print("9.Home 0.종료\r입력: ");
					home = sc.nextInt();
					if(home == 0)
					{
						saveInfo();
						System.out.println("프로그램을 종료합니다.");
						return;
					}
					else 
					{
					loading();
					break;
					}
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

	
}

//EOFE: 파일없음


