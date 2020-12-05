class BoxA<T extends Number>
{
	private T ob;
	
	public void set(T o)
	{
		ob = o;
	}
	
	public T get()
	{
		return ob;
	}
}

public class B4_BoundedBox
{

	public static void main(String[] args)
	{
		BoxA<Integer> iBox = new BoxA<>();
		iBox.set(24);
		
		BoxA<Double> dBox = new BoxA<>();
		dBox.set(5.97);
		
		System.out.println(iBox.get());
		System.out.println(dBox.get());

	}

}

//class Box<T extends Number>{...}
//→ 인스턴스 생성 시 타입 인자로 Number 또는 이를 상속하는
//클래스만 올 수 있슴( = 제네릭 클래스의 타입 인자 제한)


