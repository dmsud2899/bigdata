import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//쓰레드 풀 2개

public class C2_ExecutorsDemo2
{

	public static void main(String[] args)
	{
		Runnable task1 = () ->
		{
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + ( 5+ 7));
		};
		
		Runnable task2 = () ->
		{
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (7 - 5));
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.submit(() -> 
		{
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + ( 5*7));
		});
		
		exr.shutdown();
	}

}

//Line 21: 쓰레드 풀을 이용해서 동시에 수행될 수 있는
//		쓰레드의 총량을 제한하고 있다.

//• newFixedThreadPool
//풀 안에 인자로 전달된 수의 쓰레드를 생성하고 유지한다.
//→ 초기 쓰레드 개수는 0개, 코어 쓰레드 수와 최대 쓰레드 수는 매개변수 nThreads 값으로 지정.
//만약 생성된 쓰레드가 놀고 있어도 쓰레드를 제거하지 않고 내버려 둔다.

//쓰레드 방법 두가지
//1. 풀을 미리 만들고 쓰레드를 돌려씀
//2. 동시에 쓰레드에 있는 공간만 사용하도록 하는 것

//아래와 같은 결과 시, thread-2의 작업이 먼저 끝나 세번째에는 thread-2를 사용한 것
//pool-1-thread-1: 12
//pool-1-thread-2: 2
//pool-1-thread-2: 35


