package ch12;

public class C1_BuildString
{

	public static void main(String[] args)
	{
		StringBuilder stbuf = new StringBuilder("123");
		
		stbuf.append(45678);
		System.out.println(stbuf.toString());
		
		stbuf.delete(0, 2);
		System.out.println(stbuf.toString());        // 오버로딩
		
		stbuf.replace(0, 3, "AB");
		System.out.println(stbuf.toString());
		
		stbuf.reverse();
		System.out.println(stbuf.toString());
		
		String sub = stbuf.substring(2,4);
		System.out.println(sub);
		
	}

}


//



