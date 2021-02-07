package com.example.quest_mk2.product_buy;

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

import static com.example.quest_mk2.product_buy.product_question1.array;

public class product_Result extends AppCompatActivity {

    TextView tv;
    Button next_r;
    boolean[] result = new boolean[2];
    Button theory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__result);
        tv = (TextView) findViewById(R.id.textView);
        next_r = (Button) findViewById(R.id.next_r);
        theory = (Button) findViewById(R.id.theory);
        result = array.getArr();

        if (result[0]) {
            tv.setText("Вы выбрали надежный сайт. Вы молодец \n");
            if (result[1]) {
                tv.setText("Вы выбрали надежный сайт, а это значит, что Вы можете вводить свои данные сюда и совершить заказ. \nВы молодец! Поздравляем");
            }
            else {
                tv.setText("Вы выбрали надежный сайт, а это значит, что Вы могли сюда ввести свои данные, но странно почему этого не сделали. \nЕсли вы сомневаетесь в своих силах, советуем вернуться назад в раздел 'Теория' и подробнее изучить материал.");
            }
        }
        else {
            tv.setText("К сожалению, но Вы выбрали ненадежный сайт. \n");
            if (result[1]) {
                tv.setText("Вы выбрали ненадежный сайт, а это значит, что вводить данные нельзя. \nВы стали жертвой мошенников. \n \n Совет: \nВернитесь назад в раздел 'Теория' и заострите внимание на разделе 'Безопасность сайтов'");
            }
            else {
                tv.setText("Вы выбрали ненадежный сайт, а это значит, что вводить данные на нём нельзя. \nНо Вы не ввели свои данные, Вы не стали жертвой мошенников, однако, советуем уточнить нюансы в разделе 'теории' про надёжность сайтов \n");
            }
        }

        next_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProduct_Result_n = new Intent(product_Result.this, MainActivity.class);
                startActivity(intentProduct_Result_n);


            }
        });

        theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProduct_Result_t = new Intent(product_Result.this, Theory.class);
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