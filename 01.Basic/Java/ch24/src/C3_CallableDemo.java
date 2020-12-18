import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C3_CallableDemo
{

	public static void main(String[] args)
				throws InterruptedException, ExecutionException
	{
		Callable<Integer> task = () ->
		{
			int sum = 0;
			for(int i = 0; i < 10; i++)
				sum += i;
			return sum;
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		Future<Integer> fur = exr.submit(task);
		
		Integer r = fur.get();
		System.out.println("result: " + r);
		exr.shutdown();
	}

}
//service에서만 return 가능
//Thread에서 return을 받기 위해 사용: Callable, ,Future


