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

        lastid++;
    }

    public void list() {
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
                System.out.printf("  %d.  |  %s  |  %-10s \n", r.id, r.source.substring(0, 3) + "...", r.motivation);
            } else {
                System.out.printf("  %d.  |  %-6s  |  %-10s \n", r.id, r.source, r.motivation);
            }
        }
        System.out.println("------------------------------");
    }

    public void update() {
        System.out.println("====== motivation 수정 =======");

        System.out.print("update article No. : ");
        int no = Integer.parseInt(sc.nextLine().trim());

        System.out.print("New source : ");
        String source = sc.nextLine().trim();

        System.out.print("New motivation : ");
        String motivation = sc.nextLine().trim();

        all.set(no - 1, new Motivation(no, source, motivation));
    }

    public void del() {
        System.out.println("====== motivation 삭제 =======");
        System.out.print("delete article No. : ");
        int no = Integer.parseInt(sc.nextLine().trim());
        all.remove(no - 1);
        System.out.printf("%d번 motivation이 삭제 되었습니다.\n", no);
    }
}
