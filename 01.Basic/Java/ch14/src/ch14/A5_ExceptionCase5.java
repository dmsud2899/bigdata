package ch14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A5_ExceptionCase5
{

	public static void main(String[] args)
	{
		try
		{
			Scanner kb = new Scanner(System.in);
			
			System.out.print("a/b...a? ");
			int n1 = kb.nextInt();
			
			System.out.print("a/b...b? ");
			int n2 = kb.nextInt();
			
			System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
		}
		
		catch(ArithmeticException | InputMismatchException e)      
		{
			e.getMessage(); // syso 안하면 아무 메시지 안뜸
//			System.out.println(e.getMessage());         // 오류 내용만을 사용자에게 출력 할 때 사용(?)
			e.getStackTrace();                          // 오류를 출력
		}
		
		System.out.println("Good bye~~!");
	}

}


// e.getMessage();는 오류 내용 부분만 출력하는데 이 때, 일 처리자가 당황하지 않도록
// 개발자는 오류 코드와 함께 메시지를 system.out.println()로 전달

// e.getStackTrace();는 오류(빨간색 파란색 글씨로 나오는거)를 띄움


