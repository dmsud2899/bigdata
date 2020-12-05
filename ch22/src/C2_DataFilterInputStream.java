import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//입출력 필터 스트림의 예
//기본 자료형 데이터의 입력을 위한 필터 스트림

public class C2_DataFilterInputStream
{

	public static void main(String[] args)
	{
		try(DataInputStream in =
				new DataInputStream(new FileInputStream("data.dat")))
		{
			int num1 = in.readInt();
			double num2 = in.readDouble();
			
			System.out.println(num1);
			System.out.println(num2);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}


