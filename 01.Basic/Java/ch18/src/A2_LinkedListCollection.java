import java.util.LinkedList;
import java.util.List;

public class A2_LinkedListCollection
{

	public static void main(String[] args)
	{
		List<String> list = new LinkedList<>();		
		
		//인스턴스 저장: 순서 있음. 중복 허용.
		list.add("Toy");
		list.add("Box");
		list.add("Box");
		list.add("Robot");
		
		//인스턴스 참조
		for(int i = 0; i<list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
		
		//첫 번째 인스턴스 삭제
		list.remove(0);
		
		//삭제 후 인스턴스 참조
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();

	}

}

//자식을 부모에게 대입(Line 9)
//제네릭으로 String, 뒤에 반복이니까 <>로 String생략(Line 9)
//내용 상 차이,만들어졌을 때 차이

//LinkedList<E>의 단점
//- 저장된 인스턴스의 참조 과정이 배열에 비해 복잡하다. 따라서 느릴 수 있다.
//LinkedList<E>의 장점
//- 저장 공간을 늘리는 과정이 간단하다.
//- 저장된 인스턴스의 삭제 과정이 단순하다.
