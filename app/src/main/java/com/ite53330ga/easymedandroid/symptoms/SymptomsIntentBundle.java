package com.ite53330ga.easymedandroid.symptoms;


import android.os.Parcel;
import android.os.Parcelable;

public class SymptomsIntentBundle implements Parcelable {
    public static String INTENT_TAG = "intent_bundle";
    SymptomItem[] selected;

    public SymptomsIntentBundle(SymptomItem[] selected) {
        this.selected = selected;
    }

    protected SymptomsIntentBundle(Parcel in) {
        selected = in.createTypedArray(SymptomItem.CREATOR);
    }

    public static final Creator<SymptomsIntentBundle> CREATOR = new Creator<SymptomsIntentBundle>() {
        @Override
        public SymptomsIntentBundle createFromParcel(Parcel in) {
            return new SymptomsIntentBundle(in);
        }

        @Override
        public SymptomsIntentBundle[] newArray(int size) {
            return new SymptomsIntentBundle[size];
        }
    };

    public SymptomItem[] getSelected() {
        return selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(selected, i);
    }
}
