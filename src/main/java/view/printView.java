package view;

import java.util.Iterator;
import java.util.List;

import domain.Account;

public class printView {

    public static void printFailToLogin() {
        System.out.println("로그인에 실패했습니다. 다시 로그인해주세요.");
    }
    
    public static void printAccount(List<Account> accounts) {
    	for (int i = 0; i < accounts.size(); i++) {
    		System.out.println((i+1) + ". 계좌번호: " + accounts.get(i).getNumber());
    		System.out.println("잔액: " + accounts.get(i).getTotal_money());
    		System.out.println("-----------------------------");
    	}
    }
    
    public static void printNotExistsNumber() {
    	System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
    }
    
    public static void printNotExistsBankAccount() {
    	System.out.println("은행에 계좌가 존재하지 않습니다. 다시 선택해주세요.");
    }
    
    public static void printNotExistsAccount() {
    	System.out.println("존재하지 않는 계좌번호입니다.");
    }
    
    public static void printInsufficientBalance() {
    	System.out.println("############ 이체 실패 ############");
    	System.out.println("잔액 부족으로 이체에 실패했습니다.");
    	System.out.println("다른 계좌를 선택하거나 금액을 다시 입력해주세요.");
    }
    
    public static void printIncorrectInput() {
    	System.out.println("입력값이 잘못되었습니다.");
    }
    
    public static void printTransferResult(int totalMoney) {
    	System.out.println("############ 이체 성공 ############");
    	System.out.println("이체가 성공적으로 완료되었습니다.");
    	System.out.println("잔액: " + totalMoney + "원");
    }
}
