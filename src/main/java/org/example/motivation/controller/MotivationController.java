package org.example.motivation.controller;

import org.example.Container;
import org.example.motivation.entity.Motivation;
import java.util.ArrayList;

public class MotivationController {

    private ArrayList<Motivation> all = new ArrayList<>();
    int lastid = 1;


    public void add() {
        System.out.println("====== motivation 추가 =======");
        System.out.print("source : ");
        String source = Container.getScanner().nextLine().trim();

        System.out.print("motivation : ");
        String motivation = Container.getScanner().nextLine().trim();

        Motivation a = new Motivation(lastid, source, motivation);
        all.add(a);

        System.out.printf("%d번 motivation이 등록되었습니다.\n", lastid);
        System.out.println("------------------------------");

        lastid++;
    }


    public void list() {
        System.out.println("====== motivation 목록 =======");
        System.out.println(" No.  |  Source  |  Motivation");

        if (all.size() == 0) {
            System.out.println("---------- nothing -----------");
            return;
        }

        System.out.println("------------------------------");

        for (int i = all.size() - 1; i >= 0; i--) {
            Motivation motivation = all.get(i);

            boolean overSource = (motivation.getSource().length() > 6);
            boolean overMotivation = (motivation.getMotivation().length() > 10);

            if (overSource && overMotivation) {
                System.out.printf("  %d.  |  %s  |  %s \n", motivation.getNo(),
                        motivation.getSource().substring(0, 4) + "..", motivation.getMotivation().substring(0, 8) + "..");

            } else if (overSource) {
                System.out.printf("  %d.  |  %s  |  %-10s \n", motivation.getNo(),
                        motivation.getSource().substring(0, 4) + "..", motivation.getMotivation());

            } else if (overMotivation) {
                System.out.printf("  %d.  |  %-6s  |  %s \n", motivation.getNo(),
                        motivation.getSource(), motivation.getMotivation().substring(0, 8) + "..");

            } else {
                System.out.printf("  %d.  |  %-6s  |  %-10s \n", motivation.getNo(),
                        motivation.getSource(), motivation.getMotivation());
            }
        }
        System.out.println("------------------------------");
    }


    public void edit(String cmd) {

        int editNo;

        if(cmd.length() > 5) {
            editNo = Integer.parseInt(cmd.split(" ")[1]);
        } else {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            editNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        Motivation motivation = findNo(editNo);

        if (motivation == null) {
            System.out.println("존재하지 않는 motivation입니다.");
            System.out.println("------------------------------");
        }

        System.out.printf("==== %d번 motivation 수정 =====\n", editNo);

        System.out.printf("Now source : %s\n", motivation.getSource());
        System.out.print("New source : ");
        String newSource = Container.getScanner().nextLine().trim();
        motivation.setSource(newSource);

        System.out.printf("Now motivation : %s\n", motivation.getMotivation());
        System.out.print("New motivation : ");
        String newMotivation = Container.getScanner().nextLine().trim();
        motivation.setMotivation(newMotivation);

        System.out.printf("%d번 motivation이 수정되었습니다.\n", editNo);
        System.out.println("------------------------------");

    }


    public void detail(String cmd) {

        int detailNo;

        if(cmd.length() > 7) {
            detailNo = Integer.parseInt(cmd.split(" ")[1]);
        } else {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            detailNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        Motivation motivation = findNo(detailNo);

        if(motivation == null) {
            System.out.println("존재하지 않는 motivation입니다.");
            System.out.println("------------------------------");
            return;
        }

        System.out.printf("==== %d번 motivation 상세 =====\n", detailNo);
        System.out.printf("No. : %d\n", motivation.getNo());
        System.out.printf("Source : %s\n", motivation.getSource());
        System.out.printf("Motivation : %s\n", motivation.getMotivation());

    }


    public void delete(String cmd) {

        int deleteNo;

        if(cmd.length() > 7) {
            deleteNo = Integer.parseInt(cmd.split(" ")[1]);
        } else {
            System.out.print("삭제할 motivation 번호를 입력하세요 : ");
            deleteNo = Container.getScanner().nextInt();
            Container.getScanner().nextLine();
        }

        Motivation motivation = findNo(deleteNo);

        if(motivation == null) {
            System.out.println("존재하지 않는 motivation입니다.");
            System.out.println("------------------------------");
            return;
        }

        System.out.printf("==== %d번 motivation 삭제 =====\n", deleteNo);
        all.remove(motivation);
        System.out.printf("%d번 motivation이 삭제 되었습니다.\n", deleteNo);
        System.out.println("------------------------------");
    }

//  v2. delete
//    public void deleteID(String cmd) {
//
//        int deleteNo = Integer.parseInt(cmd.split("\\?id=")[1]);
//
//        for(Motivation motivation : all) {
//
//            if(motivation.getNo() == deleteNo) {
//                System.out.printf("==== %d번 motivation 삭제 =====\n", deleteNo);
//                all.remove(motivation);
//                System.out.printf("%d번 motivation이 삭제 되었습니다.\n", deleteNo);
//                System.out.println("------------------------------");
//                return;
//            }
//        }
//
//        System.out.println("존재하지 않는 motivation입니다.");
//        System.out.println("------------------------------");
//    }

    // 번호를 매개변수로 하여 일치하는 motivation 반환하는 메서드
    private Motivation findNo(int no) {

        for(Motivation motivation : all) {
            if(motivation.getNo() == no) {
                return motivation;
            }
        }
        return null;
    }

}
