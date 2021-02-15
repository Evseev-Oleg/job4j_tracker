package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FunctionRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearThenLinearResults() {
        List<Double> result = FunctionRange.diapason(4, 7, x -> x);
        List<Double> expected = Arrays.asList(4D, 5D, 6D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunThenLinearResults() {
        List<Double> result = FunctionRange.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFuncThenLinearResults() {
        List<Double> result = FunctionRange.diapason(5, 8, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(3125D, 46656D, 823543D);
        assertThat(result, is(expected));
    }
}
