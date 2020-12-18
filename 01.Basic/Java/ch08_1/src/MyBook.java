class Book             // book 클래스
{
	String title;      // 필드(변수)들
	String author;
	int money;
}

public class MyBook
{
	public static void main(String[] args)    // main에 있는 class와 파일명 동일해야 함
	{ 
		Book book1 = new Book();              // book 클래스
		{
			book1.title = "자바 프로그래밍";  // 오브젝트(객체)들
			book1.author = "홍길동";
			book1.money = 15000;
					
			System.out.println(book1.title + " : " + 
								book1.author + " : " + 
								book1.money);
		}
	}

}



