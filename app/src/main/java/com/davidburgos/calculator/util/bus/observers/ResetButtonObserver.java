package com.davidburgos.calculator.util.bus.observers;

public abstract class ResetButtonObserver extends BusObserver<ResetButtonObserver.ResetButtonPressed> {
    public ResetButtonObserver() {
        super(ResetButtonPressed.class);
    }

    public static class ResetButtonPressed {
    }
}