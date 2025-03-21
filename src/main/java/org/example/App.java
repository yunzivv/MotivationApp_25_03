package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private ArrayList<motivation> all = new ArrayList<>();

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        System.out.println("===== motivation 실행 =====");
        int lastid = 1;

        while (true) {
            System.out.print("\ncmd : ");
            String cmd = sc.nextLine().trim();


            if (cmd.equals("exit")) {
                System.out.println("===== motivation 종료 =====");
                break;

            } else if (cmd.equals("add")) {

                System.out.println("===== motivation 추가 =====");
                System.out.print("source : ");
                String source = sc.nextLine().trim();

                System.out.print("motivation : ");
                String motivation = sc.nextLine().trim();

                motivation a = new motivation(lastid, source, motivation);
                all.add(a);

                System.out.printf("%d번 motivation이 등록되었습니다.\n", lastid);

                lastid++;

            } else if (cmd.equals("list")) {
                System.out.println("===== motivation 목록 ====");
                System.out.println(" No. | Source | Motivation");
                if (all.size() == 0) {
                    System.out.println("========= nothing ========");
                    continue;
                }
                System.out.println("==========================");

                ArrayList<motivation> reverseAll = new ArrayList<>();
                for (int i = all.size() - 1; i >= 0; i--) {

                }

                for (motivation r : reverseAll) {
                        System.out.printf("%d.  | %s | %s \n", r.id, r.source, r.motivation);
                }

            } else if (cmd.equals("update")) {
                System.out.println("===== motivation update =====");

                System.out.print("update article No. : ");
                int no = Integer.parseInt(sc.nextLine().trim());

                System.out.print("New source : ");
                String source = sc.nextLine().trim();

                System.out.print("New motivation : ");
                String motivation = sc.nextLine().trim();

                all.set(no - 1, new motivation(no, source, motivation));

            } else if (cmd.equals("del")) {
                System.out.println("===== motivation delete =====");
                System.out.print("delete article No. : ");
                int no = Integer.parseInt(sc.nextLine().trim());
                all.remove(no - 1);

            } else{
                System.out.println("잘못된 명령어입니다.");
                continue;
            }
        }
    }
}