package com.ite53330ga.easymedandroid.symptoms;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ite53330ga.easymedandroid.R;
import com.ite53330ga.easymedandroid.databinding.ActivitySymptomsBinding;
import com.ite53330ga.easymedandroid.databinding.ItemSearchQueryBinding;
import com.ite53330ga.easymedandroid.db.DummyDatabase;
import com.ite53330ga.easymedandroid.diagnostics.DiagnosticsActivity;
import com.ite53330ga.easymedandroid.utils.AbsActivity;
import com.ite53330ga.easymedandroid.utils.SymptomsDuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SymptomsActivity extends AbsActivity {
    private ActivitySymptomsBinding mBinding;
    private final ArrayList<Pair<Boolean, SymptomItem>> dbItems = new ArrayList<>();
    private DummyDatabase dummyDatabase = new DummyDatabase();
    private SearchItemAdapter itemAdapter = new SearchItemAdapter();
    private boolean isHeaderExpanded = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySymptomsBinding.inflate(getLayoutInflater());

        mBinding.btnDiagnose.setOnClickListener(view -> {
           SymptomItem[] selected = dbItems.stream()
                    .filter(item -> item.first).map(item -> item.second).toArray(SymptomItem[]::new);
           SymptomsIntentBundle intentBundle = new SymptomsIntentBundle(selected);
           Intent i = new Intent(SymptomsActivity.this, DiagnosticsActivity.class);
           i.putExtra(SymptomsIntentBundle.INTENT_TAG, intentBundle);
            startActivity(i);
        });

        mBinding.editSearchSymp.setOnFocusChangeListener((view, b) -> {
            if (b && isHeaderExpanded) {
                mBinding.group.setVisibility(View.GONE);
                animateTextSizeChange();
                isHeaderExpanded = true;
            }
        });

        prepareItemList(null);

        mBinding.editSearchSymp.addTextChangedListener(new SearchTextWatcher());

        mBinding.recyclerSearch.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerSearch.hasFixedSize();
        mBinding.recyclerSearch.setAdapter(itemAdapter);
        setContentView(mBinding.getRoot());
    }

    private void prepareItemList(ArrayList<SymptomItem> selectedItem) {
        dbItems.addAll(
                dummyDatabase.getDummyData()
                        .stream()
                        .map(symptomDbItem -> new Pair<>(false, new SymptomItem(symptomDbItem, 0, SymptomsDuration.DAY))).collect(Collectors.toList())
        );

    }

    @Override
    public void loadDataFromBundle(SymptomsIntentBundle symptomsIntentBundle) {

    }

    @Override
    public void initUI() {

    }

    class SearchTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable.toString())) {
                mBinding.textSelectedIndicator.setVisibility(View.GONE);
                itemAdapter.setCurrentItemsToPopulate(
                        dbItems.stream()
                                .filter(item ->
                                        item.second.dbItem.name.toLowerCase(Locale.ROOT).contains(editable.toString().toLowerCase(Locale.ROOT))
                                ).collect(Collectors.toList())
                );
            } else {
                mBinding.textSelectedIndicator.setVisibility(View.VISIBLE);
                itemAdapter.setCurrentItemsToPopulate(dbItems.stream()
                        .filter(item -> item.first).collect(Collectors.toList()));
            }
        }
    }

    class SearchItemAdapter extends RecyclerView.Adapter<SearchItemHolder> {
        ArrayList<Pair<Boolean, SymptomItem>> currentItemsToPopulate = new ArrayList<>();

        @NonNull
        @Override
        public SearchItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SearchItemHolder(ItemSearchQueryBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull SearchItemHolder holder, int position) {
            holder.setItemDat(currentItemsToPopulate.get(position), position);
        }

        @Override
        public int getItemCount() {
            return currentItemsToPopulate.size();
        }

        void setCurrentItemsToPopulate(List<Pair<Boolean, SymptomItem>> list) {
            currentItemsToPopulate.clear();
            this.currentItemsToPopulate.addAll(list);
            notifyDataSetChanged();
        }

        void updateItemStatus(int position, boolean isSelected) {
            currentItemsToPopulate.set(position, new Pair<>(isSelected, currentItemsToPopulate.get(position).second));
            notifyItemChanged(position);
        }
    }

    class SearchItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemSearchQueryBinding binding;
        Pair<Boolean, SymptomItem> itemData;
        int position;

        public SearchItemHolder(@NonNull ItemSearchQueryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        void setItemDat(Pair<Boolean, SymptomItem> itemData, int position) {
            this.itemData = itemData;
            this.position = position;
            binding.imageSearch.setImageResource(itemData.second.dbItem.icon);
            binding.textTitle.setText(itemData.second.dbItem.name);
            binding.textSelected.setVisibility(itemData.first ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            boolean newStatus = !itemData.first;
            if (newStatus) {

                Bundle b = new Bundle();
                b.putParcelable("selected_item_id", itemData.second);

                SymptomsSelectDialogFragment symptomsSelectDialogFragment = new SymptomsSelectDialogFragment();
                symptomsSelectDialogFragment.setArguments(b);
                symptomsSelectDialogFragment.setSymptomsAddedListener(new SymptomsAddedListenerAdapter(position));
                symptomsSelectDialogFragment.show(getSupportFragmentManager(), "sdads");
            } else {
                updateSymptomState(position, itemData.second, false);
            }
        }

    }

    class SymptomsAddedListenerAdapter implements SymptomsAddedListener {
        int pos;

        public SymptomsAddedListenerAdapter(int pos) {
            this.pos = pos;
        }

        @Override
        public void onSymptomsAdded(SymptomItem updatedSymptomItem) {
            updateSymptomState(pos, updatedSymptomItem, true);

            Toast.makeText(SymptomsActivity.this, updatedSymptomItem.dbItem.name + " added", Toast.LENGTH_LONG).show();
        }
    }

    private void updateSymptomState(int position, SymptomItem updatedSymptomItem, boolean isSelected) {

        itemAdapter.updateItemStatus(position, isSelected);

        int selectedCount = 0;
        for (int i = 0; i < dbItems.size(); i++) {
            Pair<Boolean, SymptomItem> item = dbItems.get(i);
            if (item.second.dbItem.id == updatedSymptomItem.dbItem.id) {
                dbItems.set(i, new Pair<>(isSelected, updatedSymptomItem));
            }

            if (dbItems.get(i).first) {
                selectedCount++;
            }
        }

        if (selectedCount > 0) {
            mBinding.btnDiagnose.setVisibility(View.VISIBLE);
        } else {
            mBinding.btnDiagnose.setVisibility(View.GONE);

        }

    }

    private void animateTextSizeChange() {
        float startSize = getResources().getDimension(R.dimen.title_expanded_size);
        float endSize = getResources().getDimension(R.dimen.title_collapsed_size);

        ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
        animator.addUpdateListener(valueAnimator -> {
//            if (Build.VERSION.SDK_INT >= 26) {
//                mBinding.textView2.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_NONE);
//                mBinding.textView3.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_NONE);
//            }
            mBinding.textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, (Float) valueAnimator.getAnimatedValue());
            mBinding.textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, (Float) valueAnimator.getAnimatedValue());

        });

        animator.start();
    }
}