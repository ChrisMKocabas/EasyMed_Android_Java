package com.ite53330ga.easymedandroid.utils;

public enum SymptomsDuration {
    DAY(0), LESS_THAN_WEEK(1), LESS_THAN_MONTH(2), LONG_TERM(3), LIFE_LONG(4);
    public int index;

    SymptomsDuration(int index) {
        this.index = index;
    }

}
