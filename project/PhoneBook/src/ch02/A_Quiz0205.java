package ch02;
import java.util.Scanner;

public class A_Quiz0205
{

	public static void main(String[] args)
	{
		String source = "10 3";
		Scanner sc = new Scanner(source);
		
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int result5_1 = num1 * num2;
		
		if (result5_1 > 0)
		{
		System.out.println(result5_1);
		}
		
		else
		{
		System.out.println(result5_1*(-1));
		}

	}

}




