package org.example.motivation.controller;

import org.example.Container;
import org.example.motivation.Service.MotivationService;
import org.example.motivation.entity.Motivation;
import java.util.ArrayList;

public class MotivationController {

    private MotivationService motivationService;

    // App클래스에서만 한 번 인스턴스가 생성되었기 때문에 생성자 1회 실행
    // motivaitonService 인스턴스 생성하여 내부 메서드 사용
    public MotivationController() {
        motivationService = new MotivationService();
    }

    // 추가할 motivation의 source와 motivation을 입력 받아
    // motivationService 클래스의 add 메서드에 전달하고 생성한 motivation의 번호를 반환 받음
    public void add() {
        System.out.println("====== motivation 추가 =======");
        System.out.print("source : ");
        String source = Container.getScanner().nextLine().trim();

        System.out.print("motivation : ");
        String motivation = Container.getScanner().nextLine().trim();

        int newNo = motivationService.add(source, motivation);

        System.out.printf("%d번 motivation이 등록되었습니다.\n", newNo);
        System.out.println("------------------------------");
    }

    // motivationService 클래스의 list 메서드 단순 호출
    // 명령어 전달 역할만
    public void list() {
        motivationService.list();
    }

    public void edit(String cmd) {

        int editNo;

        // edit 명령어 중 번호 분리
        // index 오류 발생 시 예외처리 -> 다시 번호 입력
        try {
            editNo = Integer.parseInt(cmd.split(" ")[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            editNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        // 입력 받은 번호가 존재 하는 지 확인 후 수정
        if(motivationService.motivationIsExits(editNo)) {
            System.out.printf("==== %d번 motivation 수정 =====\n", editNo);
            String newSource;
            String newMotivation;

            // 수정할 source가 공백이 아닐 때까지 재입력
            System.out.print("Now source : ");
            System.out.println(motivationService.getMotivation(editNo).getSource());
            while(true) {
                System.out.print("New source : ");
                newSource = Container.getScanner().nextLine().trim();
                if (!newSource.isEmpty()) {
                    break;
                }
                System.out.println("수정사항이 입력되지 않았습니다.");
            }

            // 수정할 motivation이 공백이 아닐 때까지 재입력
            System.out.print("Now motivation : ");
            System.out.println(motivationService.getMotivation(editNo).getMotivation());
            while(true) {
                System.out.print("New motivation : ");
                newMotivation = Container.getScanner().nextLine().trim();
                if (!newMotivation.isEmpty()) {
                    break;
                }
                System.out.println("수정사항이 입력되지 않았습니다.");
            }

            // motivation 수정 메서드 호출
            // 명령어와 입력받은 editNo, 새로 입력받은 source와 motivation 전달
            motivationService.edit(editNo, newSource, newMotivation);

            System.out.printf("%d번 motivation이 수정되었습니다.\n", editNo);
            System.out.println("------------------------------");

        } else {
            System.out.println("존재하지 않는 motivation입니다.");
            System.out.println("------------------------------");
        }
    }


    public void detail(String cmd) {

        int detailNo;

        // detail 명령어 중 번호 분리
        // index 오류 발생 시 예외처리 -> 다시 번호 입력
        try {
            detailNo = Integer.parseInt(cmd.split(" ")[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            detailNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        // 입력받은 번호의 motivation이 있는 지 확인 후 상세보기 메서드 호출
        if(motivationService.motivationIsExits(detailNo)) {
            motivationService.detail(detailNo);
            System.out.println("------------------------------");
            return;
        } else {
            System.out.println("존재하지 않는 motivation입니다.");
            System.out.println("------------------------------");
        };
    }


    public void delete(String cmd) {

        int deleteNo;

        // detail 명령어 중 번호 분리
        // index 오류 발생 시 예외처리 -> 다시 번호 입력
        try {
            deleteNo = Integer.parseInt(cmd.split(" ")[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            deleteNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        // 입력받은 번호의 motivation이 있는 지 확인 후 삭제 메서드 호출
        if(motivationService.motivationIsExits(deleteNo)) {
            System.out.printf("==== %d번 motivation 삭제 =====\n", deleteNo);
            motivationService.delete(deleteNo);
            System.out.printf("%d번 motivation이 삭제 되었습니다.\n", deleteNo);
            System.out.println("------------------------------");

        } else {
            System.out.println("존재하지 않는 motivation입니다.");
            System.out.println("------------------------------");
        }
    }

}
