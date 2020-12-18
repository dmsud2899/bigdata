
public class A_UserWrapperClass
{

	public static void main(String[] args)
	{
		String a = "34";
		int b = 50;
		int c = Integer.parseInt(a);
		int d = c + b;
		
		System.out.println(a + " + " + b + " = " + d);

	}

}

//
// class.method = static method : utility method
// String = 문자열
// parseInt(); = none static method
// 래퍼 인스턴스들은 담고 있는 값을 수정하지 못한다.
// 따라서 값의 수정이 필요하면 새로운 래퍼 인스턴스를 생성해야 한다.


