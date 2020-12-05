import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class D4_StringWriter
{

	public static void main(String[] args)
	{
		String ks = "공부에 있어서 돈이 꼭 필요한 것은 아니다.";
		String es = "Life is long if you know how to use it.";
		
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter("String.txt")))
		{
			bw.write(ks, 0, ks.length());
			bw.newLine();	// 줄 바꿈 문자를 삽입 (운영체제 별 줄 바꿈의 표시 방법이 다름)
			bw.write(es, 0, es.length());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}

//* 개행문자 : 컴퓨터에서줄바꿈을 나타내는 제어문자
//1. LF(Line Feed) : 커서를 한칸 아래로 이동하여 새로운 라인을 추가 (아스키 코드 :10)
//2. CR(Carrige Return) : 커서를 맨왼쪽으로이동 (아스키 코드 : 13)
//* Java는 운영체제의종류에 맞게 자동으로 줄바꿈 문자를 변경해준다.
//1. 윈도우 : CRLF(\r\n)
//2. 유닉스 : LF(\n)
//3. 맥 : CR(\r)

//public String readLine() throws IOException / BufferedReader의 메소드
//→ 문자열 반환, 반환할 문자열 없으면 null 반환
//public void write(String s,int off,int len) throws IOException / BufferedWriter의 메소드
//→ 문자열 s를 인덱스 off에서부터 len개의 문자까지 저장


