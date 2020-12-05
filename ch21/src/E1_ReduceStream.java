import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class E1_ReduceStream
{

	public static void main(String[] args)
	{
		List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");
		
		BinaryOperator<String> lc = (s1, s2) ->		//람다식
		{
			if(s1.length() > s2.length())			// 삼항연산자로 하면 한 줄로 가능
				return s1;
			else
				return s2;
		};
		
		String str = ls.stream()
					.reduce("", lc);
		
		System.out.println(str);
	}

}

//배열에 여러 문자열이 있을 때 길이가 가장 긴 문자열 찾기


