import java.util.Random;

public class E3_RandomNumberGenerator
{

	public static void main(String[] args)
	{
		Random rand = new Random();	
		//		public Random()  
		//		{
		//			// Random(long seed) 생성자 호출
		//		this(System.currentTimeMillis());
		//		}
for(int i = 0; i<7; i++)
System.out.print(rand.nextInt(10)+ " ");
}

}
