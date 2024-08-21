package domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Account {
	
	private int id;
	private String number;
	private String type;
	private int member_id;
	private int bank_id;
	private int total_money;
	
	@Builder
	public Account(int id, String number,String type ,int member_id, int bank_id, int total_money) {
		super();
		this.id = id;
		this.number = number;
		this.member_id = member_id;
		this.bank_id = bank_id;
		this.total_money = total_money;
	}

	public Account(int id, String number, String type, int total_money) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.total_money = total_money;
	}

	
}
