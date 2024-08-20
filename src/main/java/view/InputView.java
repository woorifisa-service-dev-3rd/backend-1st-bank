package view;

import view.dto.LoginRequest;

import java.util.Scanner;

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
}
