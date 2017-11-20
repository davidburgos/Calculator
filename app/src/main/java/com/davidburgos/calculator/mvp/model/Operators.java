package com.davidburgos.calculator.mvp.model;

public enum Operators {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    UNKNOWN("");

    private String operator = "";

    Operators(String operator) {
        this.operator = operator;
    }

    public static Operators fromValue(String value) {
        for (Operators val : Operators.values()) {
            if (val.operator.equals(value)) {
                return val;
            }
        }

        return UNKNOWN;
    }
}
