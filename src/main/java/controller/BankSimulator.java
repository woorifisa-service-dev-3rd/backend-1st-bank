package controller;

import data.AccountDAO;
import data.MemberDAO;
import data.RecordDAO;
import data.TargetAccountDAO;
import domain.Account;
import domain.Member;
import domain.Record;
import view.dto.LoginRequest;
import view.dto.SelectAccountRequest;
import view.dto.SelectBankRequest;
import view.dto.SelectTargetAccountRequest;
import view.dto.TransferRequest;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import static java.util.Objects.isNull;
import static view.printView.*;
import static view.InputView.*;

public class BankSimulator {

	MemberDAO memberDAO = new MemberDAO();
	AccountDAO accountDAO = new AccountDAO();
	TargetAccountDAO targetAccountDAO = new TargetAccountDAO();
	RecordDAO recordDAO = new RecordDAO();

	public void run() throws SQLException {
		Member member = login();
		Account myAccount = selectMyAccount(member.getId());
		Account targetAccount = selectTargetAccount();
		transfer(myAccount, targetAccount, member.getId());
	}

	private Member login() throws SQLException {
		while (true) {
			LoginRequest loginRequest = inputLogin();
			Member member = memberDAO.findByLoginIdAndPassword(loginRequest.getLoginId(), loginRequest.getPassword());
			if (!isNull(member)) {
				return member;
			}
			printFailToLogin();
		}
	}

	private Account selectMyAccount(int memberId) throws SQLException {
		SelectBankRequest selectBankRequest = inputSelectBank(); // 은행선택
		List<Account> accounts = accountDAO.findByMemberIdAndBankId(memberId, selectBankRequest.getBankId()); // 계좌 목록			

		while (true) {
			SelectAccountRequest selectAccountRequest = inputSelectAccount(accounts); // 내 계좌 선택
			int myAccountIndex = selectAccountRequest.getAccountIndex();
			if (myAccountIndex > 0 && myAccountIndex <= accounts.size()) {
				return accounts.get(myAccountIndex - 1);
			}
			printNotExistsNumber();
		}
	}

	private Account selectTargetAccount() throws SQLException {
		while (true) {
			SelectTargetAccountRequest selectTargetAccountRequest = inputSelectTargetAccount(); // 상대방 계좌 선택
			Account targetAccount = targetAccountDAO.findByTargetNumber(selectTargetAccountRequest.getTargetNumber());

			if (!isNull(targetAccount)) {
				return targetAccount;
			}
			printNotExistsAccount();
		}
	}

	private void transfer(Account myAccount, Account targetAccount, int memberId) throws SQLException {
		TransferRequest transferRequest = inputTransfer();
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
				int input = inputChangeAccountOrChangeMoney();
				if (input == 1) {
					selectMyAccount(memberId);
					transfer(myAccount, targetAccount, memberId);
				}
				if (input == 2) {
					transfer(myAccount, targetAccount, memberId);
				}
				printIncorrectInput();
			}
		}

	}

}
