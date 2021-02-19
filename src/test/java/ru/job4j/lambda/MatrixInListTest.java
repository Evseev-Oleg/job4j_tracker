package ru.job4j.lambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixInListTest {
    @Test
    public void converted() {
        MatrixInList matrixInList = new MatrixInList();
        Integer[][] mat = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> value = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(matrixInList.converted(mat), is(value));
    }
}