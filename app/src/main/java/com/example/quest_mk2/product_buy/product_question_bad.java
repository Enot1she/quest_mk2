package com.example.quest_mk2.product_buy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quest_mk2.R;
import com.example.quest_mk2.Settings;

import static com.example.quest_mk2.product_buy.product_question1.array;

public class product_question_bad extends AppCompatActivity {
    private RadioButton bt_g;
    private RadioButton bt_b;
    private TextView tv;
    private Button next;
    private boolean isImageScaled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_question_bad);
        bt_g = (RadioButton) findViewById(R.id.bt_g);
        bt_b = (RadioButton) findViewById(R.id.bt_b);
        tv = (TextView) findViewById(R.id.textView);
        next = (Button) findViewById(R.id.next);
        ImageView n_ok = (ImageView) findViewById(R.id.imageView_n_ok);
        n_ok.setOnClickListener(v -> {
            if (!isImageScaled) v.animate().scaleX(1.1f).scaleY(1.5f).setDuration(5);
            if (isImageScaled) v.animate().scaleX(1f).scaleY(1f).setDuration(5);
            isImageScaled = !isImageScaled;
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_g.isChecked()){
                    array.getAns(true, 1);
                    Intent intentProduct_Result_b = new Intent(product_question_bad.this, product_Result.class);
                    startActivity(intentProduct_Result_b);

                }
                else if (bt_b.isChecked()) {
                    array.getAns(false, 1);
                    Intent intentProduct_Result_b = new Intent(product_question_bad.this, product_Result.class);
                    startActivity(intentProduct_Result_b);

                }
                else {
                    Toast.makeText(product_question_bad.this, "Выберите вариант", Toast.LENGTH_LONG).show();
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
    }
}