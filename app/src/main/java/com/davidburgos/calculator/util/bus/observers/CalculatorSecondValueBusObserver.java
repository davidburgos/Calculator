package com.davidburgos.calculator.util.bus.observers;

public abstract class CalculatorSecondValueBusObserver extends BusObserver<CalculatorSecondValueBusObserver.SecondValue> {
    public CalculatorSecondValueBusObserver() {
        super(SecondValue.class);
    }

    public static class SecondValue {
        private final int value;

        public SecondValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
