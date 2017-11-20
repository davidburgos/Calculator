package com.davidburgos.calculator.util.bus.observers;

public abstract class CalculatorOperatorBusObserver extends BusObserver<CalculatorOperatorBusObserver.Operator> {
    protected CalculatorOperatorBusObserver() {
        super(CalculatorOperatorBusObserver.Operator.class);
    }

    public static class Operator {
        private String operator = "";

        public Operator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }
    }
}
