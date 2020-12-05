import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//
//초기화(?)
//

public class A5_AsListCollection
{

	public static void main(String[] args)
	{
		//인자로 전달된 인스턴스들을 저장한 컬렉션 인스턴스의 생성 및 반환
		// 이렇게 생성된 리스트 인스턴스는 Immutable 인스턴스이다.
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		//List add.("홍길동");
		list = new ArrayList<>(list); // 배열기반 리스트를 연결기반 리스트로
		list.add("전우치");
		
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
				System.out.print(itr.next() + '\t');
		System.out.println();
		
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
		{
			if(itr.next().equals("Box"))
				itr.remove();
		}
		
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();

	}

}


//list, set ,uqe = Collection : literable<T> 구현 가능
//hasNext = Toknizedml hasmore과 비슷


