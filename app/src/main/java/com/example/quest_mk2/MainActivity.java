package com.example.quest_mk2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    Button theory;
    Button quest;
    Button settings;
    private boolean checkTheory = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theory = findViewById(R.id.theory);
        quest = findViewById(R.id.quest);
        settings = findViewById(R.id.settings);

        theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTheory = new Intent(MainActivity.this, Theory.class);
                startActivity(intentTheory);
                checkTheory = true;
            }
        });

        quest.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                if (checkTheory) {
                    Intent intentQuest = new Intent(MainActivity.this, QuestMenu.class);
                    startActivity(intentQuest);
                }
                else {
                    Toast.makeText(MainActivity.this, "Пройдите теорию", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "Toast");
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSettings = new Intent(MainActivity.this, Settings.class);
                startActivity(intentSettings);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.d(TAG, "Start");

    }

    protected void onResume(){
        super.onResume();
        //Log.d(TAG, "Resume");
        theory.setTextSize(Settings.SETTING_SIZE);
        quest.setTextSize(Settings.SETTING_SIZE);
        settings.setTextSize(Settings.SETTING_SIZE);
        //Log.d(TAG, "Set size");

    }
}