package week5.generic;

import java.util.HashSet;
import java.util.Iterator;

public class Ex_HashSet {

	public static void main(String[] args) {
		Object obj = "김성주";
		String str = "유재석";
		
		// 제네릭 미사용
		HashSet set = new HashSet();
		set.add(obj);
		set.add(str);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// 제네릭 사용1
		HashSet<String> gSet1 = new HashSet<>();
		gSet1.add((String) obj); // 형 변환 필요
		gSet1.add(str);
		
		// Iterator<Object> gIt = gSet1.iterator(); 불가
		Iterator<String> gIt1 = gSet1.iterator();
		while(gIt1.hasNext()) {
			System.out.println(gIt1.next());
		}
		
		// 제네릭 사용2
		HashSet<Object> gSet2 = new HashSet<>();
		gSet2.add(obj); // 형 변환이 없어도 된다.
		gSet2.add(str);
		
		//Iterator<String> gIt2 = gSet2.iterator(); 불가
		Iterator<Object> gIt2 = gSet2.iterator();		
		while(gIt2.hasNext()) {
			System.out.println(gIt2.next());
		}
		
	}

}
