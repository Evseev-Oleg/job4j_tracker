package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa", "a", "aaa");
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return right.length() - left.length();
        };
        list.sort(cmpDescSize);
        System.out.println(list);
    }
}
