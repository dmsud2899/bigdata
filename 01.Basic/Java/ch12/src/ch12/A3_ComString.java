package ch12;

public class A3_ComString
{

	public static void main(String[] args)
	{
		String st1 = "A";  //Apple, Apple
		String st2 = "B";  //apple, Banana
		int cmp;
		
		//인스턴스의 내용 비교 : heap 안의 내용을 비교
		if(st1.equals(st2))
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
		
		cmp = st1.compareTo(st2);
		
		if(cmp == 0)
			System.out.println("두 문자열은 일치합니다.");
		else if(cmp < 0)
			System.out.println("사전의 앞에 위치하는 문자: " + st1);
		else
			System.out.println("사전의 앞에 위치하는 문자: " + st2);
		
		if(st1.compareToIgnoreCase(st2) == 0)
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
	}

}

// == : stack에 있는 변수의 인스턴스(id)를 비교
//      stack에서 실행

// .equals : heap에 있는 인스턴스(id)의 내용(,메서드)을 비교, 같다 틀리다만 비교
//           heap에서 실행

// .compareTo : .equals 내용 + 대소비교(단, 거리가 멀면 값 커지고 비교 힘듬),
//    그래서 0보다 크면(+) 앞에 위치, 0보다 작으면(-) 뒤에 위치를 봄, 대소문자 가림




