package ch06;
import java.util.Scanner;

public class A_Quiz0612
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 수");
		int n1 = sc.nextInt();
		System.out.println("두 번째 수");
		int n2 = sc.nextInt();
		
		int nResult = 0;
		if(n1 < n2)
		{
			//증가
			for (int i = n1; i<=n2; i++)
			{
				if (i == n2)
				{
					System.out.print(i + "=");
				}
				else
				{
					System.out.print(i + "+");
				}
				nResult = nResult + i;
			}
			System.out.print(nResult);
		}
		else
		{
			//감소
			for (int i=n1; i>=n2; i--)
			{
				if (i == n2)
				{
					System.out.print(i + "=");
				}
				else
				{
					System.out.print(i + "+");
				}
				nResult = nResult + i;
			}
			System.out.print(nResult);
		}
		
		
	}
}


