package org.example.motivation.entity;

// motivation 조립용
public class Motivation {

    private int no;
    private String source;
    private String motivation;

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

    public void setNo(int no){
        this.no = no;
    }

    public void setSource(String source){
        this.source = source;
    }

    public void setMotivation(String motivation){
        this.motivation = motivation;
    }

}
