import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class B1_SetCollectionFeature
{

	public static void main(String[] args)
	{
		Set<String> set = new HashSet<>();	//자식을 부모에게 대입할 수 있다.
		set.add("Toy");
		set.add("Box");
		set.add("Robot");
		set.add("Box");
		
		System.out.println("인스턴스의 수: " + set.size()); //데이터의 중복 저장을 허용하지 않는다.
		
		//반복자를 이용한 전체 출력
		for(Iterator<String> itr = set.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
		
		//for-each를 이용한 전체 출력
		for(String s : set)
			System.out.print(s + '\t');
		System.out.println();		// 저장 순서가 유지되지 않는다.
	}

}


