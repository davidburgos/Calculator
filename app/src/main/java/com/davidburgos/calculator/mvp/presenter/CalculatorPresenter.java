package com.davidburgos.calculator.mvp.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.davidburgos.calculator.R;
import com.davidburgos.calculator.mvp.model.CalculatorModel;
import com.davidburgos.calculator.mvp.model.Operators;
import com.davidburgos.calculator.mvp.view.CalculatorView;
import com.davidburgos.calculator.util.bus.RxBus;
import com.davidburgos.calculator.util.bus.observers.CalculatorButtonBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorFirstValueBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorOperatorBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorSecondValueBusObserver;

public class CalculatorPresenter {

    private static final int UNKNOWN_OPERATOR = -1;
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    private void onSolveButtonPressed() {

        int result = UNKNOWN_OPERATOR;

        switch (model.getOperator()) {
            case PLUS:
                result = model.getFirstValue() + model.getSecondValue();
                break;
            case UNKNOWN:
                view.showMessage(R.string.error_operator_unknown);
                return;
        }
        view.setResult(String.valueOf(result));
    }

    private void onFirstValueChange(int value) {
        model.setFirstValue(value);
    }

    private void onSecondValueChange(int value) {
        model.setSecondValue(value);
    }

    private void onOperatorChange(String newOperator) {
        if (!TextUtils.isEmpty(newOperator)) {
            model.setOperator(Operators.fromValue(newOperator));
        } else {
            model.setOperator(Operators.UNKNOWN);
        }
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }

        RxBus.subscribe(activity, new CalculatorButtonBusObserver() {
            @Override
            public void onEvent(CalculatorButtonBusObserver.Solve value) {
                onSolveButtonPressed();
            }
        });

        RxBus.subscribe(activity, new CalculatorOperatorBusObserver() {
            @Override
            public void onEvent(CalculatorOperatorBusObserver.Operator value) {
                onOperatorChange(value.getOperator());
            }
        });

        RxBus.subscribe(activity, new CalculatorFirstValueBusObserver() {
            @Override
            public void onEvent(CalculatorFirstValueBusObserver.FirstValue value) {
                onFirstValueChange(value.getValue());
            }
        });

        RxBus.subscribe(activity, new CalculatorSecondValueBusObserver() {
            @Override
            public void onEvent(CalculatorSecondValueBusObserver.SecondValue value) {
                onSecondValueChange(value.getValue());
            }
        });
    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }
}
