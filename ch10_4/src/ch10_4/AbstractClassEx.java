package ch10_4;

abstract class Animal
{
	int age;
	abstract void cry();
}

class Dog extends Animal
{
	void cry()
	{
		System.out.println("멍멍");
	}
}

class Cat extends Animal
{
	void cry()
	{
		System.out.println("야옹");
	}
}
public class AbstractClassEx
{

	public static void main(String[] args)
	{
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();
	}

}


//추상화 <-> 추상 클래스

//abstract 메서드가 있는 클래스는 abstract class
//= 추상메서드                      =추상클래스
//
//추상클래스를 상속하는 클래스에서 추상메서드를 오버라이딩하지 않으면 에러남

//ex) error : 까먹지 않고 계속 cry를 써줘야 함.
//class Animal
//{
//	int age;
//	void cry() {};
//}
//
//class Dog extends Animal
//{
//}

// 일반메서드 100개에 추상메서드가 단 한개여도 추상클래스임

//상속받았을 때도 입력하지 않았으면 abstract
//abstract Dog extends Animals{}
//상속이나 값 변경하지 못하게 하려면 final abstract Dog extends Animals{}

//큰 규모로 만들 때 효과적으로 사용하기 위한 방벌들 = 10장

