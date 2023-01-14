package com.ite53330ga.easymedandroid.diagnostics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ite53330ga.easymedandroid.R;
import com.ite53330ga.easymedandroid.databinding.ActivityDiagnosticsBinding;
import com.ite53330ga.easymedandroid.symptoms.SymptomsIntentBundle;
import com.ite53330ga.easymedandroid.utils.AbsActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

public class DiagnosticsActivity extends AbsActivity {
    private ActivityDiagnosticsBinding mBinding;

    protected Button expandSymptomsBtn;
    protected Button editSymptomsBtn;
    protected TextView resultField;
    protected Button otcMedicationBtn;
    protected Button contactDoctorBtn;

    SymptomsIntentBundle symptomsIntentBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDiagnosticsBinding.inflate(getLayoutInflater());
        mBinding.editBtn.setOnClickListener(v -> {
        });
        setContentView(R.layout.activity_diagnostics);
        expandSymptomsBtn = findViewById(R.id.expandBtn);
        editSymptomsBtn = findViewById(R.id.editBtn);
        resultField = findViewById(R.id.resultsTxtField);
        otcMedicationBtn = findViewById(R.id.showMedsBtn);
        contactDoctorBtn = findViewById(R.id.contactDoctorBtn);

        final int random = new Random().nextInt(10); // [0, 60] + 20 => [20, 80]
        String[] illnesses = {
                "Based on your symptoms it looks like you may have Covid-19.",
                "Based on your symptoms it looks like you may have Seasonal Flu",
                "Based on your symptoms it looks like you may have Yeast Infection",
                "Based on your symptoms it looks like you may have Gallbladder Inflammation",
                "Based on your symptoms it looks like you may have Kidney Stones",
                "Based on your symptoms it looks like you may have RSV infection",
                "Based on your symptoms it looks like you may have Pneumonia",
                "Based on your symptoms it looks like you may have Irritable Bowel Syndrome",
                "Based on your symptoms it looks like you may have Urinary Tract Infection",
                "Based on your symptoms it looks like you may have Appendicitis Inflammation",

        };
        resultField.setText(illnesses[random]);

        otcMedicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Update symtpom keywords to make a proper google search for meds
                String[] symptomKeywords = new String[]{"Advil", "Tylenol"};

                String Search = String.join(" ", symptomKeywords);
                try {
                    Search = URLEncoder.encode(Search, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Uri uri = Uri.parse("http://www.google.com/search?q=" + Search);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        contactDoctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+911";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        editSymptomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                Intent i = new Intent(DiagnosticsActivity.this, SymptomsActivity.class);
//                startActivity(i);
            }
        });

        expandSymptomsBtn.setOnClickListener(view -> {
            SymptomListFragment symptomListFragment = new SymptomListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SymptomsIntentBundle.INTENT_TAG, symptomsIntentBundle);
            symptomListFragment.setArguments(bundle);
            symptomListFragment.show(getSupportFragmentManager(), SymptomListFragment.class.getName());
        });

    }


    @Override
    public void loadDataFromBundle(SymptomsIntentBundle symptomsIntentBundle) {
        this.symptomsIntentBundle = symptomsIntentBundle;
    }


    @Override
    public void initUI() {

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}


