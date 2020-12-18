class Apple4
{
	public String toString() 
	{
		return "I am an apple.";
	}
}

class Orange4
{
	public String toString()
	{
		return "I am an orange.";
	}
}

class Box4
{
	private Object ob;
	
	public void set(Object o)
	{
		ob = o;
	}
	
	public Object get()
	{
		return ob;
	}
}

public class A4_FruitAndBoxFault2
{

	public static void main(String[] args)
	{
		Box4 aBox = new Box4();
		Box4 oBox = new Box4();
		
		//과일을 박스에 담은 것일까? 
		aBox.set("Apple");
		oBox.set("Orange");
		
		System.out.println(aBox.get()); // 프로그래머의 실수가 실행 과정에서 조차
		System.out.println(oBox.get()); // 발견되지 않을 수 있다. 정말 큰 문제!
	}
	
}


//불편함이라 하면 상자에서 물건을 꺼낼 때 형 변환을 해야 한다는 것이고,
//문제점이라고 하면 프로그래머가 실수를 해도 그 실수가 드러나지 않을 수도 있다는 것이다.


