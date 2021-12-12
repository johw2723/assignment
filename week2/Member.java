package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class Member {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		// 기본 값 설정	
		UUID[] key = {UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),
					  UUID.randomUUID(),UUID.randomUUID()};
		
		String[] name = {"홍길동", "강감찬", "유관순", "이순신", "장영실"};
		
		MemberDTO dto = new MemberDTO();
		dto.setKey(key);
		dto.setName(name);
		
		System.out.println("1. 전체 조회 | 2. 회원 조회 | 3. 회원 추가 | 4. 회원 갱신 | 5. 회원 삭제");
		int N = input_check(br.readLine());
		
		// 비즈니스 로직 호출
		service(N, dto);

		System.out.println("서비스가 종료되었습니다.");
	}

	// 입출력 값 검증
	private static int input_check(String str) {
		int N = 0;
		
		try {
			N = Integer.parseInt(str);

		} catch(NumberFormatException e) {
			System.out.println("유효하지 않은 입력입니다.");
		}
		return N;
	}

	// 비즈니스 로직 관련 메소드
	private static void service(int N, MemberDTO dto) throws IOException {
	
		// 전체 회원 정보 조회
		if(N == 1) {
			if(dto.getKey().length == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				for(int i=0; i<dto.getKey().length; i++) {
					System.out.println("[key] : " + dto.getKey()[i] + " [value] : " + dto.getName()[i]);
				}
			}	
		}
		
		// key로 회원 정보 조회
		else if(N == 2) {
			System.out.println("조회할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			int count = 0;
			
			if(dto.getKey().length == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				try {
					for(int i=0; i<dto.getKey().length; i++) {
						count++;
						if(dto.getKey()[i].equals(UUID.fromString(str))) {
							// getKey에서 동일한 값이 있는 위치를 찾은 후 해당 위치를 getName에 적용
							String value = dto.getName()[i];
							System.out.println("회원명 : " + value);
							count = 0;
						} else {
							// 모든 조회에서 없을 경우 출력
							if(count == dto.getKey().length) {
								System.out.println("회원 정보가 없습니다.");
							}
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("유효하지 않은 ID 값 입니다.");
				}
			}		
		}
		
		// 회원 정보 추가
		else if(N == 3) {
			System.out.println("새로 등록할 회원명을 입력해주세요.");
			String str = br.readLine();
			
			// 배열 복사하기
			int arr_length = dto.getKey().length;			// 기존 배열 길이
			UUID[] copy_key = new UUID[arr_length+1];		// key 복사 배열
			String[] copy_name = new String[arr_length+1];	// name 복사 배열
			
			for(int i=0; i<arr_length; i++) {
				// 복사한 배열에 값 채우기
				copy_key[i] = dto.getKey()[i]; 
				copy_name[i] = dto.getName()[i];
			}
			
			// 새로운 값 추가
			copy_key[arr_length] = UUID.randomUUID();
			copy_name[arr_length] = str;
			
			// DTO 갱신
			dto.setKey(copy_key);
			dto.setName(copy_name);

			System.out.println("회원 등록이 완료되었습니다.");
		}
		
		// key 회원 정보 갱신
		else if(N == 4) {
			System.out.println("갱신할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			int count = 0;
			
			if(dto.getKey().length == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				try {
					for(int i=0; i<dto.getKey().length; i++) {
						count++;
						if(dto.getKey()[i].equals(UUID.fromString(str))) {
							// getKey에서 동일한 값이 있는 위치를 찾은 후 해당 위치를 getName에 적용
							System.out.println("변경할 회원명을 입력해주세요.");
							String str2 = br.readLine();
							
							// 배열 복사하기
							int arr_length = dto.getKey().length;			// 기존 배열 길이
							String[] copy_name = new String[arr_length];	// name 복사 배열
							
							for(int j=0; j<arr_length; j++) {
								// 복사한 배열에 값 채우기 
								copy_name[j] = dto.getName()[j];
							}
							
							// 값 갱신
							copy_name[i] = str2;
							
							// DTO 갱신
							dto.setName(copy_name);
							
							System.out.println(str2 + "(으)로 회원명이 변경되었습니다.");
							count = 0;
						} else {
							// 모든 조회에서 없을 경우 출력
							if(count == dto.getKey().length) {
								System.out.println("회원 정보가 없습니다.");
							}
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("유효하지 않은 ID 값 입니다.");
				}
			}
		}
		
		// key 회원 정보 삭제
		else if(N == 5) {
			System.out.println("삭제할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();		
			int count = 0;
			
			// 배열 생성
			int arr_length = dto.getKey().length;			// 기존 배열 길이
			//UUID[] key = new UUID[arr_length];				// 기존 배열 값을 넣을 key 배열
			//String[] name = new String[arr_length];			// 기존 배열 값을 넣을 name 배열
			UUID[] copy_key = new UUID[arr_length-1];		// key 복사 배열
			String[] copy_name = new String[arr_length-1];	// name 복사 배열
			int temp_i = 0;	
			String temp_name = null;
			
			for(int i=0; i<arr_length; i++) {		 
				count++;
				
				// 값 확인하기
				try {
					if(dto.getKey()[i].equals(UUID.fromString(str))) {
						// getKey에서 동일한 값이 있는 위치를 찾은 후 해당 위치를 기록
						temp_name = dto.getName()[i];
						temp_i = i;
						count = 0;
					} else {
						// 모든 조회에서 없을 경우 출력
						if(count == dto.getKey().length) {
							System.out.println("회원 정보가 없습니다.");
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("유효하지 않은 ID 값 입니다.");
				}
		
			}
			
			// 값 채우기
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
							
			// DTO 갱신
			dto.setKey(copy_key);
			dto.setName(copy_name);
			
			System.out.println(temp_name + "님의 회원 정보가 삭제되었습니다.");
		}
		
		String temp = br.readLine();
		if(!temp.isEmpty()) {
			try {
				N = Integer.parseInt(temp);
				service(N, dto);
			} catch(NumberFormatException e) {
				System.out.println("유효하지 않은 입력입니다.");
				temp = br.readLine();
				service(N, dto);
			}
			
		}
		
	}

}
