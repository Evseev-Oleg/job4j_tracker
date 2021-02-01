package ru.job4j.ex;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCalcException() {
        Fact fact = new Fact();
        fact.calc(-4);
    }

    @Test
    public void testCalc() {
        Fact fact = new Fact();
        assertThat(Integer.parseInt(fact.calc(4)),is(24));
    }
}