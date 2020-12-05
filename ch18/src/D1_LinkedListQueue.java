import java.util.LinkedList;
import java.util.Queue;

public class D1_LinkedListQueue
{

	public static void main(String[] args)
	{
		Queue<String> que = new LinkedList<>();
		
		//데이터 저장
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		
		//무엇이 다음에 나올지 확인
		System.out.println("next: " + que.peek());
		
		//첫번째, 두번째 인스턴스 꺼내기
		System.out.println(que.poll());
		System.out.println(que.poll());
		
		//무엇이 다음에 나올지 확인
		System.out.println("next: " + que.peek());
		
		//마지막 인스턴스 꺼내기
		System.out.println(que.poll());
	}

}

//LinkedList<E>는 List<E>와 동시에 Queue<E>를
//구현하는 컬렉션 클래스이다.
//따라서 어떠한 타입의 참조변수로 참조하느냐에
//따라 ‘리스트’로도 ‘큐’로도 동작한다.
//Queue<E> 인터페이스의 메소드들
//boolean add(E e)넣기
//E remove() 꺼내기
//E element() 확인하기
//boolean offer(E e) 넣기,넣을 공간이 부족하면 false 반환
//E poll() 꺼내기, 꺼낼 대상 없으면 null 반환
//E peek() 확인하기, 확인할 대상이 없으면 null 반환


