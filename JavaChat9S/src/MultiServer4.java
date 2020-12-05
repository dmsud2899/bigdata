import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer4
{
	ServerSocket serverSocket = null;
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	String s = "";
	String name = "";
	
	//생성자
	public MultiServer4()
	{
		
	}
	
	public void init()
	{
		try
		{
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");
			
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream() ));
			
			name = in.readLine();
			System.out.println("[" + name + "]님이 대화방에 입장하셨습니다.");
			out.println("[" + name + "] 대화방 입장");
			
			while (in != null)
			{
				s= in.readLine();
				
				if( s== null)
					break;
				if(s.equals("q") || s.equals("Q"))
					break;
				
				System.out.println(s);
//				out.println(name + " > " + s);
				sendAllMsg(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
				out.close();
				
				socket.close();
				serverSocket.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//접속된 모든 클라이언트들에게 메세지를 전달
	public void sendAllMsg(String msg)
	{
		try
		{
			out.println(name + " > " + msg);
		}
		catch(Exception e)
		{
			System.out.println("예외:" + e);
		}
	}
	
	
	public static void main(String[] args)
	{
		//서버객체 생성
		MultiServer4 ms = new MultiServer4();
		ms.init();
	}

}
//socket을 new하면 객체가 계속 생성 > 서버 용량이 점점 딸려짐
//2^16 - 50000이상 = 약 만 오천명 thread
//각 각의 client와 연결이 됨
//client끼리는 연결 안됨
//client 모두 나가도 while문이 계속 돌기 때문에 서버가 끝나지 않음


