import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A4_IteratorCollection
{

	public static void main(String[] args)
	{
		List<String> list = new LinkedList<>();
		
		//인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Box");
		list.add("Robot");
		
		//반복자 획득
		Iterator<String> itr = list.iterator();
		
		//반복자를 이용한 순차적 참조
		while(itr.hasNext())
			System.out.print(itr.next() + '\t');
		
		System.out.println();
		
		//반복자 다시 획득
		itr = list.iterator();
		
		// "Box"의 삭제
		String str;
		while(itr.hasNext())
		{
			str = itr.next();
			
			if(str.equals("Box"))
				itr.remove();
		}
		
		//반복자 다시 획득
		itr = list.iterator();
		
		//삭제 후 결과 확인
		while(itr.hasNext())
			System.out.print(itr.next() + '\t');
		
		System.out.println();
	}

}


//Iterator 반복자의 세가지 메소드
//E next() 다음 인스턴스의 참조 값을 반환
//boolean hasNext() next 메소드 호출 시 참조 값 반환 가능 여부 확인
//void remove() next 메소드 호출을 통해 반환했던 인스턴스 삭제
