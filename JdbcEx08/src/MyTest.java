public class MyTest
{

	public static void main(String[] args)
	{
//		twoNumAdd(1, 2);			//memory 빈 공간에 들어감 / towNumAdd가 static일 때
		MyTest mt = new MyTest();	//mt는 stack, new MyTest는 heap에
//		mt.twoNumAdd(1, 2);			//towNumAdd가 static이 아닐 때
		mt.myInit();
	}
	
//	public void twoNumAdd(int n1, int n2)
//	{
//		System.out.println(n1 + n2);
//	}
	
	public void myInit()			//static main에 있던 것을 새로운 메서드로 만듬
	{								//static에 올리는 코드를 줄여 줌
		System.out.println("엄청 많은 일");
		System.out.println("엄청 많은 일");
		System.out.println("엄청 많은 일");
		System.out.println("엄청 많은 일");
		System.out.println("엄청 많은 일");
	}

}


