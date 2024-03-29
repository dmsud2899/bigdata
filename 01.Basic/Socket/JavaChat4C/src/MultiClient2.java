import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
// 클라이언트에 while문 적용
// 콘솔 멀티채팅 클라이언트 프로그램
public class MultiClient2
{

	public static void main(String[] args)
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
			
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
										socket.getInputStream() ));
			
			out.println(name);
			
			while (out != null)
			try 
			{
				// 입력
				if(in != null)
				{
					System.out.println("Receive : " + in.readLine());
				}
				
				//출력
				String s = sc.nextLine();
				out.println(s);
				
				if(s.equals("q") || s.equals("Q"))
				{
					break;
				}
			}
			catch (IOException e)
			{
				System.out.println("예외:" + e);
			}
			
			in.close();
			out.close();
			
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println("예외(MultiClient class]:" + e);
		}


	}

}

