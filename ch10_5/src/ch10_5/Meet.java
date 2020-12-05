package ch10_5;

//인터페이스는 상속 관계가 아닌
//클래스에 기능을 제공하는 구조
//클래스와 비슷한 구조이지만,
//정의와 추상 메스다만이 멤버가 될 수 있음

interface Greet
{
	void greet();
}

interface Talk
{
	void talk();
}

class Morning implements Greet,Talk
{
	public void greet()
	{
		System.out.println("안녕하세요!");
	}
	
	public void talk()
	{
		System.out.println("날씨 좋네요.");
	}
}
public class Meet
{

	public static void main(String[] args)
	{
		Morning morning = new Morning();
		morning.greet();
		morning.talk();

	}

}


//상속 : 가계도 (단일) <-> 
//인터페이스 : 여러 기능, 일반적인 메서드 x
//상속 ex) 뼈대 > 2차 건물 > 빌딩
//인터페이스 ex) 여러 옵션 추가 

