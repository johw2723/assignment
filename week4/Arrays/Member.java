package week4.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class Member {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		/*List<MemberDTO> list = Arrays.asList(
				new MemberDTO(UUID.randomUUID(), "?��길동")
				, new MemberDTO(UUID.randomUUID(), "강감�?")
				, new MemberDTO(UUID.randomUUID(), "?���??��")
				, new MemberDTO(UUID.randomUUID(), "?��?��?��")
				, new MemberDTO(UUID.randomUUID(), "?��?��?��")
		);*/
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO(UUID.randomUUID(), "?��길동"));
		list.add(new MemberDTO(UUID.randomUUID(), "강감�?"));
		list.add(new MemberDTO(UUID.randomUUID(), "?���??��"));
		list.add(new MemberDTO(UUID.randomUUID(), "?��?��?��"));
		list.add(new MemberDTO(UUID.randomUUID(), "?��?��?��"));
					
		/*List<ArrayList<MemberDTO>> stream = Arrays.asList(list);
		stream.stream().forEach(i -> i.forEach(
								j -> System.out.println("[key] : " + j.getKey() + " [name] : " + j.getName())));
		System.out.println();*/
	
		System.out.println("1. ?���? 조회 | 2. ?��?�� 조회 | 3. ?��?�� 추�? | 4. ?��?�� 갱신 | 5. ?��?�� ?��?��");
		int N = input_check(br.readLine());
		
		// 비즈?��?�� 로직
		service(N, list);

		System.out.println("?��비스�? 종료?��?��?��?��?��.");
	}

	// ?��출력 �? �?�?
	private static int input_check(String str) {
		int N = 0;
		
		try {
			N = Integer.parseInt(str);

		} catch(NumberFormatException e) {
			System.out.println("?��?��?���? ?��?? ?��?��?��?��?��.");
		}
		return N;
	}


	// 비즈?��?�� 로직 �??�� 메소?��
	private static void service(int N, ArrayList<MemberDTO> list) throws IOException {		
		// ?���? ?��?�� ?���? 조회
		if(N == 1) {
			if(list.size() == 0) {
				System.out.println("?��록된 ?��?�� ?��보�? ?��?��?��?��.");
			}
			else {				
				list.stream().forEach(a -> System.out.println("[key] : " + a.getKey() + " [name] : " + a.getName()));
			}	
		}
		
		// key�? ?��?�� ?���? 조회
		else if(N == 2) {
			System.out.println("조회?�� ?��?�� ID 값을 ?��?��?��주세?��.");
			String str = br.readLine();
			
			if(list.size() == 0) {
				System.out.println("?��록된 ?��?�� ?��보�? ?��?��?��?��.");
			}
			else {
				try {
					String member = list.stream()
							.filter(m -> m.getKey().equals(UUID.fromString(str)))
							.findAny().get().getName();
					System.out.println("?��?���? : " + member);		
				} catch(IllegalArgumentException e) {
					System.out.println("?��?��?���? ?��?? ID �? ?��?��?��.");
				} catch(NoSuchElementException e) {
					System.out.println("조회?�� ?��보�? ?��?��?��?��.");
				}
			}		
		}

		// ?��?�� ?���? 추�?
		else if(N == 3) {
			System.out.println("?���? ?��록할 ?��?��명을 ?��?��?��주세?��.");
			String str = br.readLine();
			
			// 방법1
			// list.add(new MemberDTO(UUID.randomUUID(), str));
		
			ArrayList<MemberDTO> list2 = new ArrayList<>(Arrays.asList(new MemberDTO(UUID.randomUUID(), str)));			
			
			// 방법2
			/*list = (ArrayList<MemberDTO>) Stream.of(list, list2)
					.flatMap(x -> x.stream()).collect(Collectors.toList());*/
			
			// 방법3
			list = (ArrayList<MemberDTO>) Stream.concat(list.stream(), list2.stream())
					.collect(Collectors.toList());
			
			// 방법3_2
			/*list = (ArrayList<MemberDTO>) Stream.concat(list.stream(), Arrays.asList(new MemberDTO(UUID.randomUUID(), str)).stream())
					.collect(Collectors.toList());*/
			
			System.out.println("?��?�� ?��록이 ?��료되?��?��?��?��.");
		}
		
		// key ?��?�� ?���? 갱신
		else if(N == 4) {
			System.out.println("갱신?�� ?��?�� ID 값을 ?��?��?��주세?��.");
			String str = br.readLine();
			
			if(list.size() == 0) {
				System.out.println("?��록된 ?��?�� ?��보�? ?��?��?��?��.");
			}
			else {
				try {
					// �? 조회
					list.stream()
					.filter(m -> m.getKey().equals(UUID.fromString(str)))
					.findAny().get().getName();
					
					System.out.println("�?경할 ?��?��명을 ?��?��?��주세?��.");
					String str2 = br.readLine();
						
					// �? 갱신 
					
					// 방법1
					/*list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
					.findAny().get().setName(str2);*/
					
					// 방법2
					list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
					.forEach(m -> m.setName(str2));
						
					System.out.println(str2 + "(?��)�? ?��?��명이 �?경되?��?��?��?��.");		
					
				} catch(IllegalArgumentException e) {
					System.out.println("?��?��?���? ?��?? ID �? ?��?��?��.");
				} catch(NoSuchElementException e) {
					System.out.println("조회?�� ?��보�? ?��?��?��?��.");
				}
			}
		}

		// key ?��?�� ?���? ?��?��
		else if(N == 5) {
			System.out.println("?��?��?�� ?��?�� ID 값을 ?��?��?��주세?��.");
			String str = br.readLine();		
			
			try {
				String member = list.stream()
						.filter(m -> m.getKey().equals(UUID.fromString(str)))
						.findAny().get().getName();
				
				// �? ?���?
				/*list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
				.collect(Collectors.toList()).forEach(a -> list.remove(a));*/
				
				// 개선 : java8 ?��?�� collection?�� 추�??�� removeIf ?��?��
				list.removeIf(m -> m.getKey().equals(UUID.fromString(str)));
				
				System.out.println(member + "?��?�� ?��?�� ?��보�? ?��?��?��?��?��?��?��.");		
			} catch(IllegalArgumentException e) {
				System.out.println("?��?��?���? ?��?? ID �? ?��?��?��.");
			} catch(NoSuchElementException e) {
				System.out.println("조회?�� ?��보�? ?��?��?��?��.");
			}
	
		}
		
		String temp = br.readLine();
		if(!temp.isEmpty()) {
			try {
				N = Integer.parseInt(temp);
				service(N, list);
			} catch(NumberFormatException e) {
				System.out.println("?��?��?���? ?��?? ?��?��?��?��?��.");
				temp = br.readLine();
				service(N, list);
			}
			
		}
		
	}

}
