package ch10_9;

interface Cry
{
	void cry();
}

class Cat implements Cry            // implements : 정의와 추상메서드(인터페이스)만 구현
{
	public void cry()
	{
		System.out.println("야옹~");
	}
}

class Dog implements Cry
{
	public void cry()
	{
		System.out.println("멍멍!");
	}
}

public class CheckCry
{

	public static void main(String[] args)
	{
		Cry test1 = new Cat();
//		Cry test1 = new Dog();
		
		if (test1 instanceof Cat)
		{
			test1.cry();
		}
		else if (test1 instanceof Dog)
		{
			System.out.println("고양이가 아닙니다.");
		}

	}

}






