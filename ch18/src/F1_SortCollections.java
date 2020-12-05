import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class F1_SortCollections
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Weapon"); //Immutable 인스턴스
		list = new ArrayList<>(list);
		
		//정렬 이전 출력
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
			System.out.print(itr.next() + '\t');
		System.out.println();
		
		//정렬
		Collections.sort(list);
		
		//정렬 이후 출력
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
			System.out.print(itr.next() + '\t');
		System.out.println();
	}

}

//List<E> 인터페이스를 구현하는 컬렉션 클래스들의 공통 특성
//● 인스턴스의 저장 순서 유지
//● 동일 인스턴스의 중복 저장을 허용한다.
//List<E>를 구현한 컬렉션 클래스들은 저장된 인스턴스를 정렬된 상태로 유지하지 않는다.
//대신에 정렬을 해야 한다면 위의 메소드를 사용할 수 있다.


