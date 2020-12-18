package ch10_3;

//static의 이해

class Cat
{
	static int a = 5;
	int num = 3;
	
	void Print(int num3)
	{
		System.out.println("a:" + a);
		num = num3;
		System.out.println("num:" + num);
	}
}
public class StaticEx1
{

	public static void main(String[] args)
	{
		int num1 = 5;
		int num2 = 2;
		System.out.println(num1 + ", " + num2);
		
		Cat cat1 = new Cat();
		cat1.num = 1;
		cat1.a = 10;
		cat1.Print(20);
		System.out.println(cat1.num);
		System.out.println(cat1.a);
		
		Cat cat2 = new Cat();
		cat2.num = 2;
		cat2.a = 11;
		cat2.Print(20);
		System.out.println(cat2.num);
		System.out.println(cat2.a);
		System.out.println(cat1.a);

	}

}


//메모리 구조

//메서드 / 스택 / 힙

//메서드(<-code입력)
//- static영역( = 공유)
//static이 있는 것들을 올림
//main에도 static
//메모리 성격이 틀려서 static영역에만 부를 수 있음
//변수 던 메서드던 프로그램 시작 전에 올라가 있음
//중복 x
//- non static 영역
//
//ex) 10장)
//new로 만들었을 때 static에 있으면 힙에 만들지 않고 메서드의 static에 만듬
//=10장)static을 붙인 멤버는 오브젝트를 생성하지 않고도 사용할 수 있다.
//= 만약 static book이 있으면 ____.book로 사용 가능


//힙에 객체에 대한 샌드박스가 스택에 생성

//breakpoints은 main이나 main 다음 줄에 
//F11로 디버깅
//F6으로 한 줄씩 실행하면서 봄
//Expressions에 Cat.a
//Expressions에 main이 있는 class 명.변수 입력
//Expressions = static영역     ex) 미리 a가 생성되어 있으며 값(value)을 공유 = 오버라이딩
//Variables = non static영역   ex) a가 생성되지 않음 

//java와 main은 다른 폴더이기 때문에 private이면 안됨.





