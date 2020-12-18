import java.util.Arrays;
import java.util.stream.IntStream;

public class A1_MyFirstStream
{

	public static void main(String[] args)
	{
		int[] ar = {1, 2, 3, 4, 5};
		
		//스트림 생성
		IntStream stm1 = Arrays.stream(ar);
		
		//중간 파이프 구성
		IntStream stm2 = stm1.filter(n -> n%2 ==1);
		
		//최종 파이프 구성
		int sum = stm2.sum();
		
		System.out.println(sum);

	}

}

//제네릭 > 컬렉션 > 람다 > 스트림
//한 번 생성하고 사용한 스트림은 재사용 불가
//지연 연산: 최종 연산이 호출되어야 중간 연산의 결과가 모두 적용됨.
//중간 연산: filter(): 트루인 변수만 반환, map(), sorted() 등
//최종 연산: forEach() : 요소를 하나씩 꺼내 옴, count() : 요소의 개수, sum() : 요소의 합 등
//for문의 불편함을 개선하기 위해 collection 등장 후 stream 등장
//파이프: 데이터가 하나씩 연이어서 물흐르듯 들어오는 느낌 형상화


