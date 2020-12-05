

public class B2_StringEuqality
{

	public static void main(String[] args)
	{
		String str1 = new String("So Simple");
		String str2 = new String("So Simple");
		
		//참조 대상(id)을 비교하는 if ~else문
		if(str1 == str2)
			System.out.println("str1, str2 참조 대상 동일하다.");
		else
			System.out.println("str1, str2 참조 대상 다르다.");
		
		// 두 인스턴스 내용을 비교하는 if ~else문
		if(str1.equals(str2))
			System.out.println("str1, str2 내용 동일하다.");
		else
			System.out.println("str1, str2 내용 다르다.");
	}

}

// string에서 ==과 equals의 차이
// string 클래스는 내용 비교를 하는 형태로 equals메서드를 오버라이딩


