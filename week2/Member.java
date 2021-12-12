package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class Member {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		// �⺻ �� ����	
		UUID[] key = {UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),
					  UUID.randomUUID(),UUID.randomUUID()};
		
		String[] name = {"ȫ�浿", "������", "������", "�̼���", "�念��"};
		
		MemberDTO dto = new MemberDTO();
		dto.setKey(key);
		dto.setName(name);
		
		System.out.println("1. ��ü ��ȸ | 2. ȸ�� ��ȸ | 3. ȸ�� �߰� | 4. ȸ�� ���� | 5. ȸ�� ����");
		int N = input_check(br.readLine());
		
		// ����Ͻ� ���� ȣ��
		service(N, dto);

		System.out.println("���񽺰� ����Ǿ����ϴ�.");
	}

	// ����� �� ����
	private static int input_check(String str) {
		int N = 0;
		
		try {
			N = Integer.parseInt(str);

		} catch(NumberFormatException e) {
			System.out.println("��ȿ���� ���� �Է��Դϴ�.");
		}
		return N;
	}

	// ����Ͻ� ���� ���� �޼ҵ�
	private static void service(int N, MemberDTO dto) throws IOException {
	
		// ��ü ȸ�� ���� ��ȸ
		if(N == 1) {
			if(dto.getKey().length == 0) {
				System.out.println("��ϵ� ȸ�� ������ �����ϴ�.");
			}
			else {
				for(int i=0; i<dto.getKey().length; i++) {
					System.out.println("[key] : " + dto.getKey()[i] + " [value] : " + dto.getName()[i]);
				}
			}	
		}
		
		// key�� ȸ�� ���� ��ȸ
		else if(N == 2) {
			System.out.println("��ȸ�� ȸ�� ID ���� �Է����ּ���.");
			String str = br.readLine();
			int count = 0;
			
			if(dto.getKey().length == 0) {
				System.out.println("��ϵ� ȸ�� ������ �����ϴ�.");
			}
			else {
				try {
					for(int i=0; i<dto.getKey().length; i++) {
						count++;
						if(dto.getKey()[i].equals(UUID.fromString(str))) {
							// getKey���� ������ ���� �ִ� ��ġ�� ã�� �� �ش� ��ġ�� getName�� ����
							String value = dto.getName()[i];
							System.out.println("ȸ���� : " + value);
							count = 0;
						} else {
							// ��� ��ȸ���� ���� ��� ���
							if(count == dto.getKey().length) {
								System.out.println("ȸ�� ������ �����ϴ�.");
							}
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("��ȿ���� ���� ID �� �Դϴ�.");
				}
			}		
		}
		
		// ȸ�� ���� �߰�
		else if(N == 3) {
			System.out.println("���� ����� ȸ������ �Է����ּ���.");
			String str = br.readLine();
			
			// �迭 �����ϱ�
			int arr_length = dto.getKey().length;			// ���� �迭 ����
			UUID[] copy_key = new UUID[arr_length+1];		// key ���� �迭
			String[] copy_name = new String[arr_length+1];	// name ���� �迭
			
			for(int i=0; i<arr_length; i++) {
				// ������ �迭�� �� ä���
				copy_key[i] = dto.getKey()[i]; 
				copy_name[i] = dto.getName()[i];
			}
			
			// ���ο� �� �߰�
			copy_key[arr_length] = UUID.randomUUID();
			copy_name[arr_length] = str;
			
			// DTO ����
			dto.setKey(copy_key);
			dto.setName(copy_name);

			System.out.println("ȸ�� ����� �Ϸ�Ǿ����ϴ�.");
		}
		
		// key ȸ�� ���� ����
		else if(N == 4) {
			System.out.println("������ ȸ�� ID ���� �Է����ּ���.");
			String str = br.readLine();
			int count = 0;
			
			if(dto.getKey().length == 0) {
				System.out.println("��ϵ� ȸ�� ������ �����ϴ�.");
			}
			else {
				try {
					for(int i=0; i<dto.getKey().length; i++) {
						count++;
						if(dto.getKey()[i].equals(UUID.fromString(str))) {
							// getKey���� ������ ���� �ִ� ��ġ�� ã�� �� �ش� ��ġ�� getName�� ����
							System.out.println("������ ȸ������ �Է����ּ���.");
							String str2 = br.readLine();
							
							// �迭 �����ϱ�
							int arr_length = dto.getKey().length;			// ���� �迭 ����
							String[] copy_name = new String[arr_length];	// name ���� �迭
							
							for(int j=0; j<arr_length; j++) {
								// ������ �迭�� �� ä��� 
								copy_name[j] = dto.getName()[j];
							}
							
							// �� ����
							copy_name[i] = str2;
							
							// DTO ����
							dto.setName(copy_name);
							
							System.out.println(str2 + "(��)�� ȸ������ ����Ǿ����ϴ�.");
							count = 0;
						} else {
							// ��� ��ȸ���� ���� ��� ���
							if(count == dto.getKey().length) {
								System.out.println("ȸ�� ������ �����ϴ�.");
							}
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("��ȿ���� ���� ID �� �Դϴ�.");
				}
			}
		}
		
		// key ȸ�� ���� ����
		else if(N == 5) {
			System.out.println("������ ȸ�� ID ���� �Է����ּ���.");
			String str = br.readLine();		
			int count = 0;
			
			// �迭 ����
			int arr_length = dto.getKey().length;			// ���� �迭 ����
			//UUID[] key = new UUID[arr_length];				// ���� �迭 ���� ���� key �迭
			//String[] name = new String[arr_length];			// ���� �迭 ���� ���� name �迭
			UUID[] copy_key = new UUID[arr_length-1];		// key ���� �迭
			String[] copy_name = new String[arr_length-1];	// name ���� �迭
			int temp_i = 0;	
			String temp_name = null;
			
			for(int i=0; i<arr_length; i++) {		 
				count++;
				
				// �� Ȯ���ϱ�
				try {
					if(dto.getKey()[i].equals(UUID.fromString(str))) {
						// getKey���� ������ ���� �ִ� ��ġ�� ã�� �� �ش� ��ġ�� ���
						temp_name = dto.getName()[i];
						temp_i = i;
						count = 0;
					} else {
						// ��� ��ȸ���� ���� ��� ���
						if(count == dto.getKey().length) {
							System.out.println("ȸ�� ������ �����ϴ�.");
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("��ȿ���� ���� ID �� �Դϴ�.");
				}
		
			}
			
			// �� ä���
			for(int i=0; i<arr_length-1; i++) {
				if(i!=temp_i) {
					copy_key[i] = dto.getKey()[i];
					copy_name[i] = dto.getName()[i];
				}
				else {
					break;
				}
			}	
			
			for(int i=temp_i+1; i<arr_length-1; i++) {
				copy_key[i] = dto.getKey()[i];
				copy_name[i] = dto.getName()[i];	
			}
							
			// DTO ����
			dto.setKey(copy_key);
			dto.setName(copy_name);
			
			System.out.println(temp_name + "���� ȸ�� ������ �����Ǿ����ϴ�.");
		}
		
		String temp = br.readLine();
		if(!temp.isEmpty()) {
			try {
				N = Integer.parseInt(temp);
				service(N, dto);
			} catch(NumberFormatException e) {
				System.out.println("��ȿ���� ���� �Է��Դϴ�.");
				temp = br.readLine();
				service(N, dto);
			}
			
		}
		
	}

}
