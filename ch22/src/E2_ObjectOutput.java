import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//ObjectOutputStream 예제
//앞의 E1_SBox가 만들어져 있어야 한다.

public class E2_ObjectOutput
{

	public static void main(String[] args)
	{	//stack에 두개 		/heap에 두개
		E1_SBox box1 = new E1_SBox("Robot");
		E1_SBox box2 = new E1_SBox("Strawberry");
		
		try(ObjectOutputStream oo =
				new ObjectOutputStream(new FileOutputStream("Object.bin")))
		{
			oo.writeObject(box1);
			oo.writeObject(box2);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}

// binary문서임
// 그래서 E3로 읽어들임


