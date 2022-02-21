package com.jobforandroid.gb_calculator_2022;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] numberIds = new int[]{
                R.id.btn_zero,
                R.id.btn_1,
                R.id.btn_2,
                R.id.btn_3,
                R.id.btn_4,
                R.id.btn_5,
                R.id.btn_6,
                R.id.btn_7,
                R.id.btn_8,
                R.id.btn_9
        };

        int[] actionsIds = new int[]{
                R.id.btn_plus,
                R.id.btn_minus,
                R.id.btn_multi,
                R.id.btn_division,
                R.id.btn_equal
        };

        tvResult = findViewById(R.id.tvResult);

        calculator = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = view -> {
            calculator.onNumPressed(view.getId());
            tvResult.setText(calculator.getText());
        };

        View.OnClickListener actionButtonOnclickListener = view -> {
            calculator.onActionPressed(view.getId());
            tvResult.setText(calculator.getText());
        };

        for (int numberId : numberIds) {
            findViewById(numberId).setOnClickListener(numberButtonClickListener);
        }

        for (int actionsId : actionsIds) {
            findViewById(actionsId).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.btn_reset).setOnClickListener(view -> {
            calculator.reset();
            tvResult.setText(calculator.getText());
        });

    }

   public void onClickSetting (View view) {
       switch (view.getId()) {
           case R.id.btn_setting:
               Intent intent = new Intent(this, SettingActivity.class);
               startActivity(intent);
               break;
       }
    }

}