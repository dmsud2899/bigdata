package ch13;

public class A1_ArrayIsInstance
{

	public static void main(String[] args)
	{
		// 길이가 5인 int형 1차원 배열의 생성
		int[] ar1 = new int[5];
		
		// 길이가 7인 double형 1차원 배열의 생성
		double[] ar2 = new double[7];
		
		// 배열의 참조변수와 인스턴스 생성 분리
		float[] ar3;
		ar3 = new float[9];
		
		// 배열의 인스턴스 변수 접근
		System.out.println("배열 ar1 길이: " + ar1.length); //ar1.length에서 length는 멤버변수
		System.out.println("배열 ar2 길이: " + ar2.length);
		System.out.println("배열 ar3 길이: " + ar3.length);
	}

}


// length(); 는 메서드 = stack에 쌓임 <-> .length 는 멤버변수 = heap에 생성
// .length는 heap에 미리 공간을 확보해두는 것.
// 그래서 공간을 5확보했다가 6으로 변경은 안됨
// 변경하려면 새로 만들어야 함.
// java에서만 array가 class이기 때문에 heap에 생성




