package com.davidburgos.calculator.util.bus.observers;

public abstract class CalculatorValueBusObserver extends BusObserver<CalculatorValueBusObserver.Value> {
    protected CalculatorValueBusObserver() {
        super(Value.class);
    }

    public static class Value {
        private final int value;
        private final int position;

        public Value(int value, int position) {
            this.value = value;
            this.position = position;
        }

        public int getPosition() {
            return position;
        }

        public int getValue() {
            return value;
        }
    }
}
