package view;

import java.util.List;

import domain.Account;

public class printView {

    public static void printFailToLogin() {
        System.out.println("로그인에 실패했습니다. 다시 로그인해주세요.");
    }
    
    public static void printAccount(List<Account> accounts)	{
    	//여기다가 로그인이 성공했을 시에 본인 계좌를 쫙보여주는 코드를 여기다 작성하면 될거 같아요.
    	// select number,  total_money from Account where member_id = "입력받은 아이디에 해당하는 member_id"
    	System.out.println("==========================================================");
    	System.out.println();
        for(int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.printf("| %-12s : %-27s |\n", "계좌 번호", account.getNumber());
            System.out.printf("| %-12s : %-27d |\n", "잔액", account.getTotal_money());
            System.out.printf("| %-12s : %-27s |\n", "계좌 종류", account.getType());
            if (i < accounts.size() - 1) {
                System.out.println("--------------------------------------------------------------");
            }
        }
        System.out.println();
        System.out.println("==========================================================");
    }
    
    
    
    public static void printAccountDetails(List<Account> accounts, int findNumber) {
    	// 해당하는 번호의 계좌번호의 대한 입출금 내역을 싹 보여주는 코드를 여기다가 작성을 해야할 것 같아요.
    	// select number, total_money from Account where number = " 입력받은 계좌 번호와 일치하는 number"
    	
    	if (findNumber <= 0 || findNumber > accounts.size()) {
            System.out.println("잘못된 계좌 번호입니다. 다시 시도해주세요.");
            return;
    	}
            System.out.println("==========================================================");
            Account account = accounts.get(findNumber - 1);
        System.out.printf("| %-12s : %-27s |\n", "계좌 번호", account.getNumber());
        System.out.printf("| %-12s : %-27d |\n", "잔액", account.getTotal_money());
        System.out.printf("| %-12s : %-27s |\n", "계좌 종류", account.getType());
            System.out.println("==========================================================");   
    }
    
    
}
