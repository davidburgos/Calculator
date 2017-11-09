package com.davidburgos.calculator.util.bus.observers;

public abstract class CalculatorButtonBusObserver extends BusObserver<CalculatorButtonBusObserver.Solve> {
    protected CalculatorButtonBusObserver() {
        super(Solve.class);
    }

    public static class Solve {
    }
}
