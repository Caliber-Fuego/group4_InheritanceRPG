package com.example.fuego_turnbasedgame1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fuego_turnbasedgame1.Monsters.Monster_Slime;

import java.util.Random;

public class gameScreen extends AppCompatActivity implements View.OnClickListener {

    TextView txtHeroName, txtMonsName, txtHeroHP, txtMonsHP, txtHeroDmg, txtMonsDmg, txtLog, txtTurn, txtSkill2cd;
    Button btnNextTurn;
    ImageButton btnSkill1, btnSkill2;
    ImageView monImg;

    battle battle = new battle(this);
    MonsterStatus mon = new MonsterStatus();


    //Hero Stats
    String heroName = "Eiyuu";
    int heroHP = 500;
    int heroMaxHP = 500;
    int heroMP = 1000;
    int heroMinDmg = 100;
    int heroMaxDmg = 150;

    //Getters
    public int getHeroHP() {return heroHP;}
    public int getHeroMaxHP() {return heroMaxHP;}
    public int getHeroMinDmg() {return heroMinDmg;}
    public int getHeroMaxDmg() {return heroMaxDmg;}

    //Setters
    public void setHeroMinDmg(int heroMinDmg) {this.heroMinDmg = heroMinDmg;}
    public void setHeroMaxDmg(int heroMaxDmg) { this.heroMaxDmg = heroMaxDmg;}
    public void setHeroHP(int heroHP) {this.heroHP = heroHP;}
    public void setHeroMaxHP(int heroMaxHP) {this.heroMaxHP = heroMaxHP;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //XML ids for texts
        txtHeroName = findViewById(R.id.txtHeroName);
        txtMonsName = findViewById(R.id.txtMonsName);
        txtHeroHP = findViewById(R.id.txtHeroHP);
        txtHeroDmg = findViewById(R.id.heroDmg);
        txtMonsName = findViewById(R.id.txtMonsName);
        txtMonsHP = findViewById(R.id.txtMonsHP);
        txtMonsDmg = findViewById(R.id.monsDmg);
        txtTurn = findViewById(R.id.turnNmbr);
        txtLog = findViewById(R.id.combatLog);
        txtSkill2cd = findViewById(R.id.s2cooldowncounter);
        monImg = findViewById(R.id.monsterimg);

        //XML ids for buttons
        btnNextTurn = findViewById(R.id.nextTurnBtn);
        btnSkill1 = findViewById(R.id.skill1);
        btnSkill2 = findViewById(R.id.skill2);

        //Default Setters
        mon = new Monster_Slime();
        monImg.setImageResource(R.drawable.monster_slime);
        txtHeroName.setText(heroName);
        txtHeroHP.setText(String.valueOf(heroHP));
        txtTurn.setText("Turn " + String.valueOf(battle.getTurnNumber()));
        txtMonsName.setText(mon.getMonsterName());
        txtMonsHP.setText(String.valueOf(mon.getMonHPts()));
        txtHeroDmg.setText(String.valueOf(heroMinDmg) + "-" + String.valueOf(heroMaxDmg));
        txtMonsDmg.setText(String.valueOf(mon.getMonMinDmg()) + "-" + String.valueOf(mon.getMonMaxDmg()));
        btnNextTurn.setVisibility(View.GONE);
        txtLog.setText("Hero's turn!");
        btnSkill1.setEnabled(true);
        btnSkill2.setEnabled(true);

        //OnClickListeners for the skill buttons
        btnSkill1.setOnClickListener(this);
        btnSkill2.setOnClickListener(this);
    }

    //Connects the Turn Button to the turnAdvance String from the "battle class"
    //This allows it to move on between methods through the switch statements
    public void turnbtn (View view) {battle.turnButton(battle.turnAdvance);}

    @Override
    public void onClick (View view){
        switch (view.getId()){
            case R.id.skill1:
                battle.heroSkill1(heroMaxDmg, heroMinDmg, heroName, txtMonsHP, btnNextTurn, txtLog);
                break;
                //Allows the button to call the method from "battle class" when clicked
            case R.id.skill2:
                battle.heroSkill2(heroName, btnNextTurn, txtLog);
                break;
        }
    }

}
