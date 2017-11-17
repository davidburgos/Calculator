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

    private static final float ZERO_FLOAT = 0F;
    private static final float FIRST_FLOAT_VALUE = 10F;
    private static final float SECOND_FLOAT_VALUE = 10F;
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
        assertEquals(Operators.DIVIDE, Operators.fromValue("/"));
    }

    @Test
    public void shouldSumOfTwoIntValues() throws Exception {
        when(model.getOperator()).thenReturn(Operators.PLUS);
        when(model.getFirstValue()).thenReturn(FIRST_FLOAT_VALUE);
        when(model.getSecondValue()).thenReturn(SECOND_FLOAT_VALUE);
        presenter.onSolveButtonPressed();
        verify(view).setResult(String.valueOf(FIRST_FLOAT_VALUE + SECOND_FLOAT_VALUE));
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldSubtractTwoIntValues() throws Exception {
        when(model.getOperator()).thenReturn(Operators.MINUS);
        when(model.getFirstValue()).thenReturn(FIRST_FLOAT_VALUE);
        when(model.getSecondValue()).thenReturn(SECOND_FLOAT_VALUE);
        presenter.onSolveButtonPressed();
        verify(view).setResult(String.valueOf(FIRST_FLOAT_VALUE - SECOND_FLOAT_VALUE));
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldMultiplyTwoIntValues() throws Exception {
        when(model.getOperator()).thenReturn(Operators.MULTIPLY);
        when(model.getFirstValue()).thenReturn(FIRST_FLOAT_VALUE);
        when(model.getSecondValue()).thenReturn(SECOND_FLOAT_VALUE);
        presenter.onSolveButtonPressed();
        verify(view).setResult(String.valueOf(FIRST_FLOAT_VALUE * SECOND_FLOAT_VALUE));
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDivideTwoIntValues() throws Exception {
        when(model.getOperator()).thenReturn(Operators.DIVIDE);
        when(model.getFirstValue()).thenReturn(FIRST_FLOAT_VALUE);
        when(model.getSecondValue()).thenReturn(SECOND_FLOAT_VALUE);
        presenter.onSolveButtonPressed();
        verify(view).setResult(String.valueOf(FIRST_FLOAT_VALUE / SECOND_FLOAT_VALUE));
        verifyNoMoreInteractions(view);
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
    public void shouldShowMessageWhenSecondValueIsZero() throws Exception {
        when(model.getOperator()).thenReturn(Operators.DIVIDE);
        when(model.getFirstValue()).thenReturn(FIRST_FLOAT_VALUE);
        when(model.getSecondValue()).thenReturn(ZERO_FLOAT);
        presenter.onSolveButtonPressed();
        verify(view).showMessage(anyInt());
        verify(view).setResult(anyString());
        verifyNoMoreInteractions(view);
    }
}
