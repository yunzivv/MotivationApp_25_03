package org.example.motivation.entity;

// motivation 조립용
public class Motivation {

    public int id;
    public String source;
    public String motivation;

    public Motivation(int id, String source, String motivation) {
        this.id = id;
        this.source = source;
        this.motivation = motivation;
    }

    int getNo(){
        return this.id;
    }

    String getSource(){
        return this.source;
    }

    String getMotivation(){
        return this.motivation;
    }

    void setId(int id){
        this.id = id;
    }

    void setSource(String source){
        this.source = source;
    }

    void setMotivation(String motivation){
        this.motivation = motivation;
    }

}
