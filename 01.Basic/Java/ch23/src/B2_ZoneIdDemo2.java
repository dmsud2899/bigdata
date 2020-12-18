import java.time.ZoneId;

// ZoneId 인스턴스 생성 위한 문자열 확인 방법

public class B2_ZoneIdDemo2
{

	public static void main(String[] args)
	{
		ZoneId.getAvailableZoneIds()
			.stream()
			.filter(s -> s.startsWith("Asia"))
			.sorted()
			.forEach(s -> System.out.println(s));
	}

}

