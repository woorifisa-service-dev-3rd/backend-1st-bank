package view;

import view.dto.LoginRequest;
import view.dto.SelectAccountRequest;
import view.dto.SelectBankRequest;
import view.dto.SelectTargetAccountRequest;
import view.dto.TransferRequest;

import java.util.List;
import java.util.Scanner;

import domain.Account;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static LoginRequest inputLogin() {
        System.out.println("############ 로그인 ############");
        System.out.println("아이디를 입력해주세요.");
        String loginId = scanner.nextLine();
        System.out.println("비밀번호를 입력해주세요.");
        String password = scanner.nextLine();
        return new LoginRequest(loginId, password);
    }
    
    public static SelectBankRequest inputSelectBank() {
    	System.out.println("############ 이체기능 ############");
    	System.out.println("은행을 선택해주세요");
    	System.out.println("1. 하나은행\n2.신한은행\n3.우리은행\n4.국민은행\n5.농협");
    	int bankId = Integer.parseInt(scanner.nextLine());
    	return new SelectBankRequest(bankId);
    }
    
    public static SelectAccountRequest inputSelectAccount(List<Account> accounts) {
    	System.out.println("############ 송금할 계좌 선택 ############");
    	System.out.println("송금할 계좌의 번호를 선택해주세요.");
    	printView.printAccount(accounts);
    	int accountIndex = Integer.parseInt(scanner.nextLine());
    	return new SelectAccountRequest(accountIndex);
    }
    
    public static SelectTargetAccountRequest inputSelectTargetAccount() {
    	System.out.println("송금받을 계좌번호를 입력해주세요.");
    	String targetNumber = scanner.nextLine();
    	return new SelectTargetAccountRequest(targetNumber);
    }
    
    public static TransferRequest inputTransfer() {
    	System.out.println("############ 이체할 금액 입력 ############");
    	System.out.println("이체할 금액을 입력해주세요.");
    	int money = Integer.parseInt(scanner.nextLine());
    	return new TransferRequest(money);
    }
    
    public static int inputChangeAccountOrChangeMoney() {
    	System.out.println("1. 다른 계좌 선택 2. 이체 금액 변경");
    	return Integer.parseInt(scanner.nextLine());
    	
    }
}
