import java.time.LocalDate;

public class A2_LocalDateDemo1
{

	public static void main(String[] args)
	{
		//오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		
		//올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// 올 해의 크리스마스 이브
		LocalDate eve = xmas.minusDays(1);
		System.out.println("Xmas eve: " + eve);

	}

}

//LocalDate의 메소드		/ 이 외에 보려면 open Declaration
//public LocalDate minusYears(long yearsToSubtract)
//public LocalDate minusMonths(long monthsToSubtract)
//public LocalDate minusDays(long daysToSubtract)


