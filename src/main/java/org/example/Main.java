package org.example;


// motivation 실행용
public class Main {
    public static void main(String[] args) {
        Container.init();

        // 여기부터 구현할 것
        // 회원가입 또는 로그인
        System.out.print("회원가입 / 로그인 : ");
        String membership = Container.getScanner().nextLine();
        boolean login = false;

        Member member = new Member();

        if (membership.equals("회원가입")) {

            member.SignUp();
            login = member.Login();
        }

        if (membership.equals("로그인")) {

            login = member.Login();
        }

        // 로그인에 성공했을 경우만 앱을 실행할 수 있게
        if (login) {
            new App().run();
        }
        // 여기까지 미완성

        new App().run();

        Container.close();
    }
}

class Member {
    String name;
    String ID;
    String PW;

    Member() {}

    public void SignUp() {
        System.out.println("========== Sign Up ===========");
        System.out.print("이름 : ");
        String name = Container.getScanner().nextLine();
        System.out.print("아이디 : ");
        String ID = Container.getScanner().nextLine();
        System.out.print("비밀번호 : ");
        String PW = Container.getScanner().nextLine();
        System.out.println("");

//        // 구현할 것
//        for (회원객체 배열 순회) {
//            if ( 회원의 ID와 중복된다면 ) {
//              System.out.println("중복된 아이디입니다.");
//              System.out.print("새로운 아이디 : ");
//              ID = sc.nextLine();
//            }
//        }

        this.name = name;
        this.ID = ID;
        this.PW = PW;
    }

    public boolean Login() {
        System.out.println("========== Log in ============");

        System.out.print("아이디 : ");
        String ID = Container.getScanner().nextLine();
        System.out.print("비밀번호 : ");
        String PW = Container.getScanner().nextLine();

        if (ID.equals(this.ID) && PW.equals(this.PW)) {
            System.out.println("------------------------------");
            return true;
        }

        System.out.println("잘못된 아이디/비밀번호입니다.");
        return false;
    }


}