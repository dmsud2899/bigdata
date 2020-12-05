import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class F2_StringBinarySearch
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		list.add("Zero");
		list.add("apple");
		
		//정렬
		Collections.sort(list);
		for(String s : list)
			System.out.print(s + '\t');
		System.out.println();
		
		//탐색
		int idx = Collections.binarySearch(list, "Robot");
		
		//탐색 결과 출력
		System.out.println(list.get(idx));
		
	}

}


//이진탐색(binarySearch)을 하기 위해서는 정렬을 해야 함.
//List<String>이기 때문에 string을 찾음


