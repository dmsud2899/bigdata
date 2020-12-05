interface HowLong
{
	int len(String s);		//값을 반환하는 메서드 / 파라미터 하나, 기능 하나
}
public class E4_OneParamAndReturn
{

	public static void main(String[] args)
	{
		HowLong hl = s -> s.length();		//howlong을 통해 string 변수임을 알 수 있음
		//int num = hl.len("I am so happy"); 		//이와 같이 연산 결과가 남는다
		System.out.println(hl.len("I am so happy"));

	}

}


// line10에서 내부적으로 일어나는 과정 String Valueable -> toString
// 

