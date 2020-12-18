package ch10_2;

class Animal
{
	String name;
	int age;
	
	void printPet()
	{
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}

class Cat extends Animal
{
	String variety;
	
	void printPet()
	{
		super.printPet();                       //super.____ : 부모의 기능을 부르고 추가 덮어쓰기 함
		System.out.println("종류 : " + variety);
	}
}
public class Pet
{

	public static void main(String[] args)
	{
		Cat cat = new Cat();
		cat.name = "양순이";
		cat.age = 5;
		cat.variety = "페르시안";
		cat.printPet();

	}

}


//기억) 오버로('로')딩 : 필드끼리 변수 이름이 같은 것 <-> 오버라('라')이딩 : 상속받은 변수에 덮어쓰기
//super.____ : 부모의 기능을 부르고 추가 덮어쓰기 함
//super.이 없으면 부모 것 지우고 내꺼 덮어쓰기
//서브 클래스 안에서 super라는 말을 사용하면 슈퍼클래스의 필드와 메서드를 참조할 수 있음.
//상속받지 않은 부모 것만 찍고 싶으면 따로 명령어를 또 만들어야 함
// void printPet2()
// { super.printPet(); }







