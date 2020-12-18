
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

//서버로 메시지를 전송하는 클래스
//리시버 분리
//현재 q로 정료하면 에러 발생 

public class Receiver4 extends Thread
{
	Socket socket;
	BufferedReader in = null;
	
	//Socket을 매개변수로 받는 생성자
	public Receiver4(Socket socket)
	{
		this.socket = socket;
		
		try
		{
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream() ));
		}
		catch(Exception e)
		{
			System.out.println("예외:" + e);
		}
	}
	
	//run()메서드 재정의
	@Override
	public void run()
	{
		while(in != null)
		{
			try
			{
				//입력은 main 쓰레드에서 받기 때문에 다음 코드는 작동하지 않음
				/*
				String s = in.readLine();
				if(s.equals("q") || s.equals("Q"))
				{
					break;
				}
				else
				{
					system.out.println("Thread Receive : " + s);
				}
				 */
				
				System.out.println("Thread Receive : " + in.readLine());
			}
			catch(java.net.SocketException ne)
			{
				//여기서 while문을 멈춰줘야 함
				break;
			}
			catch (Exception e)
			{
				System.out.println("예외2:" + e);
			}
		}
		try
		{
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("예외3:" + e);	//여기서 while문을 멈춰줘야 함
		}
		
	}
}
