package controller;

import data.MemberDAO;
import data.AccountDAO;
import data.RecordDAO;
import domain.Account;
import domain.Member;
import domain.Record;
import view.InputView;
import view.RecordView;
import view.dto.FindAccount;
import view.dto.LoginRequest;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static java.util.Objects.isNull;
import static view.printView.printFailToLogin;
import static view.printView.printAccount;
import static view.printView.printAccountDetails;

public class BankSimulator {

    MemberDAO memberDAO = new MemberDAO();
    AccountDAO accountDAO = new AccountDAO();
    RecordDAO recordDAO = new RecordDAO();
    RecordView recordView = new RecordView();

    public void run() throws SQLException {
        Member member = login();
        List<Account> accountList = accountDAO.findAllByMemberId(member.getId());
        printAccount(accountList);

        FindAccount findAccount = inputAccount();
        int findNumber = findAccount.getFindNumber();

        printAccountDetails(accountList, findNumber);

        // 임의의 날짜
        Date startDate = Date.valueOf("2024-05-01");
        Date endDate = Date.valueOf("2024-08-31");
        List<Record> records = recordDAO.findRecordsByAccountIdAndDateRange(findNumber, startDate, endDate);

        recordView.printRecords(records);
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

    private FindAccount inputAccount() {
        while (true) {
            FindAccount findAccount = InputView.inputAccount();
            int findNumber = findAccount.getFindNumber();

            if (findNumber > 0) {
                return findAccount;
            }
            System.out.println("잘못된 계좌 번호입니다. 다시 시도해주세요.");
        }
    }
}
