import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class F4_CopyList
{

	public static void main(String[] args)
	{
		List<String> src = Arrays.asList("Box", "Apple", "Toy", "Robot");
		
		//복사본을 만들어서 사용
		List<String> dest = new ArrayList<>(src);	//두번째 <>에서는 string 생략 가능
		
		//정렬하여 그 결과를 출력
		Collections.sort(dest);				// sort로 abc순으로 정렬
		System.out.println(dest);
		
		//사정상 정렬 이전의 상태로 되돌려야 함 / 그래서 원본인 src(line11)를 갖고 있었음
		Collections.copy(dest, src);		//list는 list로 copy, set은 set으로 copy
		
		//되돌림 확인
		System.out.println(dest);
	}

}


