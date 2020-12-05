package ch10_8;

//키워드 this 사용하기
//클래스의 은닉화 : 
//- 변수에 직접적인 접근을 막는다.
//- getter,setter를 통해 변수에 접근한다

class SimpleBox
{
	private int num;
	
	SimpleBox(int num)
	{
		this.num = num;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public void setNum(int num0)
	{
		this.num = num + 1;
	}
}

public class ThisUseEx
{

	public static void main(String[] args)
	{
		SimpleBox box = new SimpleBox(5);
		box.setNum(10);
		System.out.println(box.getNum());

	}

}

//this는 해당 클래스
//의도가 같은 변수는 같은 이름의 변수로



