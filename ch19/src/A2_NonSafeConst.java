interface Animal1
{
	int DOG = 1;
	int CAT = 2;
}

interface Person1
{
	int MAN = 1;
	int WOMAN = 2;
}

public class A2_NonSafeConst
{

	public static void main(String[] args)
	{
		//정상적인 메서드 호출
		who(Person1.MAN);
		
		//비정상적인 메서드 호출
		who(Animal1.DOG);			//컴파일 및 실행 과정에서 발견되지 않는 오류
	}	
	
	public static void who(int man)
	{
		switch(man)
		{
		case Person1.MAN:			//Animal1과 Person1의 값은 int로 dog와 man 둘 다 1이라 혼동
			System.out.println("남성 손님입니다.");
		case Person1.WOMAN:
			System.out.println("여성 손님입니다.");
			
			
		}
	}
	

}


