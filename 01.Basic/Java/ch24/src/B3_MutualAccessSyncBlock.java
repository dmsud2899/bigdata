//동기화 블록 예제

class Counter3
{
	int count = 0;
	
	public void increment()
	{
		synchronized(this)		//동기화 블록
		{
			count++;
		}
	}
	
	public void decrement()
	{
		synchronized(this)		//동기화 블록
		{
			count--;
		}
	}
	
	public int getCount() { return count;}
}

public class B3_MutualAccessSyncBlock
{

	public static Counter3 cnt = new Counter3();
	
	public static void main(String[] args)
			throws InterruptedException
	{
		Runnable task1 = () ->
		{
			for(int i = 0; i < 1000; i++)
				cnt.increment();
		};
		Runnable task2 = () ->
		{
			for(int i = 0; i < 1000; i++)
				cnt.decrement();
		};
		
		Thread t1 = new Thread(task1); 	//new <- 시스템적 비용이 많이 듬
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		
		t1.join();		
		t2.join();		
		
		System.out.println(cnt.getCount());
	}
}

//쓰레드의 생성과 소멸은 리소스 소모가 많은 작업이다. = 시스템적 비용이 많이 듬
// file IO는 직접적으로 모터의 움직임이 있기 때문에 시스템적 비용이 가장 많이 듬


