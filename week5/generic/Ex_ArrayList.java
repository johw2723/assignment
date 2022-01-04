package week5.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex_ArrayList {

	public static void main(String[] args) {
		Object obj = "�輺��";
		String str = "��ȣ��";
		
		// ���׸� �̻��
		ArrayList objList = new ArrayList();
		objList.add(obj);
		objList.add(str);
		
		Iterator objIt = objList.iterator();
		while(objIt.hasNext()) {
			System.out.println(objIt.next());
		}
		
		// ���׸� ���1
		ArrayList<String> gList = new ArrayList<>();
		gList.add((String) obj); // �� ��ȯ�� �ʿ��ϴ�
		gList.add(str);
		
		// Iterator<Object> gIt = gList.iterator(); �Ұ�
		Iterator<String> gIt = gList.iterator();
		while(gIt.hasNext()) {
			System.out.println(gIt.next());
		}
		
		// Iterator<Object> gIt2 = gList.iterator(); �Ұ�
		
		
		// ���׸� ���2
		ArrayList<Object> gList2 = new ArrayList<>();
		gList2.add(obj);  // �� ��ȯ�� ��� �ȴ�.
		gList2.add(str);
		
		//Iterator<String> gIt2 = gList2.iterator(); �Ұ�
		Iterator<Object> gIt2 = gList2.iterator();
		while(gIt2.hasNext()) {
			System.out.println(gIt2.next());
		}

	}

}
