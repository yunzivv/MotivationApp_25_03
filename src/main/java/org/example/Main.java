package org.example;


// motivation 실행용
public class Main {
    public static void main(String[] args) {

        Container.init();

        new App().run();

        Container.close();
    }
}