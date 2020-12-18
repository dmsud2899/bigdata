package ch11;

public class WhatYourName
{

	public static void main(String[] args)
	{
		AAA aaa = new AAA();
		aaa.showName();
		
		ZZZ zzz = new ZZZ();
		zzz.showName();

	}

}


// dos창 -> D: -> cd src파일주소 -> dir확인 -> 
// javac WhatYourName.java -> java WhatYourName ->dir
// 한글 : -encoding javac UTF-8 WhatYourName
// dos창에서 실행은 정해진 폴더 내에서만 실행
// 환경변수에서 path를 설정하면 해결
// set: 등록된 환경변수 리스트
// set path
// . : 부모 폴더
// .. : 내 폴더
// cd . :부모 폴더로 이동




