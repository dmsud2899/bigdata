enum Animal2 {DOG, CAT}

enum Person2 {MAN, WOMAN}

public class A4_SafeEnum
{

	public static void main(String[] args)
	{
		//정상적인 메서드 호출
		who(Person2.MAN);
		
		//비정상적인 메서드 호출
		who(Animal2.DOG);			//컴파일 과정에서 자료형 불일치로 인한 오류 발생
	}	
	
	public static void who(Person2 man)
	{
		switch(man)
		{
		case MAN:			//Animal1과 Person1의 값은 int로 dog와 man 둘 다 1이라 혼동
			System.out.println("남성 손님입니다.");
		case WOMAN:
			System.out.println("여성 손님입니다.");
			
			
		}
	}

}

