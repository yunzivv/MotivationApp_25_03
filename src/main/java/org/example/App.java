package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.motivation.entity.Motivation;
import org.example.system.controller.SystemController;

import java.util.ArrayList;
import java.util.Scanner;

// motivation 기능용
public class App { // main의 스캐너를 생성자에 넣어서 사용

    private Scanner sc; // 명령어를 받기 위한 스캐너


    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        System.out.println("====== motivation 실행 =======");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);

        System.out.println("help : 명령어 도움말");

        while (true) {
            System.out.print("\ncmd : ");
            String cmd = sc.nextLine().trim();

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

            } else if (cmd.contains("detail")) {

                motivationController.detail(cmd);

            } else if (cmd.contains("delete")) {

                motivationController.delete(cmd);

            }else {
                System.out.println("==============================");
                System.out.println("잘못된 명령어입니다.");
                System.out.println("help : 명령어 도움말");
                System.out.println("------------------------------");
                continue;
            }
        }
    }
}