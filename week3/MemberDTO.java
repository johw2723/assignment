package week3;

import java.util.UUID;

public class MemberDTO {
	private UUID key;
	private String name;
	
	/*public MemberDTO(UUID key, String name) {
		this.key = key;
		this.name = name;
	}*/
	
	public UUID getKey() {
		return key;
	}
	public void setKey(UUID key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
