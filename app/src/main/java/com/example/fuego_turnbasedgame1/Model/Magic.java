package com.example.fuego_turnbasedgame1.Model;

public class Magic {

    protected static String magicName;
    protected static int magicDmg;
    protected static int magicID;

    public String getMagicName() {return magicName;}
    public int getMagicDmg() {return magicDmg;}
    public int getMagicID() {return magicID;}

    public void setMagicName(String magicName) {Magic.magicName = magicName;}
    public void setMagicDmg(int magicDmg)      {Magic.magicDmg = magicDmg;}
    public void setMagicID(int magicID)        {Magic.magicID = magicID;}
}
