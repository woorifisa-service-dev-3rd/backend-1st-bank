package view.dto;

import lombok.Getter;

@Getter
public class SelectBankRequest {
	private int bankId;
	
	public SelectBankRequest(int bankId) {
		this.bankId = bankId;
	}
}
