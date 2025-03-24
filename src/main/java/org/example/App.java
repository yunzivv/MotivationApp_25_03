package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;

// motivation 기능용
public class App {

    public void run() {

        System.out.println("====== motivation 실행 =======");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        System.out.println("help : 명령어 도움말");

        while (true) {
            System.out.print("\ncmd : ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {

                systemController.exit();
                break;

            } else if (cmd.equals("help")) {

                systemController.help();

            } else if (cmd.equals("add")) {

                motivationController.add();

            } else if (cmd.equals("list")) {

                motivationController.list();

            } else if (cmd.contains("modify")) {

                motivationController.modify(cmd);

            } else if (cmd.startsWith("detail")) {

                motivationController.detail(cmd);

            } else if (cmd.startsWith("delete ")) {

                motivationController.delete(cmd);

            } else if (cmd.contains("delete?")) {

                motivationController.deleteID(cmd);

            } else {
                System.out.println("==============================");
                System.out.println("잘못된 명령어입니다.");
                System.out.println("help : 명령어 도움말");
                System.out.println("------------------------------");
                continue;
            }
        }
    }
}