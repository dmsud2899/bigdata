package ch14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A4_ExceptionCase4
{

	public static void main(String[] args)
	{
		try
		{
			Scanner kb = new Scanner(System.in);
			
			System.out.print("a/b...a? ");          
			int n1 = kb.nextInt();                      // 문자를 입력하게되면 출력도 전에 에러가 나면서 null
			
			System.out.print("a/b...b? ");
			int n2 = kb.nextInt();
			
			System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
		}
		
		catch(ArithmeticException e)      
		{
			String str = e.getMessage();
			if (str.equals("/ by zero"))
				System.out.println("0으로 나눌 수 없습니다.");
//			System.out.println(e.getMessage());
			e.printStackTrace();                        // 
		}
		
		System.out.println("Good bye~~!");
	}

}


