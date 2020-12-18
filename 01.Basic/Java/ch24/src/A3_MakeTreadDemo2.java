//쓰레드를 생성하는 두 번째 방법

public class A3_MakeTreadDemo2
{

	public static void main(String[] args)
	{
		Runnable task = () ->			//람다식
		{
			try
			{
				Thread.sleep(3000);		//3초
			}
			catch(Exception e)			//a form of Throwable 
			{
				
			}
			
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (n1 + n2));
		};
		
		Thread t = new Thread(task);
		t.start();
		
		System.out.println("End " + Thread.currentThread().getName());

	}

}


//• 1단계 Runnable을 구현한 인스턴스 생성
//• 2단계 Thread 인스턴스 생성
//• 3단계 쓰레드의 start 메소드 호출

//모든 쓰레드가 일을 마쳐야 프로그램 종료 / 현관문

