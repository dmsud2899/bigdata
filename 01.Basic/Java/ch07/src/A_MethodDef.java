
public class A_MethodDef
{

	public static void main(String[] args)
	{
		System.out.println("프로그램의 시작");
		hiEveryone(12);
		hiEveryone(13);
		System.out.println("프로그램의 끝");
	}

	public static void hiEveryone (int age)      // hiEveryone(파라미터 = 인자 = 매게변수)
	{
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 "+ age + "세 입니다.");
	}
	
}


// main은 기본 시작으로 설정되어 있음
// hi~부터가 내가 만든 method
// 객체형이랑 절차형은 아예 다른 얘기임. 비교할 수 없음.
// 파라미터는 있을 수도 없을 수도, 여러개일 수도 있음.


