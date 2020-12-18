import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

//1K바이트 버퍼 기반 파일 복사 프로그램

public class B2_BufferedFileCopier
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("대상 파일: ");
		String src = sc.nextLine();
		
		System.out.print("사본 이름: ");
		String dst = sc.nextLine();
		
		try(InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst))
		{
			
			byte buf[] = new byte[1024]; 	// 1K
			int len;
			
			Instant start = Instant.now();
			
			while(true)
			{
				len = in.read(buf);
				if(len == -1)	// -1이 되면 더 이상 읽을 파일이 없음을 의미
					break;
				out.write(buf, 0, len);
			}
			
			Instant end = Instant.now();
			System.out.println("Sequential Processing Time: " +
					Duration.between(start, end).toMillis());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}

//Line35: 배열 buf로 데이터를 읽어 들이고,
//더이상 읽어 들일 데이터 없으면 -1 반환
//한번에 1024개를 읽어들임
//값이 클 수록 더 빠름

//ssd는 moter가 돌지 않으며 memory구조와 비슷, 빈자리를 씀, 비용이 더 듬
//file IO(input,output) = 파일입출력

// ex) 이미지 파일, 음악파일, 실행파일 등등
//         그 이유는 모든 파일들은 바이트 형식의 데이터로 이루어졌기 때문이다
//         그래서 예를 들어 이미지를 분석하고자 한다면 이처럼 바이트 형식으로 추출하여 이미지 규격에 알맞게 대입해보자


//출처: https://csw7432.tistory.com/entry/Java-Input-Output-Stream [최느님 프알못]

