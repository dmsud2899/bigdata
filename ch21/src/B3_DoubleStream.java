import java.util.Arrays;

public class B3_DoubleStream
{

	public static void main(String[] args)
	{
		double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};	// {} = 0~4
		
		Arrays.stream(ds)
			.forEach(d -> System.out.print(d + "\t"));
		System.out.println();
		
		Arrays.stream(ds, 1, 4)		//(1, 4) = (Start inclussive, End exclussive)
			.forEach(d -> System.out.print(d + "\t"));	
		System.out.println();
	}

}

// '\t' = char(stack에) -> 아스키코드를 참조하여 연산이 이뤄짐
// "\t" = obj(heap에)


