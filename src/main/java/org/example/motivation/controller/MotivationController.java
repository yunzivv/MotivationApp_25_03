package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.Scanner;

public class MotivationController {

    private Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    private ArrayList<Motivation> all = new ArrayList<>();
    int lastid = 1;


    public void add() {
        System.out.println("====== motivation 추가 =======");
        System.out.print("source : ");
        String source = sc.nextLine().trim();

        System.out.print("motivation : ");
        String motivation = sc.nextLine().trim();

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


    public void modify(String cmd) {

        int modifyNo;

        if(cmd.length() > 7) {
            modifyNo = Integer.parseInt(cmd.split(" ")[1]);
        } else {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            modifyNo = sc.nextInt();
            sc.nextLine();
        }

        for(Motivation motivation : all) {

            if(motivation.getNo() == modifyNo) {
                System.out.printf("==== %d번 motivation 수정 =====\n", modifyNo);
                System.out.print("New source : ");
                String newSource = sc.nextLine().trim();
                motivation.setSource(newSource);

                System.out.print("New motivation : ");
                String newMotivation = sc.nextLine().trim();
                motivation.setMotivation(newMotivation);

                System.out.printf("%d번 motivation이 수정되었습니다.\n", modifyNo);
                System.out.println("------------------------------");

                return;
            }
        }
        System.out.println("존재하지 않는 motivation입니다.");
        System.out.println("------------------------------");
    }

    public void detail(String cmd) {

        int detailNo;

        if(cmd.length() > 7) {
            detailNo = Integer.parseInt(cmd.split(" ")[1]);
        } else {
            System.out.print("수정할 motivation 번호를 입력하세요 : ");
            detailNo = sc.nextInt();
            sc.nextLine();
        }

        for(Motivation motivation : all) {

            if(motivation.getNo() == detailNo) {
                System.out.printf("==== %d번 motivation 상세 =====\n", detailNo);
                System.out.printf("No. : %d\n", motivation.getNo());
                System.out.printf("Source : %s\n", motivation.getSource());
                System.out.printf("Motivation : %s\n", motivation.getMotivation());
                return;
            }
        }
        System.out.println("존재하지 않는 motivation입니다.");
        System.out.println("------------------------------");
    }


    public void delete(String cmd) {
        int deleteNo;

        // delete 명령어 번호 없이 입력하는 경우 대비
        if(cmd.length() > 7) {
            // 입력 받은 del n 명령어를 공백 기준으로 자른 후(split), 인덱스 1번에 저장된(번호) 문자열을 저장
            deleteNo = Integer.parseInt(cmd.split(" ")[1]);
        } else {
            System.out.print("삭제할 motivation 번호를 입력하세요 : ");
            deleteNo = sc.nextInt();
            // 버퍼 비우기
            sc.nextLine();
        }

        // all 객체 배열을 하나씩 검사해 입력받은 숫자와 같은 번호를 갖고 있는 지 검사
        for(Motivation motivation : all) {

            // 같은 번호의 객체를 찾았다면 삭제
            if(motivation.getNo() == deleteNo) {
                System.out.printf("==== %d번 motivation 삭제 =====\n", deleteNo);
                all.remove(motivation);
                System.out.printf("%d번 motivation이 삭제 되었습니다.\n", deleteNo);
                System.out.println("------------------------------");
                return;
            }
        }
        // 같은 번호를 찾지 못했다면 실행
        System.out.println("존재하지 않는 motivation입니다.");
        System.out.println("------------------------------");
    }

    public void deleteID(String cmd) {

        int deleteNo = Integer.parseInt(cmd.split("\\?id=")[1]);

        for(Motivation motivation : all) {

            if(motivation.getNo() == deleteNo) {
                System.out.printf("==== %d번 motivation 삭제 =====\n", deleteNo);
                all.remove(motivation);
                System.out.printf("%d번 motivation이 삭제 되었습니다.\n", deleteNo);
                System.out.println("------------------------------");
                return;
            }
        }

        System.out.println("존재하지 않는 motivation입니다.");
        System.out.println("------------------------------");
    }

}
