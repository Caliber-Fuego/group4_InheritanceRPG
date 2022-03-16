package com.example.fuego_turnbasedgame1;

public class MonsterStatus {
    protected static String monsterName;
    protected static int monId;
    protected static int monHPts;
    protected static int monMaxHPts;
    protected static int monMinDmg;
    protected static int monMaxDmg;

    //Getters
    public static String getMonsterName() {return monsterName;}
    public static int getMonMaxHPts() {return monMaxHPts;}
    public static int getMonHPts() {return monHPts;}
    public static int getMonMinDmg() {return monMinDmg;}
    public static int getMonMaxDmg() {return monMaxDmg;}
    public static int getMonId() {return monId;}

    //Setters
    public static void setMonsterName(String monsterName) {MonsterStatus.monsterName = monsterName;}
    public static void setMonHPts(int monHPts) {MonsterStatus.monHPts = monHPts;}
    public static void setMonMaxHPts(int monMaxHPts) {MonsterStatus.monMaxHPts = monMaxHPts;}
    public static void setMonMinDmg(int monMinDmg) {MonsterStatus.monMinDmg = monMinDmg;}
    public static void setMonMaxDmg(int monMaxDmg) {MonsterStatus.monMaxDmg = monMaxDmg;}
    public static void setMonId(int monId) {MonsterStatus.monId = monId;}



}
