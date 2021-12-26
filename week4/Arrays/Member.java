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
				new MemberDTO(UUID.randomUUID(), "?™ê¸¸ë™")
				, new MemberDTO(UUID.randomUUID(), "ê°•ê°ì°?")
				, new MemberDTO(UUID.randomUUID(), "?œ ê´??ˆœ")
				, new MemberDTO(UUID.randomUUID(), "?´?ˆœ?‹ ")
				, new MemberDTO(UUID.randomUUID(), "?¥?˜?‹¤")
		);*/
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO(UUID.randomUUID(), "?™ê¸¸ë™"));
		list.add(new MemberDTO(UUID.randomUUID(), "ê°•ê°ì°?"));
		list.add(new MemberDTO(UUID.randomUUID(), "?œ ê´??ˆœ"));
		list.add(new MemberDTO(UUID.randomUUID(), "?´?ˆœ?‹ "));
		list.add(new MemberDTO(UUID.randomUUID(), "?¥?˜?‹¤"));
					
		/*List<ArrayList<MemberDTO>> stream = Arrays.asList(list);
		stream.stream().forEach(i -> i.forEach(
								j -> System.out.println("[key] : " + j.getKey() + " [name] : " + j.getName())));
		System.out.println();*/
	
		System.out.println("1. ? „ì²? ì¡°íšŒ | 2. ?šŒ?› ì¡°íšŒ | 3. ?šŒ?› ì¶”ê? | 4. ?šŒ?› ê°±ì‹  | 5. ?šŒ?› ?‚­? œ");
		int N = input_check(br.readLine());
		
		// ë¹„ì¦ˆ?‹ˆ?Š¤ ë¡œì§
		service(N, list);

		System.out.println("?„œë¹„ìŠ¤ê°? ì¢…ë£Œ?˜?—ˆ?Šµ?‹ˆ?‹¤.");
	}

	// ?…ì¶œë ¥ ê°? ê²?ì¦?
	private static int input_check(String str) {
		int N = 0;
		
		try {
			N = Integer.parseInt(str);

		} catch(NumberFormatException e) {
			System.out.println("?œ ?š¨?•˜ì§? ?•Š?? ?…? ¥?…?‹ˆ?‹¤.");
		}
		return N;
	}


	// ë¹„ì¦ˆ?‹ˆ?Š¤ ë¡œì§ ê´?? ¨ ë©”ì†Œ?“œ
	private static void service(int N, ArrayList<MemberDTO> list) throws IOException {		
		// ? „ì²? ?šŒ?› ? •ë³? ì¡°íšŒ
		if(N == 1) {
			if(list.size() == 0) {
				System.out.println("?“±ë¡ëœ ?šŒ?› ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
			}
			else {				
				list.stream().forEach(a -> System.out.println("[key] : " + a.getKey() + " [name] : " + a.getName()));
			}	
		}
		
		// keyë¡? ?šŒ?› ? •ë³? ì¡°íšŒ
		else if(N == 2) {
			System.out.println("ì¡°íšŒ?•  ?šŒ?› ID ê°’ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
			String str = br.readLine();
			
			if(list.size() == 0) {
				System.out.println("?“±ë¡ëœ ?šŒ?› ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
			}
			else {
				try {
					String member = list.stream()
							.filter(m -> m.getKey().equals(UUID.fromString(str)))
							.findAny().get().getName();
					System.out.println("?šŒ?›ëª? : " + member);		
				} catch(IllegalArgumentException e) {
					System.out.println("?œ ?š¨?•˜ì§? ?•Š?? ID ê°? ?…?‹ˆ?‹¤.");
				} catch(NoSuchElementException e) {
					System.out.println("ì¡°íšŒ?œ ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
				}
			}		
		}

		// ?šŒ?› ? •ë³? ì¶”ê?
		else if(N == 3) {
			System.out.println("?ƒˆë¡? ?“±ë¡í•  ?šŒ?›ëª…ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
			String str = br.readLine();
			
			// ë°©ë²•1
			// list.add(new MemberDTO(UUID.randomUUID(), str));
		
			ArrayList<MemberDTO> list2 = new ArrayList<>(Arrays.asList(new MemberDTO(UUID.randomUUID(), str)));			
			
			// ë°©ë²•2
			/*list = (ArrayList<MemberDTO>) Stream.of(list, list2)
					.flatMap(x -> x.stream()).collect(Collectors.toList());*/
			
			// ë°©ë²•3
			list = (ArrayList<MemberDTO>) Stream.concat(list.stream(), list2.stream())
					.collect(Collectors.toList());
			
			// ë°©ë²•3_2
			/*list = (ArrayList<MemberDTO>) Stream.concat(list.stream(), Arrays.asList(new MemberDTO(UUID.randomUUID(), str)).stream())
					.collect(Collectors.toList());*/
			
			System.out.println("?šŒ?› ?“±ë¡ì´ ?™„ë£Œë˜?—ˆ?Šµ?‹ˆ?‹¤.");
		}
		
		// key ?šŒ?› ? •ë³? ê°±ì‹ 
		else if(N == 4) {
			System.out.println("ê°±ì‹ ?•  ?šŒ?› ID ê°’ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
			String str = br.readLine();
			
			if(list.size() == 0) {
				System.out.println("?“±ë¡ëœ ?šŒ?› ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
			}
			else {
				try {
					// ê°? ì¡°íšŒ
					list.stream()
					.filter(m -> m.getKey().equals(UUID.fromString(str)))
					.findAny().get().getName();
					
					System.out.println("ë³?ê²½í•  ?šŒ?›ëª…ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
					String str2 = br.readLine();
						
					// ê°? ê°±ì‹  
					
					// ë°©ë²•1
					/*list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
					.findAny().get().setName(str2);*/
					
					// ë°©ë²•2
					list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
					.forEach(m -> m.setName(str2));
						
					System.out.println(str2 + "(?œ¼)ë¡? ?šŒ?›ëª…ì´ ë³?ê²½ë˜?—ˆ?Šµ?‹ˆ?‹¤.");		
					
				} catch(IllegalArgumentException e) {
					System.out.println("?œ ?š¨?•˜ì§? ?•Š?? ID ê°? ?…?‹ˆ?‹¤.");
				} catch(NoSuchElementException e) {
					System.out.println("ì¡°íšŒ?œ ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
				}
			}
		}

		// key ?šŒ?› ? •ë³? ?‚­? œ
		else if(N == 5) {
			System.out.println("?‚­? œ?•  ?šŒ?› ID ê°’ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
			String str = br.readLine();		
			
			try {
				String member = list.stream()
						.filter(m -> m.getKey().equals(UUID.fromString(str)))
						.findAny().get().getName();
				
				// ê°? ? œê±?
				/*list.stream().filter(m -> m.getKey().equals(UUID.fromString(str)))
				.collect(Collectors.toList()).forEach(a -> list.remove(a));*/
				
				// ê°œì„  : java8 ?´?›„ collection?— ì¶”ê??œ removeIf ?•¨?ˆ˜
				list.removeIf(m -> m.getKey().equals(UUID.fromString(str)));
				
				System.out.println(member + "?‹˜?˜ ?šŒ?› ? •ë³´ê? ?‚­? œ?˜?—ˆ?Šµ?‹ˆ?‹¤.");		
			} catch(IllegalArgumentException e) {
				System.out.println("?œ ?š¨?•˜ì§? ?•Š?? ID ê°? ?…?‹ˆ?‹¤.");
			} catch(NoSuchElementException e) {
				System.out.println("ì¡°íšŒ?œ ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
			}
	
		}
		
		String temp = br.readLine();
		if(!temp.isEmpty()) {
			try {
				N = Integer.parseInt(temp);
				service(N, list);
			} catch(NumberFormatException e) {
				System.out.println("?œ ?š¨?•˜ì§? ?•Š?? ?…? ¥?…?‹ˆ?‹¤.");
				temp = br.readLine();
				service(N, list);
			}
			
		}
		
	}

}
