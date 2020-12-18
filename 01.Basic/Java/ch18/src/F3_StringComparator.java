import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StrComp implements Comparator<String>
{
	@Override			//Comparator를 하기위해 비교 조건 cmp를 만듬
	public int compare(String s1, String s2)
	{
		return s1.compareToIgnoreCase(s2);		// 대소문자 구분
	}
}

public class F3_StringComparator
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");
		list.add("Zero");
		list.add("apple");
		
		StrComp cmp = new StrComp(); 	//정렬과 탐색의 기준
		
		Collections.sort(list, cmp);	//정렬
		int idx = Collections.binarySearch(list, "Robot", cmp); 	//탐색
		for(String s : list)
			System.out.print(s + '\t');
		System.out.println();
		
		System.out.println(list.get(idx));
		
	}

}


