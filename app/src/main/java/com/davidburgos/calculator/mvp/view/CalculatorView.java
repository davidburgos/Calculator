package com.davidburgos.calculator.mvp.view;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.widget.Toast;

import com.davidburgos.calculator.R;
import com.davidburgos.calculator.util.bus.RxBus;
import com.davidburgos.calculator.util.bus.observers.CalculatorButtonBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorFirstValueBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorOperatorBusObserver;
import com.davidburgos.calculator.util.bus.observers.CalculatorSecondValueBusObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class CalculatorView extends ActivityView {

    @BindView(R.id.calculator_first_value)
    AppCompatEditText firstValue;

    @BindView(R.id.calculator_second_value)
    AppCompatEditText secondValue;

    @BindView(R.id.calculator_operators)
    AppCompatSpinner operators;

    @BindView(R.id.calculator_result)
    AppCompatTextView result;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setResult(String value) {
        this.result.setText(value);
    }

    public void showMessage(@StringRes int messageId) {
        Toast.makeText(getContext(), messageId, Toast.LENGTH_LONG).show();
    }

    @OnItemSelected(R.id.calculator_operators)
    void onItemSelected(AppCompatSpinner spinner, int position) {
        String operatorSelected = (String) spinner.getItemAtPosition(position);
        RxBus.post(new CalculatorOperatorBusObserver.Operator(operatorSelected));
    }

    @OnClick(R.id.calculator_solve_button)
    public void solveButtonPressed() {
        int value = Integer.valueOf(firstValue.getText().toString());
        RxBus.post(new CalculatorFirstValueBusObserver.FirstValue(value));

        value = Integer.valueOf(secondValue.getText().toString());
        RxBus.post(new CalculatorSecondValueBusObserver.SecondValue(value));

        RxBus.post(new CalculatorButtonBusObserver.Solve());
    }
}
