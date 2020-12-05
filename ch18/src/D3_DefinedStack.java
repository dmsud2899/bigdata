import java.util.ArrayDeque;
import java.util.Deque;

interface DIStack<E>
{
	public boolean push(E item);
	public E pop();
}

class DCStack<E> implements DIStack<E>
{
	private Deque<E> deq;
	
	public DCStack(Deque<E> d)
	{
		deq = d;
	}
	
	public boolean push(E item)
	{
		return deq.offerFirst(item);
	}
	
	public E pop()
	{
		return deq.pollFirst();
	}
}

public class D3_DefinedStack
{

	public static void main(String[] args)
	{
		DIStack<String> stk = new DCStack<>(new ArrayDeque<String>());
		
		//PUSH 연산
		stk.push("1.Boy");
		stk.push("2.Toy");
		stk.push("3.Robot");
		
		//POP 연산
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		
	}

}


//• 앞으로 넣고, 꺼내고, 확인하기
//boolean offerFirst(E e) 넣기
//E pollFirst() 꺼내기
//E peekFirst() 확인하기
//• 뒤로 넣고, 꺼내고, 확인하기
//boolean offerLast(E e) 넣기
//E pollLast() 꺼내기
//E peekLast() 확인하기
//
//• 앞으로 넣고, 꺼내고, 확인하기
//void addFirst(E e) 넣기
//E removeFirst() 꺼내기
//E getFirst() 확인하기
//• 뒤로 넣고, 꺼내고, 확인하기
//void addLast(E e) 넣기
//E removeLast() 꺼내기
//E getLast() 확인하기
//
//넣기, 공간 부족하면 false 반환
//꺼내기, 꺼낼 대상 없으면 null 반환
//확인하기, 확인할 대상 없으면 null 반환



