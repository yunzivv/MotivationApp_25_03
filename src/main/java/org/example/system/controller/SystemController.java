package org.example.system.controller;

public class SystemController {
    public void exit() {
        System.out.println("====== motivation 종료 =======");
    }

    public void help() {
        System.out.println("======== command 목록 ========");
        System.out.println("list : motivation 목록");
        System.out.println("add : motivation 추가");
        System.out.println("delete & No : motivation 삭제");
        System.out.println("modify & No : motivation 수정");
        System.out.println("detail & No : motivation 상세");
        System.out.println("exit : motivation 종료");
        System.out.println("------------------------------");
    }
}
