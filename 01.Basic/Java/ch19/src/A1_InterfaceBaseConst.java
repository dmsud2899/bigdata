
interface Scale	// 인터페이스 내에 선언된 변수는 public, static, final이 선언된 것으로 간주
{
	int DO = 0;		int RE = 1;
	int MI = 2;		int FA = 3;
	int SO = 4;		int RA = 5;
	int TI = 6;
}

public class A1_InterfaceBaseConst
{

	public static void main(String[] args)
	{
		int sc = Scale.DO;
		
		switch(sc)
		{
			case Scale.DO:
				System.out.println("도~ ");
				break;
				
			case Scale.RE:
				System.out.println("레~ ");
				break;
				
			case Scale.MI:
				System.out.println("미~ ");
				break;
				
			case Scale.FA:
				System.out.println("파~ ");
				break;
				
			default:
				System.out.println("솔~ 라~ 시~ ");
				break;
				
			
		}

	}

}

