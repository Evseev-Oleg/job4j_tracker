package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "6.0.1. Task.",
                "6.0.3. Task.",
                "6.3. Task.",
                "6.5. Task.",
                "6.4.1 Task.",
                "2.3.4. Task."
        };
        String[] out = {
                "2.3.4. Task.",
                "6.0.1. Task.",
                "6.0.3. Task.",
                "6.3. Task.",
                "6.4.1 Task.",
                "6.5. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}