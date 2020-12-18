package ch10_1;

//Bookshelf                          // 상속(extends)는 기존에 있던 것에 추가하기 위한 목적, 일의 효율

class Book
{
	String title;
	String genre;
	
	void printBook()
	{
		System.out.println("제  목 : " + title);
		System.out.println("장  르 : " + genre);
	}
}

class Novel extends Book
{
	String writer;                    // 멤버 변수(소문자로 시작 = 카멜), 필드
	
	void printNov()                   // 행동 변수
	{
		printBook();                  // 메서드 : ~~~(파라미터 있을 수도 없을 수도); 형태
		System.out.println("저  자 : " + writer);
	}
}

class Magazine extends Book
{
	int day;                           // 멤버 변수(소문자로 시작 = 카멜), 필드
	
	void printMag()                    // 행동 변수
	{
		printBook();
		System.out.println("발매일 : " + day + "일");
	}
}

public class BookShelf         // public,default여야 상속가능 (private x)
{

	public static void main(String[] args)        // class 이름은 main과 동일
	{
		Novel nov = new Novel();
		nov.title = "구운몽";
		nov.genre = "고전문학";
		nov.writer = "김만중";
		
		
		Magazine mag = new Magazine();
		mag.title = "월간 자바 그림책";
		mag.genre = "컴퓨터";
		mag.day = 20;
		
		nov.printNov();
		System.out.println();
		mag.printMag();
	}

}


//파이널 상수 = 파스칼 표기법
//일반 글자, 변수 = 카멜 표기법
//protected 는 자식한테는 public, default이고 친구(다른 package, 다른 폴더)는 private
//변수(자료형)는 Memory(CPU)에 영향을 미침
//GC는 객체 정리 = 시간, 로딩 많이 걸림
//메서드 = 변수, 함수(= ~~~();) / 스택(<-자료형) = memory(연산용) / 힙 = memory(저장용)
//상속은 1단계말고 단계별로 조금씩 여러번 추가할 수 있음



