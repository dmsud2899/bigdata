package ch06;
import java.util.Scanner;

public class A_Quiz0610
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int nResult = 0;              //32번도 같은 방법
		
		for(int i=0; i<5;)
		{
			System.out.println("숫자를 입력해 주세요.");
			int nTemp = sc.nextInt();
			if(nTemp<1)
			{
				System.out.println("다시 입력해 주세요.");
				continue;
			}
			nResult = nResult + nTemp;
			i++;
		}
		
		System.out.println(nResult);
	}
	

}
