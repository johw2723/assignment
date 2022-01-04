package week5.generic;

import java.util.ArrayList;
import java.util.List;

public class Ex_Generic {

	public static void main(String[] args) {
		// <> 제네릭 : <> 안에 타입 파라미터를 선언, 사용할 객체의 타입을 지정
		// 실행 시 타입 에러가 나는 것 대신 컴파일 시에 미리 타입을 체크해서 에러를 사전에 방지한다.
		
		// 장점 
		// 다룰 객체의 타입을 미리 명시하여 객체의 형변환을 사용할 필요가 없다 -> 불필요한 형변환을 줄여 코드를 간결하게 함
		// 의도하지 않은 타입의 객체가 저장되는 것을 막음 -> 타입의 안정성
		
		// 단점
		// 코드가 축약됨에 따라 이해에 어려움이 있을 수 있다.
		// 확장성이 낮아진다.
		
		List list = new ArrayList(); //제네릭을 사용하지 않을경우
		list.add("홍길동");
		String temp = (String) list.get(0); //타입변환이 필요함
		        
		List<String> list2 = new ArrayList<>(); //제네릭을 사용할 경우 (뒷 부분 자료형은 굳이 적지 않아도 명확하다)
		list2.add("홍길동");
		temp = list2.get(0); //타입변환이 필요없음
		
		// 와일드카드
		// <?> : 타입 파라미터를 대치하는 것으로 모든 클래스나 인터페이스 타입이 올 수 있다.
		// <? extends 상위타입> : 와일드카드의 범위를 특정 객체의 하위 클래스만 올 수 있습니다.
		// <? super 하위타입> :  와일드카드의 범위를 특정 객체의 상위 클래스만 올 수 있습니다.
	}

}


