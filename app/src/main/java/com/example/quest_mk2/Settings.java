package com.example.quest_mk2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.slider.Slider;

public class Settings extends AppCompatActivity {

    public static int SETTING_SIZE = 16;
    Slider settingsSlider;
    TextView example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settingsSlider = findViewById(R.id.slider);
        example = findViewById(R.id.example);
        example.setTextSize(SETTING_SIZE);

        settingsSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                SETTING_SIZE = (int) settingsSlider.getValue();
                example.setTextSize(SETTING_SIZE);
            }
        });
    }

}