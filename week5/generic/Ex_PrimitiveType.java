package week5.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex_PrimitiveType {

	public static void main(String[] args) {
		//List<Integer> list = new ArrayList<>();
		List<int> list = new ArrayList<>(); 
		// JVM ��Ÿ�Ӱ� ȣȯ�� ������ ���ؼ� ���׸����� ���Ǵ� ��� �׸��� Object�� ��ȯ �����ؾ� �Ѵ�.
		
		list.add(1);
		list.add(2);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
