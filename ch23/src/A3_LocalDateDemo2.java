import java.time.LocalDate;
import java.time.Period;

//Period 클래스: 날짜의 차를 표현

public class A3_LocalDateDemo2
{

	public static void main(String[] args)
	{
		// 오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		
		// 올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		//크리스마스까지 앞으로 며칠?
		Period left = Period.between(today, xmas);
		System.out.println(left);
		System.out.println("Xmas까지 앞으로 " +
				left.getMonths() + "개월 " + left.getDays() + "일");
		
		// 내년의 크리스마스
		LocalDate nXmas = LocalDate.of(2021, 12, 25);
		System.out.println("nXmas: " + nXmas);
		
		//내년 크리스마스까지 앞으로 며칠?
		Period nLeft = Period.between(today, nXmas);
		System.out.println(nLeft);
		System.out.println("Xmas까지 앞으로 " +
				+nLeft.getYears() + "년 "+ nLeft.getMonths() + "개월 " + left.getDays() + "일");
	}

}

//P1M20D : 1개월 20일


