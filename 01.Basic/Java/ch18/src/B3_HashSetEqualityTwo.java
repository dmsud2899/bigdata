import java.util.HashSet;

class Num2
{
	private int num;
	
	public Num2(int n)
	{
		num = n;
	}
	
	@Override
	public String toString()
	{
		return hashCode() + " " + num;		// 7799의 hashcode가 다름 line18 주석하면 알 수 있음
	}										// 부모 hashcode
	
	@Override
	public int hashCode()
	{
		return num % 3;		//num % 3 = 3개 분류(나머지가 0, 1, 2)
	}
	
	@Override
	public boolean equals(Object obj)		//hashcode는 equals 필요
	{
		if(num == ((Num2)obj).num)
			return true;
		else
			return false;
	}
}

public class B3_HashSetEqualityTwo
{

	public static void main(String[] args)
	{
		HashSet<Num2> set = new HashSet<>();	//제네릭<> Num1 type만 넣을 것을 선언
		set.add(new Num2(7799));
		set.add(new Num2(9955));
		set.add(new Num2(7799));
		
		System.out.println("인스턴스 수: " + set.size());
		
		for(Num2 n : set)
			System.out.println(n.toString() + '\t');
		
		System.out.println();

	}

}

//이진분류보다 빨리 찾는 방법 = Hash알고리즘
//중복된 결과는 걸러줌
//해쉬코드에 의해 9955가 더 작게 나옴

