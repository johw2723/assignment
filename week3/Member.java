package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class Member {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();	
		
		// DTO 객체 생성
		MemberDTO dto1 = new MemberDTO();
		MemberDTO dto2 = new MemberDTO();
		MemberDTO dto3 = new MemberDTO();
		MemberDTO dto4 = new MemberDTO();
		MemberDTO dto5 = new MemberDTO();
		
		// 기본 값 설정
		dto1.setKey(UUID.randomUUID());
		dto1.setName("홍길동");
		
		dto2.setKey(UUID.randomUUID());
		dto2.setName("강감찬");
		
		dto3.setKey(UUID.randomUUID());
		dto3.setName("유관순");
		
		dto4.setKey(UUID.randomUUID());
		dto4.setName("이순신");
		
		dto5.setKey(UUID.randomUUID());
		dto5.setName("장영실");
		
		// 리스트에 추가
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		list.add(dto4);
		list.add(dto5);
		
		System.out.println("1. 전체 조회 | 2. 회원 조회 | 3. 회원 추가 | 4. 회원 갱신 | 5. 회원 삭제");
		int N = input_check(br.readLine());
		
		// 비즈니스 로직 호출
		service(N, list);

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
	private static void service(int N, ArrayList<MemberDTO> list) throws IOException {
	
		// 전체 회원 정보 조회
		if(N == 1) {
			if(list.size() == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				for(int i=0; i<list.size(); i++) {
					System.out.println("[key] : " + list.get(i).getKey() + " [value] : " + list.get(i).getName());
				}
			}	
		}
		
		// key로 회원 정보 조회
		else if(N == 2) {
			System.out.println("조회할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			int count = 0;
			
			if(list.size() == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				try {
					for(int i=0; i<list.size(); i++) {
						if(list.get(i).getKey().equals(UUID.fromString(str))) {
							// list 에서 동일한 값이 있다면
							String value = list.get(i).getName();
							System.out.println("회원명 : " + value);
							count = 0;
						} else {
							// list 에서 동일한 값이 없다면
							if(count == list.size()) {
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
			
			MemberDTO dto = new MemberDTO();
			dto.setKey(UUID.randomUUID());
			dto.setName(str);
			
			// DTO 갱신
			list.add(dto);

			System.out.println("회원 등록이 완료되었습니다.");
		}
		
		// key 회원 정보 갱신
		else if(N == 4) {
			System.out.println("갱신할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			int count = 0;
			
			if(list.size() == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				try {
					for(int i=0; i<list.size(); i++) {
						count++;
						if(list.get(i).getKey().equals(UUID.fromString(str))) {
							// getKey에서 동일한 값이 있는 위치를 찾은 후 해당 위치를 getName에 적용
							System.out.println("변경할 회원명을 입력해주세요.");
							String str2 = br.readLine();
							
							// 값 갱신
							list.get(i).setName(str2);
							
							System.out.println(str2 + "(으)로 회원명이 변경되었습니다.");
							count = 0;
						} else {
							// 모든 조회에서 없을 경우 출력
							if(count == list.size()) {
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
			
			for(int i=0; i<list.size(); i++) {		 
				count++;
				
				// 값 확인하기
				try {
					if(list.get(i).getKey().equals(UUID.fromString(str))) {
						// getKey에서 동일한 값이 있는 위치를 찾은 후 해당 위치를 기록
						String temp = list.get(i).getName();
						list.remove(i);
						System.out.println(temp + "님의 회원 정보가 삭제되었습니다.");
						count = 0;
					} else {
						// 모든 조회에서 없을 경우 출력
						if(count == list.size()) {
							System.out.println("회원 정보가 없습니다.");
						}
					}
				} catch(IllegalArgumentException e) {
					System.out.println("유효하지 않은 ID 값 입니다.");
				}
		
			}
	
		}
		
		String temp = br.readLine();
		if(!temp.isEmpty()) {
			try {
				N = Integer.parseInt(temp);
				service(N, list);
			} catch(NumberFormatException e) {
				System.out.println("유효하지 않은 입력입니다.");
				temp = br.readLine();
				service(N, list);
			}
			
		}
		
	}

}
