import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//쓰레드 풀 1개

public class C1_ExecutorDemo
{

	public static void main(String[] args)
	{
		Runnable task = () ->		//쓰레드에게 시킬 작업
		
		{
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (n1 + n2));
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();	//풀
		exr.submit(task); 	//쓰레드 풀에 작업을 전달
		
		System.out.println("End " + Thread.currentThread().getName());
		
		exr.shutdown();		// 쓰레드 풀과 그 안에 있는 쓰레드의 소멸
	}

}


//shutdown() 메서드가 호출되어도 이미 전달된 작업은 진행이 된다.
// 쓰레드 문제를 해결하기 위한 쓰레드 풀은 쓰레드의 재활용을 위한 모델이다.

//Line18: 풀 안에 하나의 쓰레드만 생성하고 유지한다.
//→ 쓰레드의 숫자가 단지 하나이고 하나의 태스크가 완료된 이후에 다음 태스크가 실행된다.
//이것을 사용하면 동기화를 고려해야 할 필요 없이, 즉 synchronized를 사용하지 않고도
//안전하게 실행할 수 있다.


