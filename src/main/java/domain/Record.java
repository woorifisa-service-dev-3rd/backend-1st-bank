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
	private int targetAccountId; // 거래 대상 계좌 ID
	private int accountId;
	private String memo;

	@Builder
	public Record(int id, String type, Date date, int money, int targetAccountId, int accountId, String memo) {
		this.id = id;
		this.type = type;
		this.date = date;
		this.money = money;
		this.targetAccountId = targetAccountId;
		this.accountId = accountId;
		this.memo = memo;
	}
}
