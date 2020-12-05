package step01;

public class PhoneBook
{

	public static void main(String[] args)
	{
		PhoneInfo pInfo1 = new PhoneInfo("손오공", "010-1234-567", "test1@test.com");
		PhoneInfo pInfo2 = new PhoneInfo("전우치", "010-5678-3829");
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
	}

}

