package controller;

import data.MemberDAO;
import data.AccountDAO;
import domain.Account;

import domain.Member;
import view.InputView;
import view.dto.LoginRequest;

import java.sql.SQLException;
import java.util.List;

import static java.util.Objects.isNull;
import static view.printView.printFailToLogin;
import static view.printView.printAccount;

public class BankSimulator {

    MemberDAO memberDAO = new MemberDAO();
    AccountDAO accountDAO = new AccountDAO();

    public void run() throws SQLException {
        Member member = login();
        List<Account> accountList = accountDAO.findAllByMemberId(member.getId());
        printAccount(accountList);
        // int input = 1;
        // accountList.get(input-1);


    }

    private Member login() throws SQLException {
        while (true) {
            LoginRequest loginRequest = InputView.inputLogin();
            Member member = memberDAO.findByLoginIdAndPassword(loginRequest.getLoginId(), loginRequest.getPassword());
            if (!isNull(member)) {
                return member;
            }
            printFailToLogin();
        }
        
    }
    
}
