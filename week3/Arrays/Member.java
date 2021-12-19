package week3.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

public class Member {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		/*List<MemberDTO> list = Arrays.asList(
				new MemberDTO(UUID.randomUUID(), "홍길동")
				, new MemberDTO(UUID.randomUUID(), "강감찬")
				, new MemberDTO(UUID.randomUUID(), "유관순")
				, new MemberDTO(UUID.randomUUID(), "이순신")
				, new MemberDTO(UUID.randomUUID(), "장영실")
		);*/
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO(UUID.randomUUID(), "홍길동"));
		list.add(new MemberDTO(UUID.randomUUID(), "강감찬"));
		list.add(new MemberDTO(UUID.randomUUID(), "유관순"));
		list.add(new MemberDTO(UUID.randomUUID(), "이순신"));
		list.add(new MemberDTO(UUID.randomUUID(), "장영실"));
					
		/*List<ArrayList<MemberDTO>> stream = Arrays.asList(list);
		stream.stream().forEach(i -> i.forEach(
								j -> System.out.println("[key] : " + j.getKey() + " [name] : " + j.getName())));
		System.out.println();*/
	
		System.out.println("1. 전체 조회 | 2. 회원 조회 | 3. 회원 추가 | 4. 회원 갱신 | 5. 회원 삭제");
		int N = input_check(br.readLine());
		
		// 비즈니스 로직
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
				list.stream().forEach(a -> System.out.println("[key] : " + a.getKey() + " [name] : " + a.getName()));
			}	
		}
		
		// key로 회원 정보 조회
		else if(N == 2) {
			System.out.println("조회할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			
			if(list.size() == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				try {
					String member = list.stream()
							.filter(m -> m.getKey().equals(UUID.fromString(str)))
							.findAny().get().getName();
					System.out.println("회원명 : " + member);		
				} catch(IllegalArgumentException e) {
					System.out.println("유효하지 않은 ID 값 입니다.");
				} catch(NoSuchElementException e) {
					System.out.println("조회된 정보가 없습니다.");
				}
			}		
		}

		// 회원 정보 추가
		else if(N == 3) {
			System.out.println("새로 등록할 회원명을 입력해주세요.");
			String str = br.readLine();
			
			list.add(new MemberDTO(UUID.randomUUID(), str));

			System.out.println("회원 등록이 완료되었습니다.");
		}
		
		// key 회원 정보 갱신
		else if(N == 4) {
			System.out.println("갱신할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();
			
			if(list.size() == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			else {
				try {
					// 값 조회
					list.stream()
					.filter(m -> m.getKey().equals(UUID.fromString(str)))
					.findAny().get().getName();
					
					System.out.println("변경할 회원명을 입력해주세요.");
					String str2 = br.readLine();
						
					// 값 갱신
					list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
					.findAny().get().setName(str2);
						
					System.out.println(str2 + "(으)로 회원명이 변경되었습니다.");		
					
				} catch(IllegalArgumentException e) {
					System.out.println("유효하지 않은 ID 값 입니다.");
				} catch(NoSuchElementException e) {
					System.out.println("조회된 정보가 없습니다.");
				}
			}
		}

		// key 회원 정보 삭제
		else if(N == 5) {
			System.out.println("삭제할 회원 ID 값을 입력해주세요.");
			String str = br.readLine();		
			
			try {
				String member = list.stream()
						.filter(m -> m.getKey().equals(UUID.fromString(str)))
						.findAny().get().getName();
				// 값 제거
				list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
				.collect(Collectors.toList()).forEach(a -> list.remove(a));
				
				System.out.println(member + "님의 회원 정보가 삭제되었습니다.");		
			} catch(IllegalArgumentException e) {
				System.out.println("유효하지 않은 ID 값 입니다.");
			} catch(NoSuchElementException e) {
				System.out.println("조회된 정보가 없습니다.");
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
