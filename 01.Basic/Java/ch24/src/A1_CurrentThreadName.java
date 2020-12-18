
//
public class A1_CurrentThreadName
{

	public static void main(String[] args)
	{
		Thread ct = Thread.currentThread();
		String name = ct.getName();
		System.out.println(name);
	}

}

//쓰레드
//● 프로그램 내에서 실행의 흐름을 이루는 최소의 단위
//● main 메소드의 실행도 하나의 쓰레드에 의해 진행이 된다.
//● 동시에 여러 프로그램을 실행시킴


