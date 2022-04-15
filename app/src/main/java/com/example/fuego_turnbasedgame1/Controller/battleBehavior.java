package com.example.fuego_turnbasedgame1.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fuego_turnbasedgame1.Model.HeroStatus;
import com.example.fuego_turnbasedgame1.Model.Magic;
import com.example.fuego_turnbasedgame1.Model.MonsterStatus;
import com.example.fuego_turnbasedgame1.R;
import com.example.fuego_turnbasedgame1.gameScreen;

import java.util.Random;

public class battleBehavior {
    gameScreen gs;
    MonsterStatus mon;
    Magic magic = new Magic();
    HeroStatus hero = new HeroStatus();
    battle battle;

    Random randomizer = new Random();
    public battleBehavior(gameScreen gs){this.gs = gs;}
    public battleBehavior(battle battle){this.battle = battle;}


    //Hero Skills
    public void heroSkill1(int maxdmg, int mindmg, String heroName, TextView monText, Button btn1, TextView log, String turnAdvance){
        //The First Skill Button

        int herodps = randomizer.nextInt((maxdmg - mindmg)) + mindmg;
        //sets the number for "herodps" to the randomization of the hero's max damage and min damage

        //Sets the values that were changed
        mon.setMonHPts(mon.getMonHPts()-herodps);
        monText.setText(String.valueOf(mon.getMonHPts()));
        btn1.setVisibility(View.VISIBLE);
        btn1.setText("Next Turn");
        log.setText("Our Hero  " + String.valueOf(heroName) + " dealt " + herodps + " to the enemy");

        //On pressing the button, disables the button to be pressed
        gs.btnSkill1.setEnabled(false);
        gs.btnSkill2.setEnabled(false);

        //Changes the string to call the method assigned to the string through the switch statement
        battle.turnAdvance = "enemyTurn";

        if (mon.getMonHPts() < 0){
            //If else statement in the condition of the monster having 0 health value

            log.setText("Our Hero  " + String.valueOf(heroName) + " dealt " + herodps + " to the enemy and won the battle!");
            btn1.setText("Reset Game");
            battle.turnAdvance = "resetGame";
            battle.turnNumber = 1;
            hero.setHeroHP(hero.getHeroMaxHP());
            mon.setMonHPts(mon.getMonMaxHPts());
        }
    }

    public void heroSkill2(String heroName, Button btn1, TextView log){
        //The Second Skill Button
        //Sets the value for specific integers upon pressing the button
        battle.skill2cd = 3;
        log.setText("Our Hero  " + String.valueOf(heroName) + " raises his defenses!");
        hero.setHeroArmor((25.0f/100.0f));
        gs.btnSkill2.setImageResource(R.drawable.btn_defendcd);
        btn1.setVisibility(View.VISIBLE);
        btn1.setText("Next Turn");
        switch(mon.getMonId()) {
            //TODO MAKE A BETTER MONSTER GENERATOR
            case 1:
                battle.turnAdvance = "enemyTurn";
                break;
            case 2:
                battle.turnAdvance = "spiderTurn";
        }
        gs.btnSkill1.setEnabled(false);
        gs.btnSkill2.setEnabled(false);
    }

    //Monster Skills
    public float normalDamage (int minDamage, int maxDamage, double armor){
        double result = ((int)((randomizer.nextInt((maxDamage - minDamage)) + minDamage)*(armor)));
        return (int) result;
    }

    public void magicSkills (TextView skill2cd, TextView heroHP, TextView log, double armor){
        switch (magic.getMagicID()){
            case 1:
                battle.setSkill2cd(battle.getSkill2cd()+1);
                skill2cd.setText(String.valueOf(battle.getSkill2cd()));
                //sets the number for "magicdmg" and adds to the number of cooldown

                double magicdmg = (magic.getMagicDmg())*(armor);
                //Sets the values that were changed
                hero.setHeroHP(((int)(hero.getHeroHP()-magicdmg)));
                heroHP.setText(String.valueOf(hero.getHeroHP()));
                log.setText("The "+mon.getMonsterName()+ " threw a slime ball and dealt " +magicdmg+ " damage to you \n\n" +
                        "The cooldown of your skills is also extended!");
                break;
        }
    }
}
