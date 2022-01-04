package week5.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex_ArrayList {

	public static void main(String[] args) {
		Object obj = "김성준";
		String str = "강호동";
		
		// 제네릭 미사용
		ArrayList objList = new ArrayList();
		objList.add(obj);
		objList.add(str);
		
		Iterator objIt = objList.iterator();
		while(objIt.hasNext()) {
			System.out.println(objIt.next());
		}
		
		// 제네릭 사용1
		ArrayList<String> gList = new ArrayList<>();
		gList.add((String) obj); // 형 변환이 필요하다
		gList.add(str);
		
		// Iterator<Object> gIt = gList.iterator(); 불가
		Iterator<String> gIt = gList.iterator();
		while(gIt.hasNext()) {
			System.out.println(gIt.next());
		}
		
		// Iterator<Object> gIt2 = gList.iterator(); 불가
		
		
		// 제네릭 사용2
		ArrayList<Object> gList2 = new ArrayList<>();
		gList2.add(obj);  // 형 변환이 없어도 된다.
		gList2.add(str);
		
		//Iterator<String> gIt2 = gList2.iterator(); 불가
		Iterator<Object> gIt2 = gList2.iterator();
		while(gIt2.hasNext()) {
			System.out.println(gIt2.next());
		}

	}

}
