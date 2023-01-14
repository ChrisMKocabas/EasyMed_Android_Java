package com.ite53330ga.easymedandroid.diagnostics;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ite53330ga.easymedandroid.R;
import com.ite53330ga.easymedandroid.databinding.FragmentSymptomListBinding;
import com.ite53330ga.easymedandroid.databinding.IncludeDiagnosisSymptomsListBinding;
import com.ite53330ga.easymedandroid.symptoms.SymptomItem;
import com.ite53330ga.easymedandroid.symptoms.SymptomsIntentBundle;

public class SymptomListFragment extends DialogFragment {
    FragmentSymptomListBinding binding;


    @Nullable
    @Override
    public Dialog getDialog() {
        return super.getDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSymptomListBinding.inflate(getLayoutInflater(), container, false);

        SymptomsIntentBundle symptomsIntentBundle = getArguments().getParcelable(SymptomsIntentBundle.INTENT_TAG);

        for (SymptomItem item : symptomsIntentBundle.getSelected()) {
            IncludeDiagnosisSymptomsListBinding includeBinding = IncludeDiagnosisSymptomsListBinding.inflate(getLayoutInflater(), binding.getRoot(), false);
            includeBinding.textView14.setText(item.dbItem.name);
            includeBinding.textView17.setText(item.severity + "/10");
            includeBinding.textView18.setText(item.symptomsDuration.name());
            binding.container.addView(includeBinding.getRoot());
        }


        binding.button.setOnClickListener(view -> {
            dismiss();
        });

        return binding.getRoot();
    }


}