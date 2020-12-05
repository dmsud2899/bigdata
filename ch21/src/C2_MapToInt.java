import java.util.Arrays;
import java.util.List;

public class C2_MapToInt
{

	public static void main(String[] args)
	{
		List<String> ls = Arrays.asList("Box", "Robot", "Simple");
		
		ls.stream()
		 .map(s -> s.length())
		 .forEach(n -> System.out.print(n + "\t"));
		
		System.out.println();

	}

}

// 맵핑: 기존 데이터를 재배치
// 스트림을 구성하는 데이터를 조건에 따라 변환하는 연산


