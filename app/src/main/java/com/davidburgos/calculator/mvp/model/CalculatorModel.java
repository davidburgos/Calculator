package com.davidburgos.calculator.mvp.model;

public class CalculatorModel {

    private int firstValue = 0;
    private int secondValue = 0;
    private Operators operator = Operators.UNKNOWN;

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public Operators getOperator() {
        return operator;
    }

    public void setOperator(Operators operator) {
        this.operator = operator;
    }
}
