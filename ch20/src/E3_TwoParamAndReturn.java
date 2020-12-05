interface Calculate4
{
	int cal(int a, int b);
}

public class E3_TwoParamAndReturn
{

	public static void main(String[] args)
	{
		Calculate4 c;
		c = (a, b) -> {return a + b;};
//		int num = c.cal(4, 3); //이와 같이 연산결과가 남는다.
		System.out.println(c.cal(4, 3));
		
		c = (a, b) -> a + b;
		System.out.println(c.cal(4, 3));
	}

}


//매개변수가 있고 반환하는 람다식1
//처리할 것이 한 줄이면, 괄호와 return 생략 가능




