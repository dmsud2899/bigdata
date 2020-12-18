import java.util.Arrays;

class INum2
{
	private int num;
	
	public INum2(int num)
	{
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this.num == ((INum2)obj).num)
			return true;
		else
			return false;
	}
}

public class F5_ArraysObjEquals2
{

	public static void main(String[] args)
	{
		INum2[] ar1 = new INum2[3];
		INum2[] ar2 = new INum2[3];
		
		ar1[0] = new INum2(1);
		ar2[0] = new INum2(1);
		
		
		ar1[1] = new INum2(2);
		ar2[1] = new INum2(2);
		
		ar1[2] = new INum2(3);
		ar2[2] = new INum2(3);
		
		System.out.println(Arrays.equals(ar1, ar2));

	}

}


//Arrays(상수)의 경우는 equals하면 내용을 비교 ex) ch16-F3
//객체(new)의 경우는 equals를 오버라이딩하지 않으면, 객체의 id를 비교 ex) ch16-F4
//오버라이딩하면 객체의 내용을 비교 ex) ch16-F5
//new 클래스[]의 범위 > new 클래스()의 범위

// 즉, Array(ch16-F3)를 equals하면 내용 비교시 상수를 비교
// new [](ch16-F4)를 equals하면 내용이 객체니까 객체를 비교
// override로 형 변환(obg -> int)하면(ch16-F5) 내용 비교시 상수 비교


