

class INum
{
	private int num;
	
	public INum(int num)
	{
		this.num = num;
	}


	@Override
	public boolean equals(Object obj)
	{
		if(this.num == ((INum)obj).num)           // heap에 적절한 형변환
			return true;						  // syso하면 id가 출력됨
		else
			return false;
	}
}

public class B1_ObjectEquality
{

	public static void main(String[] args)
	{
		
		INum number1 = new INum(10);       // new를 선언했기에 각자 다른 heap
		INum number2 = new INum(12);
		INum number3 = new INum(10);       // new가 아니었으면 num1을 참조했을 것
		
		if(number1.equals(number2))
			System.out.println("num1, num2 내용 동일하다.");
		else
			System.out.println("num1, num2 내용 다르다.");
		
		if(number1.equals(number3))
			System.out.println("num1, num3 내용 동일하다.");
		else
			System.out.println("num1, num3 내용 다르다.");
	}

}


// string에서는 글자 내용 비교를 위한 equals가 있지만 obj id 비교 외에는 없음
// 그래서 따로 class로 오버라이딩하여 heap에 적절한 형변환을 통해 equals를 만듬
// 오버라이딩 없으면 num1. 하면 오버라이딩이 INum으로 되는 것을 확인할 수 있음
// 오버라이딩 하면 obj로 오버라이딩되는 것을 확인할 수 있음





