interface Eatable
{
	public String eat();
}

class AppleB implements Eatable
{
	public String toString()
	{
		return "I am an apple.";
	}
	
	@Override
	public String eat()
	{
		return "It tastes so good!";
	}
}

class BoxB<T extends Eatable>
{
	private T ob;
	
	public void set(T o) 
	{
		ob = o;
	}
	
	// 한 입 먹고 반환하는 행위의 메서드로 수정 / Eatable 로 제한하였기에 eat 호출 가능
	public T get()
	{
		System.out.println(ob.eat());
		return ob;
	}
}

public class B5_BoundedInterfaceBox
{

	public static void main(String[] args)
	{
		BoxB<AppleB> box = new BoxB<>();
		box.set(new AppleB());
		
		AppleB ap = box.get();
		System.out.println(ap);
	}

}

// 제네릭 클래스의 타입 인자를 인터페이스로 제한하기
// 안드로이드 앱 수업에서 자주 등장
// 이해만 하고 넘어감


