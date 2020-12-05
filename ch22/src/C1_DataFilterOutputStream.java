import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//입출력 필터 스트림의 예
//기본 자료형 데이터의 출력을 위한 필터 스트림

public class C1_DataFilterOutputStream
{

	public static void main(String[] args)
	{
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat")))
		{
			out.writeInt(370);
			out.writeDouble(3.14);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}

//C1을 실행하고 C2실행
//


