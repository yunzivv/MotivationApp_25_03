package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private ArrayList<Motivation> all = new ArrayList<>();

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        System.out.println("====== motivation 실행 =======");
        System.out.println("help : 명령어 도움말");
        int lastid = 1;

        while (true) {
            System.out.print("\ncmd : ");
            String cmd = sc.nextLine().trim();


            if (cmd.equals("exit")) {
                System.out.println("====== motivation 종료 =======");
                break;

            } else if (cmd.equals("help")) {
                System.out.println("list : motivation 목록");
                System.out.println("add : motivation 추가");
                System.out.println("del : motivation 삭제");
                System.out.println("update : motivation 수정");
                System.out.println("exit : motivation 종료");
            }else if (cmd.equals("add")) {

                System.out.println("====== motivation 추가 =======");
                System.out.print("source : ");
                String source = sc.nextLine().trim();
                if (source.length() > 6) {
                    source = source.substring(0, 2) + "...";
                }

                System.out.print("motivation : ");
                String motivation = sc.nextLine().trim();

                Motivation a = new Motivation(lastid, source, motivation);
                all.add(a);

                System.out.printf("%d번 motivation이 등록되었습니다.\n", lastid);

                lastid++;

            } else if (cmd.equals("list")) {
                System.out.println("====== motivation 목록 =======");
                System.out.println(" No.  |  Source  |  Motivation");
                if (all.size() == 0) {
                    System.out.println("========== nothing ===========");
                    continue;
                }
                System.out.println("------------------------------");

                ArrayList<Motivation> reverseAll = new ArrayList<>();

                for (int i = all.size() - 1; i >= 0; i--) {
                    reverseAll.add(all.get(i));
                }

                for (Motivation r : reverseAll) {
                    if (r.source.length() > 6) {
                        System.out.printf("  %d.  |  %-7s  |  %-10s \n", r.id, r.source.substring(0, 3) + "...", r.motivation);
                    } else {
                        System.out.printf("  %d.  |  %-6s  |  %-10s \n", r.id, r.source, r.motivation);
                    }
                }
                System.out.println("------------------------------");

            } else if (cmd.equals("update")) {
                System.out.println("====== motivation 수정 =======");

                System.out.print("update article No. : ");
                int no = Integer.parseInt(sc.nextLine().trim());

                System.out.print("New source : ");
                String source = sc.nextLine().trim();

                System.out.print("New motivation : ");
                String motivation = sc.nextLine().trim();

                all.set(no - 1, new Motivation(no, source, motivation));

            } else if (cmd.equals("del")) {
                System.out.println("====== motivation 삭제 =======");
                System.out.print("delete article No. : ");
                int no = Integer.parseInt(sc.nextLine().trim());
                all.remove(no - 1);
                System.out.printf("%d번 motivation이 삭제 되었습니다.\n", no);

            } else{
                System.out.println("잘못된 명령어입니다.");
                System.out.println("help : 명령어 도움말");
                continue;
            }
        }
    }
}