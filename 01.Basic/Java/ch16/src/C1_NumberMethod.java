
public class C1_NumberMethod
{

	public static void main(String[] args)
	{
		Integer  num1 = new Integer(29);
		System.out.println(num1.intValue());   // java.lang.Number에 정의된 추상메소드들
		System.out.println(num1.doubleValue());
		
		Double num2 = new Double(3.14);			// 밑줄 : Integer.valuof()로 사용하라는 뜻임
		System.out.println(num2.intValue());
		System.out.println(num2.doubleValue());
	}

}

// 래퍼 인스턴스에 저장된 값을
// 원하는 형의 기본 자료형 값으로 반환할 수 있다.
// 모든 래퍼 클래스가 상속하는 클래스




