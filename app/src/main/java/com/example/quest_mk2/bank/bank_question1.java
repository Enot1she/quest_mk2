package com.example.quest_mk2.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quest_mk2.Array;
import com.example.quest_mk2.R;
import com.example.quest_mk2.Settings;

public class bank_question1 extends AppCompatActivity {
    private RadioButton bt_g;
    private RadioButton bt_b;
    private TextView tv;
    private Button next;
    private TextView tv2;
    private boolean isImageScaled = false;
    ImageView imageView_n_ok;
    ImageView imageView_ok;

    static Array array = new Array();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_question1);
        bt_g = (RadioButton) findViewById(R.id.bt_g);
        bt_b = (RadioButton) findViewById(R.id.bt_b);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView1);
        next = (Button) findViewById(R.id.next);
        ImageView ok = (ImageView) findViewById(R.id.imageView_ok);
        ImageView n_ok = (ImageView) findViewById(R.id.imageView_n_ok);
        ok.setOnClickListener(v -> {
            if (!isImageScaled) v.animate().scaleX(1.1f).scaleY(1.5f).setDuration(5);
            if (isImageScaled) v.animate().scaleX(1f).scaleY(1f).setDuration(5);
            isImageScaled = !isImageScaled;
        });
        n_ok.setOnClickListener(v -> {
            if (!isImageScaled) v.animate().scaleX(1.1f).scaleY(1.5f).setDuration(5);
            if (isImageScaled) v.animate().scaleX(1f).scaleY(1f).setDuration(5);
            isImageScaled = !isImageScaled;
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_g.isChecked()){
                    array.getAns(true, 0);
                    Intent intentProduct_question_good = new Intent(bank_question1.this, bank_good.class);
                    startActivity(intentProduct_question_good);
                }
                else if (bt_b.isChecked()) {
                    array.getAns(false, 0);
                    Intent intentProduct_question_bad = new Intent(bank_question1.this, bank_bad.class);
                    startActivity(intentProduct_question_bad);
                }
                else {
                    Toast.makeText(bank_question1.this, "Выберите вариант", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        bt_b.setTextSize(Settings.SETTING_SIZE);
        bt_g.setTextSize(Settings.SETTING_SIZE);
        tv.setTextSize(Settings.SETTING_SIZE);
        next.setTextSize(Settings.SETTING_SIZE);
        tv2.setTextSize(Settings.SETTING_SIZE);
    }
}