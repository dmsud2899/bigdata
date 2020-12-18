//쓰레드를 생성하는 방법

class Task extends Thread
{
	public void run()		//추상메서드<- 반드시 구현
	{
		int num = 30;
		String name = Thread.currentThread().getName();
		for(int i = 0; i<num; i++)
		{
			System.out.println(name + " : " + i);
		}
	}
}

public class A2_MakeTreadDemo
{

	public static void main(String[] args)
	{
		Task t1 = new Task();
		Task t2 = new Task();
		
		t1.start();
		t2.start();
		
		System.out.println("End " + Thread.currentThread().getName());
	}

}

//• 1단계 Thread를 상속하는 클래스의 정의와 인스턴스 생성
//• 2단계 쓰레드의 start 메소드 호출


