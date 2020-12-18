import java.time.Duration;
import java.time.LocalTime;

// LocalTIme클래스와 Duration클래스

public class A5_LocalTimeDemo2
{

	public static void main(String[] args)
	{
		//PC방의 PC이용 시작 시각
		LocalTime start = LocalTime.of(14, 24, 35);
		System.out.println("PC 이용 시작 시각: " + start);
		
		//PC방의 PC이용 종료 시각
		LocalTime end = LocalTime.of(17, 31, 19);
		System.out.println("PC 이용 종료 시각: " + end);
		
		//PC 이용 시간 계산
		Duration between = Duration.between(start, end);
		System.out.println("총 PC 이용 시간: " + between);
		System.out.println("총 PC 이용 시간: " + between.toHours() + "시간 "
										 + (between.toMinutes()%60 + "분 "
										 + (between.toSeconds()%60 + "초 ")));
		
		System.out.println('\n' + "---------------------------" + '\n');
		
		//현재시각
		LocalTime now = LocalTime.now();
		System.out.println("지금시각: " + now);
		
		//BTS의 티켓팅 시작 시각
		LocalTime bStart = LocalTime.of(15, 00, 00);
		System.out.println("티켓팅 시작 시각: " + bStart);
				
		//BTS의 티켓팅 시작까지 시간
		Duration bBetween = Duration.between(now, bStart);
		System.out.println("티켓팅 시작까지: " + bBetween);
		System.out.println("티켓팅 시작까지: " + bBetween.toHours() + "시간 "
										 + (bBetween.toMinutes()%60 + "분 "
										 + (bBetween.toSeconds()%60 + "초 ")));
	}												

}

//시각 차 계산에도 Duration 클래스가 사용된다.
//PT3H6M44S: 3시간 6분 44초

