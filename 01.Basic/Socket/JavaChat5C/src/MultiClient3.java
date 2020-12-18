import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient3
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		System.out.println("이름을 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		PrintWriter out = null;
		BufferedReader in = null;
		
		try
		{
			String ServerIP = "localhost";	//IP 파라미터를 받음
			if(args.length > 0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999); //소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다.....");
			
			// 서버에서 보내는 메세지를 사용자의 콘솔에 출력하는 쓰레드
			Thread receiver = new Receiver3(socket);
			receiver.start();
			
			out = new PrintWriter(socket.getOutputStream(), true);
			
			out.println(name);
			
			while (out != null)
			{
				try
				{//출력
					String s = sc.nextLine();
					out.println(s);
					
					if(s.equals("q") || s.equals("Q"))
					{
						break;
					}
				}
				catch (Exception e)
				{
					System.out.println("예외:" +e);
				}
			}
			
			out.close();
			
			socket.close();
			
		}
		catch (Exception e)
		{
			System.out.println("예외[MultiClient class]:" +e);
		}
		
	}

}

//thread 만들 때 client가 에러면 receiver도 에러가 날 수 있음

