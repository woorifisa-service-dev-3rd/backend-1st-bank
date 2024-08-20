package controller;

import data.MemberDAO;
import domain.Member;
import view.InputView;
import view.dto.LoginRequest;

import java.sql.SQLException;

import static java.util.Objects.isNull;
import static view.printView.printFailToLogin;

public class BankSimulator {

    MemberDAO memberDAO = new MemberDAO();

    public void run() throws SQLException {
        Member member = login();


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
