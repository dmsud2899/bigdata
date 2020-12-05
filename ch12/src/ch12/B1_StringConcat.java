package ch12;

//
//문자열 연결시키기
//

public class B1_StringConcat
{

	public static void main(String[] args)
	{
		String st1 = "Coffee";
		String st2 = "Bread";
		
		String st3 = st1.concat(st2);
//		System.out.println(st1 + st2);    // 처리할게 별로 없을 때
		System.out.println(st3);          // 처리할게 많을 때 편함
		
		String st4 = "Fresh".concat(st3);
		System.out.println(st4);

	}

}




