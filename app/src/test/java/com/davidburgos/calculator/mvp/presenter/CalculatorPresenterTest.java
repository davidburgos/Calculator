package com.davidburgos.calculator.mvp.presenter;

import com.davidburgos.calculator.mvp.model.CalculatorModel;
import com.davidburgos.calculator.mvp.model.Operators;
import com.davidburgos.calculator.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CalculatorPresenterTest {

    private @Mock CalculatorModel model;
    private @Mock CalculatorView view;
    private CalculatorPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void calculateOperatorFromSymbol() throws Exception {
        assertEquals(Operators.PLUS, Operators.fromValue("+"));
    }

    @Test
    public void shouldSumTwoValues() throws Exception {
        assertEquals(20, presenter.sum(10, 10));
    }
}
