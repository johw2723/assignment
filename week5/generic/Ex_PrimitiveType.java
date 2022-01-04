package week5.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex_PrimitiveType {

	public static void main(String[] args) {
		//List<Integer> list = new ArrayList<>();
		List<int> list = new ArrayList<>(); 
		// JVM 런타임과 호환성 유지를 위해서 제네릭으로 사용되는 모든 항목은 Object로 변환 가능해야 한다.
		
		list.add(1);
		list.add(2);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
