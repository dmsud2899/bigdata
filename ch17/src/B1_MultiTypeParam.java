class Box7<L, R>
{
	private L left; 	//왼쪽 수납 공간
	private R right;	//오른쪽 수납 공간
	
	public void set(L o, R r)
	{
		left = o;
		right = r;
	}
	
//	@Override
//	public String toString()	//<- 없으면 println에서 출력할 때 id가 출력 됨
//	{							//<- boolen type으로 false/true하고 println에 문자 입력은 가능했던듯(?)
//		return left + " & " + right;
//	}
}

public class B1_MultiTypeParam
{

	public static void main(String[] args)
	{
		Box7<String, Integer> box = new Box7<String, Integer>();
		box.set("Apple", 25);
		System.out.println(box);
	}

}

