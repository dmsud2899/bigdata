
public class C_MethodReturns
{

	public static void main(String[] args)
	{
		int result;
		result = adder(4 ,5);
		
		System.out.println("4 + 5 = " + result);
		System.out.println("3.5 x 3.5 = " + square(3.5));
	}
	
	public static int adder(int num1, int num2)
	{
		int addResult = num1 + num2;
		return addResult;
	}
	
	public static double square(double num)
	{
		return num * num;
	}

}

// "void" method와 return은 함께 쓸 수 없음
// "변수" 설정하면 return과 함께
// 다른 프로그램에서는 function
// 주로 객체지향에서는 파라미터, 절차지향에서는 함수라고 사용하지만 크게 신경 쓸 필요x





