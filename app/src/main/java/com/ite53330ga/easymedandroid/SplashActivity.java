package com.ite53330ga.easymedandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.ite53330ga.easymedandroid.symptoms.SymptomsActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        initialise();
    }

    private void initialise() {
        //TODO add database code loading here

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startDescribeSymptomsActivity();
        }, 3000);
    }

    private void startDescribeSymptomsActivity() {
        Intent switchActivityIntent = new Intent(this, SymptomsActivity.class);
        startActivity(switchActivityIntent);
    }
}