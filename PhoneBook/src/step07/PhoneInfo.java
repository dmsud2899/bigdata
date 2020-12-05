package step07;

public class PhoneInfo implements java.io.Serializable  //마커인터페이스 <- 저장용도
{
	String name;
	String phoneNumber;
	String email;
	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber, String email)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void showPhoneInfo()
	{
		System.out.println("Name : " + name);
		System.out.println("PhoneNumber : " + phoneNumber);
		if (email != null && !email.equals(""))		//!email.equals("")먼저 (X)
			System.out.println("Email : " + email);
		System.out.println("----------------------------------------");
	}
	
}


