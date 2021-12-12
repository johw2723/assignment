package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Member {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Map<UUID, String> map = new HashMap<UUID, String>();
		
		// 기본 값 등록
		map.put(UUID.randomUUID(), "홍길동");
		map.put(UUID.randomUUID(), "강감찬");
		map.put(UUID.randomUUID(), "유관순");
		map.put(UUID.randomUUID(), "이순신");
		map.put(UUID.randomUUID(), "장영실");
		
		System.out.println("1. 전체 조회 | 2. 회원 조회 | 3. 회원 추가 | 4. 회원 갱신 | 5. 회원 삭제");
		int N = input_check(br.readLine());
		
		// 비즈니스 로직 호출
		service(N, map);

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
	private static void service(int N, Map<UUID, String> map) throws IOException {
	
		// 전체 회원 정보 조회
		if(N == 1) {
			if(map.isEmpty()) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				for(UUID i : map.keySet()) {
					System.out.println("[key] : " + i + " [value] : " + map.get(i));
				}
			}	
		}
		
		// key로 회원 정보 조회
		else if(N == 2) {
			System.out.println("조회할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			
			try {
				String value = map.get(UUID.fromString(str));
				
				if(value == null) {
					System.out.println("회원 정보가 없습니다.");
				}
				else {
					System.out.println("회원명 : " + value);
				}
				
			} catch(IllegalArgumentException e) {
				System.out.println("유효하지 않은 ID 값 입니다.");
			}		
				
		}
		
		// 회원 정보 추가
		else if(N == 3) {
			System.out.println("새로 등록할 회원명을 입력해주세요.");
			String str = br.readLine();
			map.put(UUID.randomUUID(), str);
			System.out.println("회원 등록이 완료되었습니다.");
		}
		
		// key 회원 정보 갱신
		else if(N == 4) {
			System.out.println("갱신할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			
			try {
				String value = map.get(UUID.fromString(str));
				
				if(value == null) {
					System.out.println("회원 정보가 없습니다.");
				}
				else {
					System.out.println("변경할 회원명을 입력해주세요.");
					String str2 = br.readLine();
					map.put(UUID.fromString(str), str2);
					System.out.println(str2 + "(으)로 회원명이 변경되었습니다.");
				}
				
			} catch(IllegalArgumentException e) {
				System.out.println("유효하지 않은 ID 값 입니다.");
			}
		}
		
		// key 회원 정보 삭제
		else if(N == 5) {
			System.out.println("삭제할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			
			try {
				String value = map.get(UUID.fromString(str));
				
				if(value == null) {
					System.out.println("회원 정보가 없습니다.");
				}
				else {
					System.out.println(map.remove(UUID.fromString(str)) + "님의 회원 정보가 삭제되었습니다.");
				}
				
			} catch(IllegalArgumentException e) {
				System.out.println("유효하지 않은 ID 값 입니다.");
			}
		}
		
		// 전체 회원 정보 삭제
		/*else if(N == 6) {
			System.out.println("모든 회원 정보가 삭제됩니다. 진행하시겠습니까?");
			System.out.println("삭제 하시려면 1을 입력해주십시오.");
			
			String str = br.readLine();
			if(str.equals("1")) {
				map.clear();
				System.out.println("모든 회원정보가 삭제되었습니다.");
			}
			else {
				System.out.println("삭제가 취소되었습니다.");
			}
		}*/
		
		String temp = br.readLine();
		if(!temp.isEmpty()) {
			N = Integer.parseInt(temp);
			service(N, map);
		}
		
	}

}
