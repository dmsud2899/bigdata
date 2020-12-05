import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer2
{

	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String s = "";
		
		try
		{
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");
			
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream() ));
			
			String name = in.readLine();
			System.out.println("[" + name + "]님이 대화방에 입장하셨습니다.");
			out.print("[" + name + "] 대화방 입장");
			
			
			while ( in != null)
			{
				s= in.readLine();
				
				if( s == null)
					break;
				if( s.equals("q") || s.equals("Q"))
					break;
					
				System.out.println(s);
				out.println(name + ">" + s);
			}
			
			System.out.println("서버가 종료되었습니다.");
		}
		catch(Exception e)
		{
			System.out.println("예외1:" + e);
			//e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
				out.close();	//소켓은 내가 꺼도 살아 있음 ex) 엑셀하다가 튕겼는데 살아있는 경우
								//관리자가 없는 상태에서 다른 사람이 사용 = pc자체를 꺼야 함
				
				socket.close();
				serverSocket.close();
			}
			catch(Exception e)
			{
				System.out.println("예외2:" + e);
				//e.printStackTrace();
			}
		}
		
	}
}



