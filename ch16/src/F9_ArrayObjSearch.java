import java.util.Arrays;

class Person2 implements Comparable		// compareTo를 위해서 implements comparable를 해야 함
{
	private String name;
	private int age;
	
	public Person2(String name, int age)
	{
		this.name = name;
		this.age =age;
	}
	
	@Override
	public int compareTo(Object o)    // age 오버라이딩 정의 
	{
		Person2 p = (Person2)o;
		return this.age - p.age;
	}
	
	@Override
	public String toString()		// age와 name 출력 오버라이딩 정의
	{
		return name + ": " + age;
	}
}
public class F9_ArrayObjSearch
{

	public static void main(String[] args)
	{
		Person2[] ar = new Person2[3];
		ar[0] = new Person2("홍길동 ", 29);
		ar[1] = new Person2("전우치 ", 15);
		ar[2] = new Person2("손오공 ", 37);
		
		Arrays.sort(ar);		// 객체 대상으로 binarysearch를 위해서 sort를 해야 함
		
		int idx = Arrays.binarySearch(ar, new Person2("Who are you? ", 37)); //나이가 37인 인스턴스 찾기
		System.out.println(ar[idx]);
	}

}


// 인스턴스(객체)를 대상으로 한 찾기


