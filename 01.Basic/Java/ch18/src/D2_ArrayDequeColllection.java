import java.util.ArrayDeque;
import java.util.Deque;

public class D2_ArrayDequeColllection
{

	public static void main(String[] args)
	{
		Deque<String> deq = new ArrayDeque<>();
		
		//앞으로 넣고						 /스택 예제
		deq.offerFirst("1.Boy");
		deq.offerFirst("2.Toy");
		deq.offerFirst("3.Robot");
		
		//앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		System.out.println("-------------------");
		
		//뒤로 넣고							/스택 예제
		deq.offerLast("1.Boy");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		//뒤에서 꺼내기
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		
		System.out.println("-------------------");

		// 뒤로 넣고 						/ queue예제
		deq.offerLast("1.Boy");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		//앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());

	}

}

