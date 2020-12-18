package ch10_7;

abstract class Calc
{
	int a = 5;
	int b = 6;
	
	abstract void Plus();
}

class MyCalc extends Calc
{
	void Plus() {System.out.println(a + b);}
	void Minus() { System.out.println(a - b);}
	
}
	
public class Polymorphism1
{

	public static void main(String[] args)
	{
		
		MyCalc myCalc1 = new MyCalc();
		myCalc1.Plus();
		myCalc1.Minus();
		
		// 하위클래스 객체를 상위 클래스 객체에 대입
		Calc myCalcs2 = new MyCalc();
		myCalc1.Plus();
		// 다음 메서드는 설계도에 없다. 사용할 수 없다.
		//myCalc2.Minus();
	}

}

// 예제일 뿐, 주로 이렇게 사용하지는 않음
// 다형성(폴리모피즘)
// 하위클래스 객체(자식)를 상위클래스 객체(부모)에 대입하여 사용할 수 있음.
// pdf 참고) name을 출력하면 에러는 안나지만 설계도에 없었기 때문에 출력은 안됨
// getPrice는 출력 됨.
// 하지만 상위클래스(부모)의 객체를 하위클래스(자식)의 객체로 대입할 수 없음
// pdf 참고) error남



