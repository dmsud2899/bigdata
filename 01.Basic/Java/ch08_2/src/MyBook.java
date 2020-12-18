class Book
{
	int price;
	int num = 0;
	String title;
	
	Book()                              // 생성자가 없으면 자동으로 Book(){}를 만듬
	{
		title = "자바 프로그래밍";      // 동작을 넣으려면 직접 이렇게 추가해서 입력
		price = 5000;
	}
	
	Book(String t, int p)      //오버로딩(객체가 두개 이상) / 파라미터를 입력한 경우
	{											   	
		title = t;
		price = p;
	}
	
	void print()
	{
		System.out.println("제  목 : " + title);
		System.out.println("가  격 : " + price);
		System.out.println("주문수량 : " + num);
		System.out.println("합계금액 : " + price * num);
	}
}


public class MyBook
{

	public static void main(String[] args)
	{
		Book book1 = new Book("자바 디자인패턴", 10000);  //13번라인에 맞춰 파라미터 입력
		book1.num = 10;
		book1.print();
		
		Book book2 = new Book();  //13번라인에 맞춰 파라미터 입력
		book2.num = 20;
		book2.print();

	}

}


// 생성자는 클래스 이름과 같은 메서드명을 가진다.
// 생성자는 메서드이지만 리턴형이 없다
//
// 디폴트 생성자(파라미터 없는 애)는 자동으로 생성된다.
//
// 파라미터가 있는 생성자를 만들면 (오버로딩하면)
// 디폴트 생성자가 자동으로 생성되지 않는다.


