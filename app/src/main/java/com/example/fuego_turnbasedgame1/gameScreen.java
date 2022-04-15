package com.example.fuego_turnbasedgame1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fuego_turnbasedgame1.Controller.battle;
import com.example.fuego_turnbasedgame1.Model.HeroStatus;
import com.example.fuego_turnbasedgame1.Controller.battleBehavior;
import com.example.fuego_turnbasedgame1.Model.Magic;
import com.example.fuego_turnbasedgame1.Model.Magics.Magic_SlimeBall;
import com.example.fuego_turnbasedgame1.Model.MonsterStatus;
import com.example.fuego_turnbasedgame1.Model.Monsters.Monster_Slime;

public class gameScreen extends AppCompatActivity implements View.OnClickListener {

    public TextView txtHeroName, txtMonsName, txtHeroHP, txtMonsHP, txtHeroDmg, txtMonsDmg, txtLog, txtTurn, txtSkill2cd;
    public Button btnNextTurn;
    public ImageButton btnSkill1, btnSkill2;
    public ImageView monImg;

    com.example.fuego_turnbasedgame1.Controller.battle battle = new battle(this);
    HeroStatus hero = new HeroStatus();
    MonsterStatus mon = new MonsterStatus();
    Magic magic = new Magic();
    battleBehavior battleBehavior = new battleBehavior(this);


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
        magic = new Magic_SlimeBall();
        monImg.setImageResource(R.drawable.monster_slime);
        txtHeroName.setText(hero.getHeroName());
        txtHeroHP.setText(String.valueOf(hero.getHeroHP()));
        txtTurn.setText("Turn " + String.valueOf(battle.getTurnNumber()));
        txtMonsName.setText(mon.getMonsterName());
        txtMonsHP.setText(String.valueOf(mon.getMonHPts()));
        txtHeroDmg.setText(String.valueOf(hero.getHeroMinDmg()) + "-" + String.valueOf(hero.getHeroMaxDmg()));
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
                battleBehavior.heroSkill1(hero.getHeroMaxDmg(), hero.getHeroMinDmg(), hero.getHeroName(), txtMonsHP, btnNextTurn, txtLog, battle.turnAdvance);
                break;
                //Allows the button to call the method from "battle class" when clicked
            case R.id.skill2:
                battleBehavior.heroSkill2(hero.getHeroName(), btnNextTurn, txtLog);
                break;
        }
    }

}
