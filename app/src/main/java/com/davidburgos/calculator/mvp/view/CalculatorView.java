package com.davidburgos.calculator.mvp.view;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Toast;

import com.davidburgos.calculator.R;
import com.davidburgos.calculator.util.bus.RxBus;
import com.davidburgos.calculator.util.bus.observers.CalculatorButtonBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorOperatorBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorValueBusObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;

public class CalculatorView extends ActivityView {

    @BindView(R.id.calculator_operators)
    AppCompatSpinner operators;

    @BindView(R.id.calculator_result)
    AppCompatTextView result;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setResult(String value) {
        result.setText(value);
    }

    public void showMessage(@StringRes int messageId) {
        Toast.makeText(getContext(), messageId, Toast.LENGTH_LONG).show();
    }

    @OnItemSelected(R.id.calculator_operators)
    void onItemSelected(AppCompatSpinner spinner, int position) {
        String operatorSelected = (String) spinner.getItemAtPosition(position);
        RxBus.post(new CalculatorOperatorBusObserver.Operator(operatorSelected));
    }

    @OnTextChanged(R.id.calculator_first_value)
    public void onFirstValueChange(Editable textValue) {
        if (!TextUtils.isEmpty(textValue)) {
            int value = Integer.valueOf(textValue.toString());
            RxBus.post(new CalculatorValueBusObserver.Value(value, 1));
        } else {
            RxBus.post(new CalculatorValueBusObserver.Value(0, 1));
        }
    }

    @OnTextChanged(R.id.calculator_second_value)
    public void onSecondValueChange(Editable textValue) {
        if (!TextUtils.isEmpty(textValue)) {
            int value = Integer.valueOf(textValue.toString());
            RxBus.post(new CalculatorValueBusObserver.Value(value, 2));
        } else {
            RxBus.post(new CalculatorValueBusObserver.Value(0, 2));
        }
    }

    @OnClick(R.id.calculator_solve_button)
    public void solveButtonPressed() {
        RxBus.post(new CalculatorButtonBusObserver.Solve());
    }
}
