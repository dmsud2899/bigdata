@FunctionalInterface		//@FunctionalInterface 어노테이션
//							 함수형 인터페이스라는 의미, 여러 개의 메서드를 선언하면 에러남
interface PrintableE
{
	void print(String s);
}

public class E6_LambdaParam
{
	public static void ShowString(PrintableE p, String s)
	{
		p.print(s);
	}
	
	public static void main(String[] args)
	{
		ShowString((s) -> {System.out.println(s); }, "What is Lambda?");
	}

}

