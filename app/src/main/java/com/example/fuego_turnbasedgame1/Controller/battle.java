package com.example.fuego_turnbasedgame1.Controller;

import android.view.View;

import com.example.fuego_turnbasedgame1.Model.HeroStatus;
import com.example.fuego_turnbasedgame1.Model.Magic;
import com.example.fuego_turnbasedgame1.Model.Magics.Magic_SlimeBall;
import com.example.fuego_turnbasedgame1.Model.MonsterStatus;
import com.example.fuego_turnbasedgame1.Model.Monsters.Monster_Slime;
import com.example.fuego_turnbasedgame1.Model.Monsters.Monster_Spider;
import com.example.fuego_turnbasedgame1.R;
import com.example.fuego_turnbasedgame1.gameScreen;

import java.util.Random;

public class battle {
    //Allows the use of code from other classes
    gameScreen gs;
    battleBehavior bbhv = new battleBehavior(this);
    MonsterStatus mon = new MonsterStatus();
    Magic magic = new Magic();
    HeroStatus hero = new HeroStatus();
    Monster_Spider spider;
    public battle(gameScreen gs){this.gs = gs;}
    public battle(Monster_Spider spider) {this.spider = spider;}

    public static String turnAdvance = "";
    //the turnAdvance String. Used for calling methods through the switch statement
    Random randomizer = new Random();
    Random roll = new Random();
    //Randomizer

    static int turnNumber = 1;
    //String for turn number

    float monsterdps = 0;
    //integer for monsterdps


    static int skill2cd = 0;
    //boolean integers

    //Getters and Setters
    public static int getTurnNumber() {return battle.turnNumber;}
    public int getSkill2cd() {return skill2cd;}
    public float getMonsterdps() {return monsterdps;}
    public String getTurnAdvance() {return turnAdvance;}

    public void setTurnNumber(int turnNumber) {battle.turnNumber = turnNumber;}
    public void setMonsterdps(int monsterdps) {this.monsterdps = monsterdps;}
    public void setSkill2cd(int skill2cd) {this.skill2cd = skill2cd;}
    public void setTurnAdvance(String turnAdvance) {battle.turnAdvance = turnAdvance;}


    public void turnButton (String position){
        //The Switch statement used to call methods assigned to the string case
        switch(position){
            case "playerTurn":playerTurn(); break;
            case "enemyTurn": enemyTurn(); break;
            case "resetGame": resetGame(); break;
            case "spiderTurn": spiderTurn(); break;
        }
    }

    public void enemyGenerate(){
        //TODO Make this work lol
        skill2cd = 0;
        int enemyRoll = roll.nextInt(2);
        switch (enemyRoll){
            case 0:
                mon = new Monster_Spider();
                gs.monImg.setImageResource(R.drawable.monster_spiderr);
                break;
            case 1:
            case 2:
                mon = new Monster_Slime();
                magic = new Magic_SlimeBall();
                gs.monImg.setImageResource(R.drawable.monster_slime);
                break;
        }
        hero.setHeroHP(hero.getHeroMaxHP());
        mon.setMonHPts(mon.getMonMaxHPts());
        gs.txtMonsName.setText(mon.getMonsterName());
        gs.txtHeroHP.setText(String.valueOf(hero.getHeroMaxHP()));
        gs.txtMonsHP.setText(String.valueOf(mon.getMonHPts()));
        gs.txtMonsDmg.setText(String.valueOf(mon.getMonMinDmg()) + "-" + String.valueOf(mon.getMonMaxDmg()));
    }


    public void playerTurn (){
        //Method for the player turn

        gs.btnNextTurn.setVisibility(View.GONE);
        //Sets the button to be gone until a skill button is pressed

        //Sets the updated values
        gs.txtLog.setText("Hero's turn!");
        setTurnNumber(getTurnNumber()+1);
        gs.txtTurn.setText("Turn " + String.valueOf(battle.getTurnNumber()));

        //Allows the button to be pressed
        gs.btnSkill1.setEnabled(true);
        if (skill2cd > 0){
            //Disables the btn to be pressed when skill cooldown isn't 0
            gs.txtSkill2cd.setVisibility(View.VISIBLE);
            gs.txtSkill2cd.setText(String.valueOf(getSkill2cd()));
            gs.btnSkill2.setEnabled(false);
            skill2cd--;
        }else if (skill2cd==0){
            //Enables the button to be pressed when skill cooldown is 0
            //Also sets the defensbuff integer to 0
            gs.txtSkill2cd.setVisibility(View.INVISIBLE);
            gs.btnSkill2.setImageResource(R.drawable.btn_defend);
            gs.btnSkill2.setEnabled(true);
        }
    }

    public void enemyTurn() {
        Random roll = new Random();
        int enemyRoll = roll.nextInt(2);
        if (enemyRoll==0){
            bbhv.magicSkills(gs.txtSkill2cd, gs.txtHeroHP, gs.txtLog, hero.getHeroArmor());

        }else if(enemyRoll==1){
            bbhv.magicSkills(gs.txtSkill2cd, gs.txtHeroHP, gs.txtLog, hero.getHeroArmor());
        }

            //Calls the method assigned to the string from the switch statement
        gs.btnNextTurn.setText("Next Turn");
        turnAdvance = "playerTurn";
            if (hero.getHeroHP() < 0) {
                //If else statement in the condition of the hero having 0 health value
                gs.txtLog.setText("The Monster " + String.valueOf(mon.getMonsterName()) + " dealt " + getMonsterdps() + " to you. YOU LOSE ");
                gs.btnNextTurn.setText("Reset Game");
                turnAdvance = "resetGame";
            }
        }

    public void spiderTurn() {
                monsterdps = bbhv.normalDamage(mon.getMonMinDmg(), mon.getMonMaxDmg(), hero.getHeroArmor());
                //sets the number for "monsdps" to the randomization of the monster's max damage and min damage

                //Sets the updated values
                hero.setHeroHP(hero.getHeroHP() - (int)getMonsterdps());
                gs.txtHeroHP.setText(String.valueOf(hero.getHeroHP()));
                gs.btnNextTurn.setText("Next Turn");
                gs.txtLog.setText("The Monster " + String.valueOf(mon.getMonsterName()) + " dealt " + getMonsterdps() + " to you ");

        //Calls the method assigned to the string from the switch statement
        if (hero.getHeroHP() > 0) {
            turnAdvance = "playerTurn";
        }else if (hero.getHeroHP() < 0) {
            //If else statement in the condition of the hero having 0 health value
            gs.txtLog.setText("The Monster " + String.valueOf(mon.getMonsterName()) + " dealt " + getMonsterdps() + " to you. YOU LOSE ");
            gs.btnNextTurn.setText("Reset Game");
            turnAdvance = "resetGame";
        }
    }

    public void resetGame(){
        //Method for resetting the game to it's default values
        gs.txtLog.setText("Our Hero encountered a monster!");
        turnAdvance = "resetGame";
        setTurnNumber(0);
        skill2cd = 0;
        int enemyRoll = roll.nextInt(2);
        switch (enemyRoll){
            case 0:
                mon = new Monster_Spider();
                gs.monImg.setImageResource(R.drawable.monster_spiderr);
                break;
            case 1:
            case 2:
                mon = new Monster_Slime();
                gs.monImg.setImageResource(R.drawable.monster_slime);
                break;
        }
        hero.setHeroHP(hero.getHeroMaxHP());
        mon.setMonHPts(mon.getMonMaxHPts());
        gs.txtMonsName.setText(mon.getMonsterName());
        gs.txtHeroHP.setText(String.valueOf(hero.getHeroHP()));
        gs.txtMonsHP.setText(String.valueOf(mon.getMonHPts()));
        gs.txtMonsDmg.setText(String.valueOf(mon.getMonMinDmg()) + "-" + String.valueOf(mon.getMonMaxDmg()));
        gs.txtTurn.setText("");
        gs.btnNextTurn.setText("Fight!");
        //Calls the method assigned to the string from the switch statement
        turnAdvance = "playerTurn";
    }
}



