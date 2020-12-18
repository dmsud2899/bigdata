
public class C2_WrapperClassMethod
{

	public static void main(String[] args)
	{
		Integer n1 = Integer.valueOf(5);
		Integer n2 = Integer.valueOf("1024");	//파라미터 다름 : 오버로딩
		
		System.out.println("큰 수: " + Integer.max(n1, n2));
		System.out.println("작은 수: " + Integer.min(n1, n2));
		System.out.println("합: " + Integer.sum(n1,  n2));
		
		System.out.println("12의 2진 표현: 0B" + Integer.toBinaryString(12));
		System.out.println("12의 8진 표현: 0" + Integer.toOctalString(12));
		System.out.println("12의 16진 표현: 0x" + Integer.toHexString(12));
	}

}



//호출 : 클래스.메서드명(Integer.max();) or 변수호출




