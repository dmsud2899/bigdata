import java.io.FileWriter;
import java.io.Writer;

public class D1_SimpleWriter
{

	public static void main(String[] args)
	{
		try(Writer out = new FileWriter("data.txt"))
		{
			out.write('A');
			out.write('한');
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

// 이클립스 설정에서 문자셋을 UTF-8로지정한 경우
//ch22 파일들어가서 data.txt를 notepad로 읽어보면 A한이 찍힌 것을 볼 수 있음
// Wirter = 글자 읽음
//char = 2byte
//글자 두 개 넣은 이유
//사람 눈으로 읽을 수 있는 데이터(문자) = Writer, Reader(=기반스트림)로 처리
//사람 눈으로 확인하기 힘든 데이터(바이트) = input, output

