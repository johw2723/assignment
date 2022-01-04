package week5.generic;

import java.util.HashMap;
import java.util.Iterator;

public class Ex_HashMap {

	public static void main(String[] args) {
		Object obj = "김성주";
		Object obj2 = "SBS";
		String str = "강호동";
		String str2 = "KBS";
		
		// 제네릭 미사용
		HashMap map = new HashMap();
		map.put(obj, obj2);
		map.put(str, str2);
		
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key + " " +map.get(key));
		}	
		
		// 제네릭 사용1
		HashMap<Object, Object> gMap1 = new HashMap<>();
		gMap1.put(obj, obj2); // 형 변환 불필요
		gMap1.put(str, str2);
		
		// Iterator<String> gIterator1 = gMap1.keySet().iterator(); 불가
		Iterator<Object> gIterator1 = gMap1.keySet().iterator();
		while(gIterator1.hasNext()) {
			String key = (String) gIterator1.next();
			System.out.println(key + " " +gMap1.get(key));
		}	
		
		// 제네릭 사용2
		HashMap<String, String> gMap2 = new HashMap<>();
		gMap2.put((String) obj, (String) obj2); // 형 변환 필요
		gMap2.put(str, str2);
		
		// Iterator<Object> gIterator2 = gMap2.keySet().iterator(); 불가
		Iterator<String> gIterator2 = gMap2.keySet().iterator();
		while(gIterator2.hasNext()) {
			String key = (String) gIterator2.next();
			System.out.println(key + " " +gMap2.get(key));
		}

	}

}
