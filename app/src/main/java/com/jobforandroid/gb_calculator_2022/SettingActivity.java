package com.jobforandroid.gb_calculator_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initThemeChooser();

    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.rd_my_theme),
                Portrait);
        initRadioButton(findViewById(R.id.rd_green_theme),
                GreenThemeStyle);
        initRadioButton(findViewById(R.id.rd_orange_theme),
                OrangeThemeStyle);
        initRadioButton(findViewById(R.id.rd_purple_theme),
                PurpleThemeStyle);
       /* RadioGroup rg = findViewById(R.id.radio_group);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(Portrait))).setChecked(true);*/
    }

    private void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

}