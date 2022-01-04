package week5.generic;

import java.util.HashSet;
import java.util.Iterator;

public class Ex_HashSet {

	public static void main(String[] args) {
		Object obj = "�輺��";
		String str = "���缮";
		
		// ���׸� �̻��
		HashSet set = new HashSet();
		set.add(obj);
		set.add(str);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// ���׸� ���1
		HashSet<String> gSet1 = new HashSet<>();
		gSet1.add((String) obj); // �� ��ȯ �ʿ�
		gSet1.add(str);
		
		// Iterator<Object> gIt = gSet1.iterator(); �Ұ�
		Iterator<String> gIt1 = gSet1.iterator();
		while(gIt1.hasNext()) {
			System.out.println(gIt1.next());
		}
		
		// ���׸� ���2
		HashSet<Object> gSet2 = new HashSet<>();
		gSet2.add(obj); // �� ��ȯ�� ��� �ȴ�.
		gSet2.add(str);
		
		//Iterator<String> gIt2 = gSet2.iterator(); �Ұ�
		Iterator<Object> gIt2 = gSet2.iterator();		
		while(gIt2.hasNext()) {
			System.out.println(gIt2.next());
		}
		
	}

}
