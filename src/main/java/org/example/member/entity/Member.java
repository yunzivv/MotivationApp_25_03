package org.example.member.entity;

public class Member {
    public int no;
    public String name;
    public String loginId;
    public String loginPw;

    public Member(int no, String name, String loginId, String loginPw) {
        this.no = no;
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }
}
