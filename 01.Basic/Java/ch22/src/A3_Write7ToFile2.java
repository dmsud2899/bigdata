import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A3_Write7ToFile2
{

	public static void main(String[] args)
	{
		OutputStream out = null;
		
		try
		{
			out = new FileOutputStream("dtat.dat");
			out.write(66);
		}
		catch(IOException e)
		{
			
		}
		
		finally
		{
			if(out != null)
			{
				try
				{
					out.close();
				}
				catch(IOException e2)
				{
					
				}
			}
		}
	}

}

// A1과 같음
//아웃풋스트림은 out.close();
//FileInputStrema은 파일에서
//NetworkInputStream은 네트워크에서
//byte를 in.read() 읽기 때문에 int로 int dat


