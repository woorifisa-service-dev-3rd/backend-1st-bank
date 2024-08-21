package view.dto;

import lombok.Getter;

@Getter
public class SelectTargetAccountRequest {
	private String targetNumber;
	
	public SelectTargetAccountRequest(String targetNumber) {
		this.targetNumber = targetNumber;
	}
}
