import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A5_Write7ToFile3
{

	public static void main(String[] args)
	{
		try(OutputStream out = new FileOutputStream("data.csv"))
		{
			out.write(65);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}


//입출력 스트림 관련 코드의 개선 : try~with~resource기반


