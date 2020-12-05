

class Person
{
	String name;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable      // 부르지 않아도 자동으로 실행되고 죽음
	{
		super.finalize();
		System.out.println("destroyed: " + name);
	}
}

public class A_ObjectFinalize
{

	public static void main(String[] args)
	{
		Person p1 = new Person("홍길동");
		Person p2 = new Person("전우치");
		
		p1 = null;  // 참조 대상을 가비지 컬렉션의 대상으로 만듬
		p2 = null;
		
		System.gc(); // null을 heap에서 지우기 위해 가비지 컬렉터를 실행
		System.runFinalization();  //가비지 컬렉터가 실행되지 않을 수도 있기에 실행시킴
		
		System.out.println("end of program");
	}

}




