import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//파일에서 기본 자료형 데이터 읽기 : 버퍼링 기능 추가(출력)

public class C4_BufferedDataOutputStream
{

	public static void main(String[] args)
	{
		try(DataOutputStream out =
				new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("data.dat"))))
		{
			out.writeInt(370);
			out.flush();			//버퍼에 데이터가 다 차지 않도록 강제로 출력해서 보냄
			out.writeDouble(3.14);	//메인 Stream에 보조Stream을 추가할 수 있음
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}


