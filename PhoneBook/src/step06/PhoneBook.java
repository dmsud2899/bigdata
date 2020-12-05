package step06;

import java.io.FileOutputStream;
import java.io.IOException;
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
		
		// Line52~55는 디버깅용으로만 사용
		Set<String> ks = map.keySet();
		for(String s : ks)
			System.out.println(s + " : " + map.get(s).toString());
		System.out.println("----------------------------------------");
		
		
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
		
		//디버깅
		Set<String> ks = map.keySet();	
		for(String s : ks)
			System.out.println(s + " : " + map.get(s).toString());
		System.out.println("----------------------------------------");
		}
	
	public static void saveInfo()
	{
		try(ObjectOutputStream oo =
				new ObjectOutputStream(new FileOutputStream("PhoneBook.bin")))
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
	
	public static void main(String[] args)
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

}

//line127 : 입력할 때 세이브하면 비용이 많이 듬.
//			종료할 때 하면 중간에 프로그램이 꺼지게 되면 내용이 날라감.
