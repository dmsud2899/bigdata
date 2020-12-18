import java.util.ArrayList;
import java.util.List;

class ToyPriceInfo
{
	private String model; 		//은닉화
	private int price;
	
	public ToyPriceInfo(String m, int p)
	{
		model = m;				//변수는 생성했지만 해당 예제에서 사용하지는 않았음
		price = p;
	}
	
	public int getPrice()
	{
		return price;
	}
}
public class C4_ToyStream
{

	public static void main(String[] args)
	{
		List<ToyPriceInfo> ls = new ArrayList<>();	//뒤에 generic(?)은 생략 가능
		ls.add(new ToyPriceInfo("GUN_LR_45", 200));
		ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
		ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));
		
		int sum = ls.stream()							//steam은 new(X)
					.filter(p -> p.getPrice() < 500)
					.mapToInt(t -> t.getPrice())
					.sum();
		
		System.out.println("sum = " + sum);
	}

}

// class특징 4개: 추상화,은닉화,상속,다형성


