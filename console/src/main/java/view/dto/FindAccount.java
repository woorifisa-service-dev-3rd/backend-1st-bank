package view.dto;

import lombok.Getter;

@Getter
public class FindAccount {
	private int findNumber;

	public FindAccount(int findNumber) {
		this.findNumber = findNumber;
	}
}
