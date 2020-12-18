import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class C3_BufferedStreamFileCopier
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("대상 파일: ");
		String src = sc.nextLine();
		
		System.out.print("사본 이름: ");
		String dst = sc.nextLine();
		
		try(BufferedInputStream in =  // fileinputstream을 buffered로 받기
				new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream out = // BufferedInputStream
				new BufferedOutputStream(new FileOutputStream(dst))
			)
		{
			
			int data;
			
			Instant start = Instant.now();
			
			while(true)
			{
				data = in.read();
				if(data == -1) //data가 byte일 때는 -1, reader일 때 null(?)
					break;
				out.write(data);
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

//바이트 단위 복사가 진행되어 속도만 신경쓴 B2보다 약간 느리지만,
//버퍼링되므로 속도는 빠르다

