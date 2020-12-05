class Box8<T>
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

public class B2_PrimitivesAndGeneric
{

	public static void main(String[] args)
	{
		Box8<Integer> iBox = new Box8<Integer>();
		
		iBox.set(125);			//오토 박싱 진행
		int num = iBox.get();	//오토 언박싱 진행
		
		System.out.println(num);

	}

}

//Box<int> box = new Box<int>();
//→ 타입 인자로 기본 자료형(primitive type)이 올 수 없으므로 컴파일 오류 발생
//오토 박싱과 오토언박싱이 반복되어 쌓이면 속도가 느려질 수 있음


