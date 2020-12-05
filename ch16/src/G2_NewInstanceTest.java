class Book2
{
	private String title;
	
	public Book2() {}
	
	public Book2(String title)
	{
		this.title = title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	@Override
	public String toString()  						// 출력
	{
		return title;
	}
}


public class G2_NewInstanceTest
{

	public static void main(String[] args)
		throws ClassNotFoundException, InstantiationException,IllegalAccessException
	{
		Book2 myBook1 = new Book2("홍길동전");			// line 7
		System.out.println(myBook1);
		
		Class pClass = Class.forName("Book2");      	// line 5
		Book2 myBook2 = (Book2)pClass.newInstance();	// Book2에 pclass없음 /line29
		myBook2.setTitle("전우치전");					// line 12
		System.out.println(myBook2);
	}

}

// try,catch 대신 throws -Exception
// new 키워드를 사용하지 않고 클래스 정보를 활용하여 인스턴스를 생성하는 메서드 /line 34


