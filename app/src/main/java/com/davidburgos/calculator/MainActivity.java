package com.davidburgos.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davidburgos.calculator.mvp.model.CalculatorModel;
import com.davidburgos.calculator.mvp.presenter.CalculatorPresenter;
import com.davidburgos.calculator.mvp.view.CalculatorView;

public class MainActivity extends AppCompatActivity {

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregister();
    }
}
