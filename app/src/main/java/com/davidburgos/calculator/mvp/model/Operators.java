package com.davidburgos.calculator.mvp.model;

import android.text.TextUtils;

public enum Operators {

    PLUS("+"),
    UNKNOWN("");

    private String operator = "";

    Operators(String operator) {
        this.operator = operator;
    }

    public static Operators fromValue(String value) {
        for (Operators val : Operators.values()) {
            if (TextUtils.equals(val.operator, value)) {
                return val;
            }
        }

        return UNKNOWN;
    }
}
