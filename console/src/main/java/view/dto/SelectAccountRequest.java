package view.dto;

import lombok.Getter;

@Getter
public class SelectAccountRequest {
	private int accountIndex;
	
	public SelectAccountRequest(int accountIndex) {
		this.accountIndex = accountIndex;
	}
}
