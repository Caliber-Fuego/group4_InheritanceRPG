package com.example.fuego_turnbasedgame1.Monsters;

import android.widget.TextView;

import com.example.fuego_turnbasedgame1.MonsterStatus;
import com.example.fuego_turnbasedgame1.battle;
import com.example.fuego_turnbasedgame1.gameScreen;

import java.util.Random;

public class Monster_Spider extends MonsterStatus {
    gameScreen gs = new gameScreen();
    battle battle = new battle(this);

    public Monster_Spider (){
        monsterName = "Venom Spider";
        monId = 2;
        monHPts = 800;
        monMaxHPts = 800;
        monMinDmg = 70;
        monMaxDmg = 150;
    }
}
