package com.davidburgos.calculator.mvp.model;

public class CalculatorModel {

    private static final float ZERO_FLOAT = 0F;
    private float firstValue = ZERO_FLOAT;
    private float secondValue = ZERO_FLOAT;
    private Operators operator = Operators.UNKNOWN;

    public float getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(float firstValue) {
        this.firstValue = firstValue;
    }

    public float getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(float secondValue) {
        this.secondValue = secondValue;
    }

    public Operators getOperator() {
        return operator;
    }

    public void setOperator(Operators operator) {
        this.operator = operator;
    }
}
