package ch12;

public class A1_StringInst
{
	public static void showString(String str)
	{
		System.out.println(str);
		System.out.println(str.length());
	}
	
	
	public static void main(String[] args)
	{
		// 둘 다 String 인스턴스의 생성으로 이어지고
		// 그 결과 인스턴스의 참조 값이 반환된다.
		// Debug 모드로 id 살펴보기
		
		String str1 = new String("Simple String");
		String str2 = "The Best String";              // 17과 같이 new가 아니기 때문에 stack,heap
		String str3 = "The Best String";              // 18과 19는 같은 객체, 같은 id 참조 stack,같은heap
		
		System.out.println(str1);
		System.out.println(str1.length());
		
		System.out.println();   // 개행 : 메서드 오버로딩
		
		System.out.println(str2);
		System.out.println(str2.length());
		
		System.out.println();
		
		// showString("Funny String);
		showString(str3);

	}

}

// debug에서
// stack = variables
// Expressions = static
// 18이나 19의 string이 바뀌면 다른 id(heap)로 바뀜



