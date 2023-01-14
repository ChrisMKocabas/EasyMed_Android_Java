package com.ite53330ga.easymedandroid.symptoms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ite53330ga.easymedandroid.databinding.FragmentSymptomsSelectDialogListDialogBinding;
import com.ite53330ga.easymedandroid.utils.SymptomsDuration;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     SymptomsSelectDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class SymptomsSelectDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private FragmentSymptomsSelectDialogListDialogBinding binding;
    private SymptomsAddedListener symptomsAddedListener;
    private SymptomItem item;

    // TODO: Customize parameters
    public static SymptomsSelectDialogFragment newInstance(int itemCount) {
        final SymptomsSelectDialogFragment fragment = new SymptomsSelectDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }

    public void setSymptomsAddedListener(SymptomsAddedListener listener) {
        this.symptomsAddedListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSymptomsSelectDialogListDialogBinding.inflate(inflater, container, false);
        item = getArguments().getParcelable("selected_item_id");

        binding.seekBar.setOnSeekBarChangeListener(severityChangeListener);
        binding.seekBar2.setOnSeekBarChangeListener(durationChangeListener);

        binding.imageView2.setImageResource(item.dbItem.icon);
        binding.seekBar.setProgress(item.severity);
        binding.textView12.setText(String.valueOf(item.severity));
        binding.seekBar2.setProgress(item.symptomsDuration.index);
        binding.textView13.setText(item.symptomsDuration.name());
        binding.textView7.setText(item.dbItem.name);
        binding.textView9.setText(item.dbItem.desc);

        binding.buttonAdd.setOnClickListener(view -> {
            if (symptomsAddedListener != null) {
                symptomsAddedListener.onSymptomsAdded(item);
                dismiss();
            }
        });
        return binding.getRoot();

    }

    private SeekBar.OnSeekBarChangeListener severityChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            item.severity = i;
            binding.textView12.setText(String.valueOf(item.severity));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private SeekBar.OnSeekBarChangeListener durationChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            item.symptomsDuration = SymptomsDuration.values()[binding.seekBar2.getProgress()];
            binding.textView13.setText(item.symptomsDuration.name());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}