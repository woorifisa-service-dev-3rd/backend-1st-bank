package domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Bank {
	private int id;
	private String name;

	@Builder
	public Bank(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}