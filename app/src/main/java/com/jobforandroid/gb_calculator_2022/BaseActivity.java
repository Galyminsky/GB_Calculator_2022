package com.jobforandroid.gb_calculator_2022;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    private static final String NameSharedPreference = "LOGIN";
    private static final String AppTheme = "APP_THEME";

    protected static final int Portrait = 0;
    protected static final int GreenThemeStyle = 1;
    protected static final int OrangeThemeStyle = 2;
    protected static final int PurpleThemeStyle = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.Portrait));
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    protected int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case GreenThemeStyle:
                return R.style.ThemeGreen;
            case OrangeThemeStyle:
                return R.style.ThemeOrange;
            case PurpleThemeStyle:
                return R.style.ThemePurple;
            default:
                return R.style.Portrait;
        }
    }
}