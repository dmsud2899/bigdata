import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//파일에서 기본 자료형 데이터 읽기 : 버퍼링 기능 추가(입력)

public class C5_BufferedDataInputStream
{

	public static void main(String[] args)
	{
		try(DataInputStream in =
				new DataInputStream(
						new BufferedInputStream(
								new FileInputStream("data.dat"))))
		{
			int num1 = in.readInt();
			double num2 = in.readDouble();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}


