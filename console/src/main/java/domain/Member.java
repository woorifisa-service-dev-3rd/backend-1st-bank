package domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    private int id;
    private String name;
    private String loginId;
    private String password;

    @Builder
    public Member(int id, String loginId, String name, String password) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
