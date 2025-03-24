package org.example;

import java.util.Scanner;

// 스캐너를 사용할 때 객체가 클래스를 넘나들지 않고
// Container 클래스의 메서드를 뽑아서 사용 가능
// 구조적으로 개선
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
