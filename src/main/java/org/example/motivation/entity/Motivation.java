package org.example.motivation.entity;

// motivation 조립용
// DTO의 역할
// 다른 클래스와 달리 데이터 중심의 구조를 갖고 있음
public class Motivation {

    private int no;
    private String source;
    private String motivation;

    // 생성자, DTO
    public Motivation(int no, String source, String motivation) {
        this.no = no;
        this.source = source;
        this.motivation = motivation;
    }

    public int getNo(){
        return this.no;
    }

    public String getSource(){
        return this.source;
    }

    public String getMotivation(){
        return this.motivation;
    }

    public void setSource(String source){
        this.source = source;
    }

    public void setMotivation(String motivation){
        this.motivation = motivation;
    }

}
