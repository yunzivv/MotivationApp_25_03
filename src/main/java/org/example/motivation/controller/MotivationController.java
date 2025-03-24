package org.example.motivation.controller;

import org.example.Container;
import org.example.motivation.Service.MotivationService;
import org.example.motivation.entity.Motivation;
import java.util.ArrayList;

public class MotivationController {

    private MotivationService motivationService;
    private ArrayList<Motivation> motivations;

    public MotivationController() {
        motivationService = new MotivationService();
        motivations = new ArrayList<>();
    }

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


    public void list() {
        System.out.println("====== motivation 목록 =======");
        System.out.println(" No.  |  Source  |  Motivation");
        motivationService.list();
    }


    public void edit(String cmd) {

        int editNo;

        try {
            editNo = Integer.parseInt(cmd.split(" ")[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            editNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        if(motivationService.motivationIsExits(editNo)) {
            System.out.printf("==== %d번 motivation 수정 =====\n", editNo);
            String newSource;
            String newMotivation;

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

        try {
            detailNo = Integer.parseInt(cmd.split(" ")[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            detailNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

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

        try {
            deleteNo = Integer.parseInt(cmd.split(" ")[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            deleteNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

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

    // 번호를 매개변수로 하여 일치하는 motivation 반환하는 메서드
    private Motivation findNo(int no) {

        for(Motivation motivation : motivations) {
            if(motivation.getNo() == no) {
                return motivation;
            }
        }
        return null;
    }

}
