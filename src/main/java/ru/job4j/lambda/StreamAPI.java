package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,54,8,9,51,23,90);
        list = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(list);
    }
}
