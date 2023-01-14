package com.ite53330ga.easymedandroid.utils;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ite53330ga.easymedandroid.symptoms.SymptomsIntentBundle;

public abstract class AbsActivity extends AppCompatActivity {
    private static final String SIS_TAG = "Abs_state_save";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        loadData(intent);
    }

    private void loadData(Intent intent) {
        if (intent != null) {
            SymptomsIntentBundle t = getIntent().getParcelableExtra(SymptomsIntentBundle.INTENT_TAG);
            if (t != null) {
                loadDataFromBundle(t);
            }
        }
    }

    public abstract void loadDataFromBundle(SymptomsIntentBundle t);

    public abstract void initUI();
}
