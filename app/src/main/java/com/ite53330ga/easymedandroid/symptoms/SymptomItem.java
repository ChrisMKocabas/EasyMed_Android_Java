package com.ite53330ga.easymedandroid.symptoms;

import android.os.Parcel;
import android.os.Parcelable;

import com.ite53330ga.easymedandroid.db.DummyDatabase;
import com.ite53330ga.easymedandroid.utils.SymptomsDuration;

public class SymptomItem implements Parcelable {
    public DummyDatabase.SymptomDbItem dbItem;
    public int severity;
    public SymptomsDuration symptomsDuration;

    public SymptomItem(DummyDatabase.SymptomDbItem dbItem, int severity, SymptomsDuration symptomsDuration) {
        this.dbItem = dbItem;
        this.severity = severity;
        this.symptomsDuration = symptomsDuration;
    }

    protected SymptomItem(Parcel in) {
        severity = in.readInt();
        symptomsDuration = SymptomsDuration.values()[in.readInt()];
        dbItem = in.readParcelable(DummyDatabase.SymptomDbItem.class.getClassLoader());
    }

    public static final Creator<SymptomItem> CREATOR = new Creator<SymptomItem>() {
        @Override
        public SymptomItem createFromParcel(Parcel in) {
            return new SymptomItem(in);
        }

        @Override
        public SymptomItem[] newArray(int size) {
            return new SymptomItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(severity);
        parcel.writeInt(symptomsDuration.index);
        parcel.writeParcelable(dbItem, i);
    }


    @Override
    public String toString() {
        return "SymptomItem{" +
                "dbItem=" + dbItem.id +
                ", severity=" + severity +
                ", symptomsDuration=" + symptomsDuration +
                '}';
    }
}
