
public class B1_SwitchBasic
{

	public static void main(String[] args)
	{
		int n = 3;
		
		switch(n) 
		{
			case 1:
				System.out.println("Simple Java");
			case 2:
				System.out.println("Funny Java");
			case 3:
				System.out.println("Fantastic Java");
			default:
				System.out.println("The best programming language");
		}
		
		System.out.println("Do you like Java?");

	}

}

// case와 default는 레이블! 따라서 실행 위치를 표시하는 용도로 사용될 뿐!
