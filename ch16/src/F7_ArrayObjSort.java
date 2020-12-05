import java.util.Arrays;

class Person1 implements Comparable		
{
	private String name;
	private int age;
	
	public Person1(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	@Override								// 오버라이딩: 생성자 지정 or 
	public int compareTo(Object o)			// 이름 비교를 위한 형변환
	{										// 아스키코드
		Person1 p = (Person1)o;
	
	int nNum = this.name.compareTo(p.name);
	return nNum;							// int type의 생성자는 return;해줌
	}

// 비교를 좀 더 쉽게 하려면	
//	if(this.age > p.age)
//		return 1;
//	else if(this.age < p.age)
//		return -1;
//	else
//		return 0;
	
	@Override                   // 출력 형태 지정
	public String toString()
	{
		return name + ": " + age;
	}
}

public class F7_ArrayObjSort
{

	public static void main(String[] args)
	{
		Person1[] ar = new Person1[3];
		
		ar[0] = new Person1("홍길동", 29);      // 반복된 형태 없으면 내용을 일일이 입력해야 함
		ar[1] = new Person1("전우치", 15);
		ar[2] = new Person1("손오공", 37);
		
		Arrays.sort(ar);       // 배열
		
		for(Person1 p : ar)
			System.out.println(p);
	}
}




// @Override compareTo를 하려면 implements Comparable하지 않으면
// 없다고 인식하여 비교할 수 없음





