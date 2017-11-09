package com.davidburgos.calculator.util.bus.observers;

public abstract class CalculatorFirstValueBusObserver extends BusObserver<CalculatorFirstValueBusObserver.FirstValue> {
    public CalculatorFirstValueBusObserver() {
        super(CalculatorFirstValueBusObserver.FirstValue.class);
    }

    public static class FirstValue {
        private final int value;

        public FirstValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
