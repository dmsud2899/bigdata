package ch10_3;

import java.util.Random;

public class StaticEx2
{
	static int num;
	
	// static 초기화 블록    메서드나 변수만 static으로 했을 때랑 달리 실행 전에 미리 생성
	static
	{
		Random rand = new Random();
		num = rand.nextInt(100);
	}

	public static void main(String[] args)
	{
		System.out.println(num);
		
		

	}

}

// 나중에 메서드나 변수가 많아지면 거의 사용 안함
// main 또는 다음 줄에 브레이크포인트
// F11로 디버깅
// Expressions에 StaticEx2.num을 입력
// F6으로 한 줄씩 실행하여 변화 확인
// 디버깅 없애려면 terminate 빨간 버튼


