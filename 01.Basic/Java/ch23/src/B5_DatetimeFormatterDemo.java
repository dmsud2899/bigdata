import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//날짜와 시각 정보의 출력 포맷 지정
//y, M, d는 각각 년, 월, 일의 출력을 의미
//H, m, s는 각각 시, 분, 초의 출력을 의미
//VV는 시간대 ID의 출력을 의미

public class B5_DatetimeFormatterDemo
{

	public static void main(String[] args)
	{
		ZonedDateTime date = ZonedDateTime.of(
				LocalDateTime.of(2020, 4, 5, 7, 9), ZoneId.of("Asia/Seoul"));
		
		DateTimeFormatter fm1 = 
				DateTimeFormatter.ofPattern("yy-M-d");
		DateTimeFormatter fm2 = 
				DateTimeFormatter.ofPattern("yyyy-MM-d, H:m:s");
		DateTimeFormatter fm3 = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd, a HH:mm:ss VV");
		
		System.out.println(date.format(fm1));
		System.out.println(date.format(fm2));
		System.out.println(date.format(fm3));
	}

}

// formatter : 날짜 및 시간의 포맷을 지정 함
// -,:, 등등 아무거나 사용 가능
// M(month) <-> m(minute)
// H: 12시간단위 <-> HH: 24시간 단위
// pdf. ch23에 날짜와 시각 정보의 출력 포맷 있음

