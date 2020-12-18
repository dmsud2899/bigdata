package ch02;
import java.util.Scanner;

public class A_Quiz0204
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int big;
		int diff;
		
		big = (num1 > num2) ? num1 : num2;
		System.out.println("큰 수: " + big);
		
		diff = (num1 > num2) ? (num1 - num2) : (num2 -num1);
		System.out.println("두 수의 차 : " + diff);
		
	}

}

