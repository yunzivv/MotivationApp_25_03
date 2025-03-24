package org.example;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    // 공유자원 컨테이너 초기화
    public static void init() {
        sc = new Scanner(System.in);
    }

    // 공유자원 컨테이너 해제
    public static void close() {
        sc.close();
    }

    // 스캐너 전달
    public static Scanner getScanner() {
        return sc;
    }
}
