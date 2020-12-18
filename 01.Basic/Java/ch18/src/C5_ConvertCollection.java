import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class C5_ConvertCollection
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("Toy", "Box", "Box", "Toy"); //중복을 허용않는 List(?)
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
		
		HashSet<String> set = new HashSet<>(list); //중복을 허용않는 Set에서 중복 없어지고, 정렬됨
		list = new ArrayList<>(set);
				
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
	}

}

