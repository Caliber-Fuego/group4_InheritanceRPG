package com.example.fuego_turnbasedgame1.Model;

public class HeroStatus {

    //Hero Stats
    private String heroName = "Eiyuu";
    private int heroHP = 500;
    private int heroMaxHP = 500;
    private int heroMP = 1000;
    private int heroMinDmg = 100;
    private int heroMaxDmg = 150;
    static double heroArmor = 1;

    //Getters
    public int getHeroHP() {return heroHP;}
    public int getHeroMaxHP() {return heroMaxHP;}
    public int getHeroMinDmg() {return heroMinDmg;}
    public int getHeroMaxDmg() {return heroMaxDmg;}
    public double getHeroArmor() {return heroArmor;}
    public String getHeroName() {return heroName;}

    //Setters
    public void setHeroMinDmg(int heroMinDmg) {this.heroMinDmg = heroMinDmg;}
    public void setHeroMaxDmg(int heroMaxDmg) { this.heroMaxDmg = heroMaxDmg;}
    public void setHeroHP(int heroHP) {this.heroHP = heroHP;}
    public void setHeroMaxHP(int heroMaxHP) {this.heroMaxHP = heroMaxHP;}
    public void setHeroName(String heroName) {this.heroName = heroName;}
    public void setHeroArmor(float heroArmor) {HeroStatus.heroArmor = heroArmor;}

}
