package com.davidburgos.calculator.util.bus.observers;

public abstract class StringBusObserver extends BusObserver<String> {
    public StringBusObserver() {
        super(String.class);
    }
}
