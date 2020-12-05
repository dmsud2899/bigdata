import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class D3_TextWriter
{

	public static void main(String[] args)
	{
		try(Writer out = new FileWriter("data1.txt"))
		{
			for(int ch = (int)'A'; ch < (int)('Z'+1); ch++)		//대문자
				out.write(ch);
			
			out.write(13);		//	아스키코드표 참고(\n)
			out.write(10);		//	아스키코드표 참고(\r)
			
			for(int ch = (int)'A'+32; ch< (int)('Z'+1+32); ch++)	//소문자
				out.write(ch);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}


