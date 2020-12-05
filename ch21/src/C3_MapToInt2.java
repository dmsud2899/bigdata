import java.util.Arrays;
import java.util.List;

public class C3_MapToInt2
{

	public static void main(String[] args)
	{
		List<String> ls = Arrays.asList("Box", "Robot", "Simple");
		
		ls.stream()
		 .mapToInt(s -> s.length())
		 .forEach(n -> System.out.print(n + "\t"));
		
		System.out.println();
	}

}

//why use mapToInt(line12) ? 값을 명확하게 해줌 
//미리 만들어져 있는 mapToInt,mapToLong,mapToDouble 외는
//generic으로 stream에 만듬


