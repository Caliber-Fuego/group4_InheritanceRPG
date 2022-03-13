package com.example.fuego_turnbasedgame1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class gameScreen extends AppCompatActivity implements View.OnClickListener {

    TextView txtHeroName, txtMonsName, txtHeroHP, txtMonsHP, txtHeroDmg, txtMonsDmg, txtLog;
    Button btnNextTurn;
    ImageButton btnSkill1, btnSkill2, btnSkill3;

    battle battle = new battle(this);


    //Hero Stats
    String heroName = "Eiyuu";
    int heroHP = 1500;
    int heroMP = 1000;
    int heroMinDmg = 100;
    int heroMaxDmg = 150;

    //Monster Stats

    String monsName = "Slime";
    int monsterHP = 3000;
    int monsterMP = 400;
    int monsterMinDamage = 40;

    int monsterMaxDamage = 55;


    public int getHeroHP() {return heroHP;}
    public int getHeroMinDmg() {return heroMinDmg;}
    public int getHeroMaxDmg() {return heroMaxDmg;}
    public int getMonsterMaxDamage() {return monsterMaxDamage;}
    public int getMonsterMinDamage() {return monsterMinDamage;}

    public void setHeroMinDmg(int heroMinDmg) {this.heroMinDmg = heroMinDmg;}
    public void setHeroMaxDmg(int heroMaxDmg) { this.heroMaxDmg = heroMaxDmg;}
    public void setMonsterMinDamage(int monsterMinDamage) {this.monsterMinDamage = monsterMinDamage;}
    public void setMonsterMaxDamage(int monsterMaxDamage) {this.monsterMaxDamage = monsterMaxDamage;}
    public void setHeroHP(int heroHP) {this.heroHP = heroHP;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //XML ids for texts and buttons
        txtHeroName = findViewById(R.id.txtHeroName);
        txtMonsName = findViewById(R.id.txtMonsName);
        txtHeroHP = findViewById(R.id.txtHeroHP);
        txtHeroDmg = findViewById(R.id.heroDmg);
        txtMonsName = findViewById(R.id.txtMonsName);
        txtMonsHP = findViewById(R.id.txtMonsHP);
        txtMonsDmg = findViewById(R.id.monsDmg);

        btnNextTurn = findViewById(R.id.nextTurnBtn);
        btnSkill1 = findViewById(R.id.skill1);
        btnSkill2 = findViewById(R.id.skill2);
        btnSkill3 = findViewById(R.id.skill3);


        txtLog = findViewById(R.id.combatLog);


        txtHeroName.setText(heroName);
        txtHeroHP.setText(String.valueOf(heroHP));

        txtMonsName.setText(monsName);
        txtMonsHP.setText(String.valueOf(monsterHP));
        txtHeroDmg.setText(String.valueOf(heroMinDmg) + "-" + String.valueOf(heroMaxDmg));
        txtMonsDmg.setText(String.valueOf(monsterMinDamage) + "-" + String.valueOf(monsterMaxDamage));

        btnNextTurn.setVisibility(View.GONE);
        txtLog.setText("Hero's turn!");

        btnSkill1.setEnabled(true);
        btnSkill2.setEnabled(true);
        btnSkill3.setEnabled(true);

        btnSkill1.setOnClickListener(this);
    }
    public void turnbtn (View view) {battle.turnButton(battle.turnAdvance);}

    @Override
    public void onClick (View view){
        switch (view.getId()){
            case R.id.skill1:
                battle.heroSkill1(monsterHP, heroName, txtMonsHP, btnNextTurn, txtLog);
        }
    }

}
