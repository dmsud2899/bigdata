import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

// 두 LocalDateTime 인스턴스 간의 시각과 날짜의 차

public class A8_DurationDemo
{

	public static void main(String[] args)
	{
		LocalDateTime dt1 = LocalDateTime.of(2020,  Month.JANUARY, 12, 15, 30);
		LocalDateTime dt2 = LocalDateTime.of(2020, Month.FEBRUARY, 12, 15, 30);
		
		LocalDateTime dt3 = LocalDateTime.of(2020,  Month.JANUARY, 12, 15, 30);
		LocalDateTime dt4 = LocalDateTime.of(2020,  Month.FEBRUARY, 13, 14, 29);
		
		Duration drDate1 = Duration.between(dt1,  dt2);
		System.out.println(drDate1);
		
		System.out.println(drDate1);
		
		Duration drDate2 = Duration.between(dt3,  dt4);
		System.out.println(drDate2);
	}

}

//Line 15~16: 하루, 59분 뒤

//PT744H 744/24 = 31일
//PT766H59M 766-744 = 22시간 59분

//Q&A = stackoverflow, github

