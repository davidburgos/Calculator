package com.davidburgos.calculator.mvp.presenter;

import com.davidburgos.calculator.mvp.model.CalculatorModel;
import com.davidburgos.calculator.mvp.model.Operators;
import com.davidburgos.calculator.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class CalculatorPresenterTest {

    private @Mock CalculatorModel model;
    private @Mock CalculatorView view;
    private CalculatorPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void calculateOperatorFromSymbol() throws Exception {
        assertEquals(Operators.PLUS, Operators.fromValue("+"));
    }

    @Test
    public void shouldShowMessageWhenOperatorIsUnknown() throws Exception {
        when(model.getOperator()).thenReturn(Operators.UNKNOWN);
        presenter.onSolveButtonPressed();
        verify(view).showMessage(anyInt());
        verify(view, never()).setResult(anyString());
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldReturnSumOfTwoIntValues() throws Exception {
        when(model.getOperator()).thenReturn(Operators.PLUS);
        when(model.getFirstValue()).thenReturn(10);
        when(model.getSecondValue()).thenReturn(20);
        presenter.onSolveButtonPressed();
        verify(view).setResult("30");
        verifyNoMoreInteractions(view);
    }
}
