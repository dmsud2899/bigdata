package step09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

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
			{
				System.out.println("삭제되었습니다.");
				pInfo.showPhoneInfo();
			}
		else
			System.out.println("[" + name + "] 데이터가 없습니다.");
		
		}
	
	public static void saveInfo()
	{
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter("phone_data.csv"))) //csv형태의 파일 저장
		{										
			Set<String> ks = map.keySet();	
			for(String s : ks)
			{
				PhoneInfo pInfo = map.get(s);
				String str = "\"" + pInfo.name + "\"," +
							 "\"" + pInfo.phoneNumber + "\"," +
							 "\"" + pInfo.email + "\"";
				bw.write(str);
				bw.newLine();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void readInfo()
	{										
		try(BufferedReader br = 
				new BufferedReader(new FileReader("phone_data.csv")))
		{
			String str;
			while(true)
			{
				str = br.readLine();
				if(str == null)
					break;
					
				StringTokenizer sToken = new StringTokenizer(str, "\",\"");
				String name = sToken.nextToken();
				String phoneNumber = sToken.nextToken();
				String email = null;
				if (sToken.hasMoreTokens())
				{
					email = sToken.nextToken();
//					System.out.println("[" + email + "]");
				}
				
				PhoneInfo pInfo;
				if (email != null)
				{
					pInfo = new PhoneInfo(name, phoneNumber, email);
				}
				else
					pInfo = new PhoneInfo(name, phoneNumber);
//				pInfo.showPhoneInfo();
				map.put(name, pInfo);
			}
		}
		catch(FileNotFoundException e)
		{
//			e.printStackTrace();
		}
		catch(IOException e)
		{
//			e.printStackTrace();
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


//csv 확인, csv는 microsoft이기 때문에 UT8이 아니어서 한글은 깨져 보임
