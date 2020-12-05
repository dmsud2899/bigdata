public class E1_SBox implements java.io.Serializable
{
	String s;
	
	public E1_SBox(String s)
	{
		this.s = s;
		
	}
	
	public String get()
	{
		return s;
	}

}


//Serializable 인터페이스 : 내용이 외부로 유출되므로 직렬화 의도를 표시해야 함
//직렬화의도 : implements java.io.Serializable(마커인터페이스)
//clonable에서도 마커인터페이스 추가했음
// maker interface는 구현코드가(ex.@Override) 따로 없음



