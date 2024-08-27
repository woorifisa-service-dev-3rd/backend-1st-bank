package view.dto;

import lombok.Getter;

@Getter
public class TransferRequest {
	private int money;

	public TransferRequest(int money) {
		this.money = money;
	}
}
