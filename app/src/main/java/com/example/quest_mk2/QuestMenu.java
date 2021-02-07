package com.example.quest_mk2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quest_mk2.bank.bank_question1;
import com.example.quest_mk2.product_buy.product_question1;

public class QuestMenu extends AppCompatActivity {

    TextView tv;
    ImageButton productBuy;
    ImageButton bank;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_menu);
        productBuy = (ImageButton) findViewById(R.id.product);
        bank = (ImageButton) findViewById(R.id.bank);
        tv = (TextView) findViewById(R.id.textView3);

        productBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuestions = new Intent(QuestMenu.this, product_question1.class);
                startActivity(intentQuestions);
            }
        });

        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuestions = new Intent(QuestMenu.this, bank_question1.class);
                startActivity(intentQuestions);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setTextSize(Settings.SETTING_SIZE);
    }
}