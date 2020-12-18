import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Book
{
	private String title;
	public String author;
	
	public Book(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
}

public class G1_StringClassTest
{

	public static void main(String[] args)
			throws ClassNotFoundException
		{
			Class strClass = Class.forName("Book");
			
			Constructor[] cons = strClass.getConstructors();
			for(Constructor c : cons)
			{
				System.out.println(c);
			}
		
			System.out.println("-----------------------");
			Field[] fields = strClass.getFields();
			for(Field f : fields)
			{
				System.out.println(f);
			}
			System.out.println("-----------------------");
			Method[] methods = strClass.getMethods();
			for(Method m : methods)
			{
				System.out.println(m);
			}
		}
	

}


//
//class라는 클래스임
//은닉화 이유 = 다른 회사에 코드를 모두 알려주고 싶지 않아서
//코드가 없어도 .class만 있으면 사용 가능
//getFields(); = 멤버변수
//getMethods(); = 멤버메서드


