package com.example.quest_mk2.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quest_mk2.MainActivity;
import com.example.quest_mk2.R;
import com.example.quest_mk2.Settings;
import com.example.quest_mk2.Theory;

import static com.example.quest_mk2.bank.bank_question1.array;

public class bank_Result extends AppCompatActivity {

    Button theory;
    TextView tv;
    Button next_r;
    boolean[] result = new boolean[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank__result);
        tv = (TextView) findViewById(R.id.textView);
        next_r = (Button) findViewById(R.id.next_r);
        theory = (Button) findViewById(R.id.theory);
        result = array.getArr();

        if (result[0]) {
            tv.setText("Вы выбрали верный вариант, переходить по ссылке нельзя. \n");
            if (result[1]) {
                tv.setText("Лучшим решением в этой ситуации будет позвонить другу и обсудить это.  \nВы молодец! Поздравляем");
            }
            else {
                tv.setText("Лучшим решением в этой ситуации будет позвонить другу и обсудить это. ");
            }
        }
        else {
            tv.setText("К сожалению, но Вы выбрали неверный вариант. \n");
            if (result[1]) {
                tv.setText("Вы не стали перечислять деньги, но всё же переходить по таким ссылкам лучше не стоит. \n \n Совет: Вы не стали жертвой мошенников, однако, советуем уточнить нюансы в разделе 'теория' про надёжность сайтов \n");
            }
            else {
                tv.setText("Переходить и вводить реквизиты по подобным ссылкам нельзя. \n Вы стали жервтой мошенников. \n\n Совет: Вернитесь в раздел 'Теория' и изучите материал 'Фишинг' и 'Безопасность сайтов'  ");
            }
        }

        next_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProduct_Result_n = new Intent(bank_Result.this, MainActivity.class);
                startActivity(intentProduct_Result_n);
            }
        });
        theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProduct_Result_t = new Intent(bank_Result.this, Theory.class);
                startActivity(intentProduct_Result_t);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        theory.setTextSize(Settings.SETTING_SIZE);
        tv.setTextSize(Settings.SETTING_SIZE);
        next_r.setTextSize(Settings.SETTING_SIZE);
    }
}