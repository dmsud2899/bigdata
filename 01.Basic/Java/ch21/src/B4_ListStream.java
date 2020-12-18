import java.util.Arrays;
import java.util.List;

// 배열 대상 다양한 메서드들4
// 컬렉션 인스턴스를 대상으로 스트림 생성하기

public class B4_ListStream
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("Toy", "Robot", "Box");
		
		list.stream()
			.forEach(s -> System.out.print(s + '\t'));
		
		System.out.println();
	}

}


//원본을 한 번 사용해야 하기 때문에 new(X)
//ch18에 List


