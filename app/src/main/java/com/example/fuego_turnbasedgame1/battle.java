package com.example.fuego_turnbasedgame1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class battle {
    gameScreen gs;

    public battle(gameScreen gs){this.gs = gs;}

    String turnAdvance;

    int turnNumber = 0;


    public void turnButton (String position){
        switch(position){
            case "playerTurn":playerTurn(); break;
            case "enemyTurn": enemyTurn(); break;
        }

        }



    public void heroSkill1(int monsterHP, String heroName, TextView monText, Button btn1, TextView log){
        Random randomizer = new Random();
        int herodps = randomizer.nextInt((gs.getHeroMaxDmg() - gs.getHeroMinDmg()) + gs.getHeroMinDmg());
        int monsdps = randomizer.nextInt((gs.getMonsterMaxDamage() - gs.getMonsterMinDamage()) + gs.getMonsterMinDamage());

        monsterHP = monsterHP - herodps;
        turnNumber++;
        monText.setText(String.valueOf(monsterHP));
        btn1.setVisibility(View.VISIBLE);
        btn1.setText("Next Turn(" + String.valueOf(turnNumber) + ")");
        log.setText("Our Hero  " + String.valueOf(heroName) + " dealt " + herodps + " to the enemy");
        gs.btnSkill1.setEnabled(false);
        gs.btnSkill2.setEnabled(false);
        gs.btnSkill3.setEnabled(false);

        turnAdvance = "enemyTurn";
    }



    public void playerTurn (){
        gs.btnNextTurn.setVisibility(View.GONE);
        gs.txtLog.setText("Hero's turn!");

        gs.btnSkill1.setEnabled(true);
        gs.btnSkill2.setEnabled(true);
        gs.btnSkill3.setEnabled(true);
    }

    public void enemyTurn() {
        Random randomizer = new Random();
        int herodps = randomizer.nextInt((gs.getHeroMaxDmg() - gs.getHeroMinDmg()) + gs.getHeroMinDmg());
        int monsdps = randomizer.nextInt((gs.getMonsterMaxDamage() - gs.getMonsterMinDamage()) + gs.getMonsterMinDamage());

            gs.setHeroHP(gs.getHeroHP() - monsdps);
            turnNumber++;
            gs.txtHeroHP.setText(String.valueOf(gs.getHeroHP()));
            gs.btnNextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");
            gs.txtLog.setText("The Monster " + String.valueOf(gs.monsName) + " dealt " + monsdps + " to you ");

            turnAdvance = "playerTurn";

            if (gs.getHeroHP() < 0)
            {
                gs.txtLog.setText("The Monster " + String.valueOf(gs.monsName) + " dealt " + herodps + " to you. YOU LOSE ");
                gs.heroHP = 1500;
                gs.heroMP = 3000;
                turnNumber = 1;
                gs.btnNextTurn.setText("Reset Game");
            }
        }
}



