package ru.job4j.tracker.Input;


import org.junit.Test;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput2() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "1", "5", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenInvalidInput3() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-5", "1", "5", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-5));
    }
}