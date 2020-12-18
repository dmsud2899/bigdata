import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

//기본 자료형 데이터의 저장과 참조

public class A7_PrimitiveCollection
{

	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();
		
		//저장 과정에서 오토박싱
		list.add(10);
		list.add(20);
		list.add(30);
		
//		ArrayList<Integer> list2 = new ArrayList<>(list); //에러 없이 사용 가능
//		ArrayList<Integer> list3 = list; //에러 발생. 사용 불가능
		
		int n;
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext();)
		{
			n = itr.next(); //오토언박싱
			System.out.println(n + '\t');
		}
		
		System.out.println();
	}

}


//위 주석은 한 줄씩만 풀어서 테스트
//두 줄 동시에 풀고 실행하는 것 아님
//오토 박싱과 오토 언박싱 덕분에 컬렉션 인스턴스에 기본 자료형의 값도 저장 가능하다.


