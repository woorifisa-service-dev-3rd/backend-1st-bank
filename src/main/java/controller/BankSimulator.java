package controller;

import data.AccountDAO;
import data.MemberDAO;
import data.RecordDAO;
import data.TargetAccountDAO;
import domain.Account;
import domain.Member;
import domain.Record;
import view.InputView;
import view.RecordView;
import view.dto.FindAccount;
import view.dto.LoginRequest;
import view.dto.SelectAccountRequest;
import view.dto.SelectBankRequest;
import view.dto.SelectTargetAccountRequest;
import view.dto.TransferRequest;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.Objects.isNull;
import static view.InputView.inputAccount;
import static view.printView.*;

public class BankSimulator {

    private MemberDAO memberDAO = new MemberDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private TargetAccountDAO targetAccountDAO = new TargetAccountDAO();
    private RecordDAO recordDAO = new RecordDAO();
    private RecordView recordView = new RecordView();

    public void run() throws SQLException {
        Member member = login();

        List<Account> accountList = accountDAO.findAllByMemberId(member.getId());
        printAccount(accountList);

        FindAccount findAccount = inputAccount();

        int findNumber = findAccount.getFindNumber();

        printAccountDetails(accountList, findNumber);

        LocalDate currentDate = LocalDate.now();

        // 현재 날짜에서 60일 전 날짜를 계산
        LocalDate startDateLocal = currentDate.minus(60, ChronoUnit.DAYS);

        // SQL Date 타입으로 변환
        Date startDate = Date.valueOf(startDateLocal);
        Date endDate = Date.valueOf(currentDate);

        List<Record> records = recordDAO.findRecordsByAccountIdAndDateRange(findNumber, startDate, endDate);

        recordView.printRecords(records);


        Account myAccount = selectMyAccount(member.getId());
        Account targetAccount = selectTargetAccount();
        transfer(myAccount, targetAccount, member.getId());
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

    private Account selectMyAccount(int memberId) throws SQLException {
        SelectBankRequest selectBankRequest = InputView.inputSelectBank(); // 은행선택
        List<Account> accounts = accountDAO.findByMemberIdAndBankId(memberId, selectBankRequest.getBankId()); // 계좌 목록

        while (true) {
            SelectAccountRequest selectAccountRequest = InputView.inputSelectAccount(accounts); // 내 계좌 선택
            int myAccountIndex = selectAccountRequest.getAccountIndex();
            if (myAccountIndex > 0 && myAccountIndex <= accounts.size()) {
                return accounts.get(myAccountIndex - 1);
            }
            printNotExistsNumber();
        }
    }

    private Account selectTargetAccount() throws SQLException {
        while (true) {
            SelectTargetAccountRequest selectTargetAccountRequest = InputView.inputSelectTargetAccount(); // 상대방 계좌 선택
            Account targetAccount = targetAccountDAO.findByTargetNumber(selectTargetAccountRequest.getTargetNumber());

            if (!isNull(targetAccount)) {
                return targetAccount;
            }
            printNotExistsAccount();
        }
    }

    private void transfer(Account myAccount, Account targetAccount, int memberId) throws SQLException {
        TransferRequest transferRequest = InputView.inputTransfer();
        int money = transferRequest.getMoney();
        if (myAccount.getTotal_money() >= money) {
            accountDAO.updateMyAccountSetMoney(myAccount.getId(), myAccount.getTotal_money(), money);
            accountDAO.updateTargetAccountSetMoney(targetAccount.getId(), targetAccount.getTotal_money(), money);

            Date date = Date.valueOf(LocalDate.now());
            Record myRecord = new Record(1, "출금", date, money, targetAccount.getId(), myAccount.getId(), " ");
            Record targetRecord = new Record(1, "입금", date, money, myAccount.getId(), targetAccount.getId(), " ");
            recordDAO.saveMyRecord(myRecord);
            recordDAO.saveTargetRecord(targetRecord);
            printTransferResult(myAccount.getTotal_money() - money);
        } else {
            printInsufficientBalance();
            while (true) {
                int input = InputView.inputChangeAccountOrChangeMoney();
                if (input == 1) {
                    selectMyAccount(memberId);
                    transfer(myAccount, targetAccount, memberId);
                } else if (input == 2) {
                    transfer(myAccount, targetAccount, memberId);
                } else {
                    printIncorrectInput();
                }
            }
        }
    }
}
