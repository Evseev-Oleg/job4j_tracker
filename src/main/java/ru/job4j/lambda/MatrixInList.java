package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixInList {

    public List<Integer> converted(Integer[][] mat) {
        return Stream.of(mat).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
