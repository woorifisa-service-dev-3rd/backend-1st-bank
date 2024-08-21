package domain;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Record {
	private int id;
	private String type;
	private Date date;
	private int money;
	private int target_account_id;
	private int account_id;
	private String memo;
	
	@Builder
	public Record(int id, String type, Date date, int money, int target_account_id, int account_id, String memo) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.money = money;
		this.target_account_id = target_account_id;
		this.account_id = account_id;
		this.memo = memo;
	}
}
