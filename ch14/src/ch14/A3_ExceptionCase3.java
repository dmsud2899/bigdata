package ch14;

import java.util.Scanner;
import java.util.InputMismatchException;

public class A3_ExceptionCase3
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.print("a/b...a? ");
		int n1 = kb.nextInt();
		
		System.out.print("a/b...b? ");
		int n2 = kb.nextInt();
			
		try
		{
			System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
		}
		
		catch(InputMismatchException e)       // 입력값에 대한 오류
		{
			e.printStackTrace();
		}
		
		System.out.println("Good bye~~!");
	}

}



