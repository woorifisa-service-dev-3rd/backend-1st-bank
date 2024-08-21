package domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Account {
	private int id;
	private String number;
	private String type;
	private int total_money;
	
	@Builder
	public Account(int id, String number, String type, int total_money) {
		this.id = id;
		this.number = number;
		this.type = type;
		this.total_money = total_money;
	}
}
