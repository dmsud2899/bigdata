
class Book
{
	int bookNumber;
	String bookTitle;
	
	Book(int bookNumber, String bookTitle)
	{
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
	}
	
	@Override
	public String toString()
	{
		return bookTitle + ", " + bookNumber;
	}
}

public class B3_ToString
{

	public static void main(String[] args)
	{
		Book book1 = new Book(200, "자바의 기초");
		
		System.out.println(book1);
		System.out.println(book1.toString());

	}

}


//string에서는 내용 출력, 어떤 내용을 정의할 것인지 기본적으로 구현되어 있음
//object에서는 어떤 내용을 출력할 것인지 구현하기 위해 toString()을 재정의하는 클래스를 생성



