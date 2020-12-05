import java.util.Arrays;

public class A2_MyFirstStream2
{

	public static void main(String[] args)
	{
		int[] ar = {1, 2, 3, 4, 5};
		
		int sum = Arrays.stream(ar)
						.filter(n -> n%2 ==1)
						.sum();					// 다체인문법, buildup
		System.out.println(sum);
	}

}

//A1을 요약한 예제


