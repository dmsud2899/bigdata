import java.util.ArrayList;
import java.util.List;

public class A1_ArrayListCollection
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();		//String만 받음
		
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

//추가&삭제는 빠름 but 검색 느림 = 리스트(pdf.자료구조)
//LinkedList<E> 보조자료의 List : 리스트 기반
//ArrayList<E> 배열기반

//ArrayList<E>의 단점
//저장 공간을 늘리는 과정에서 시간이 비교적 많이 소요된다.
//- 인스턴스의 삭제 과정에서 많은 연산이 필요할 수 있다. 따라서 느릴 수 있다.
//ArrayList<E>의 장점
//- 저장된 인스턴스의 참조가 빠르다.
