package com.sqli.isc.iut.courses.cucumber;






public class Personne {


    

    private String name;
    private int money;
    private int nbGlass;
    private Emotion emotion;


    public Personne(String name,int moeny, int nbGlass) {
        this.name = name;
        this.money = moeny;
        this.nbGlass = nbGlass;

    }

    public String getName() {
        return this.name;
    }
    
    public int getnbGlasse() {
        return this.nbGlass;
    }

    public void setnbGlasse(int nbGlass) {
        this.nbGlass = nbGlass;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Emotion getEmotion() {
        return this.emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }


}
