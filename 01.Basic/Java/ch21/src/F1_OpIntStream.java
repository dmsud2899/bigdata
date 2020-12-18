import java.util.stream.IntStream;

public class F1_OpIntStream
{
	
	public static void main(String[] args)
	{
		//합
		int sum = IntStream.of(1, 3, 5, 7, 9)
						.sum();
		System.out.println("sum = " + sum);
		
		//개수
		long cnt = IntStream.of(1, 3, 5, 7, 9)
						.count();
		System.out.println("count = " + cnt);
		
		//평균
		IntStream.of(1, 3, 5, 7, 9)		//return type = double
				.average()
				.ifPresent(av -> System.out.println("avg = " + av));
				
		
		//최소
		IntStream.of(1, 3, 5, 7, 9)
				.min()
				.ifPresent(mn -> System.out.println("avg = " + mn));
		
		//최대
		IntStream.of(1, 3, 5, 7, 9)
				.max()
				.ifPresent(mx -> System.out.println("avg = " + mx));

	}

}

//[IntStream의 메소드들]

//int sum()
//long count()
//OptionalDouble average()
//OptionalInt min()
//OptionalInt max()
//generic한게 없으면 = ifPresent(?)
//ifPresent로 하지 않아도 .average(), .min()이 있어서(?) 굳이 안해도 됨


