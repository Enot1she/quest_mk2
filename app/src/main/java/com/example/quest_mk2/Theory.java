package com.example.quest_mk2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Theory extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        text1 = (TextView) findViewById(R.id.text1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        text1.setTextSize(Settings.SETTING_SIZE);
    }
}