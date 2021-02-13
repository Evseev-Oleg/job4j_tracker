package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        String[] segment1 = str1.split("\\.");
        String[] segment2 = str2.split("\\.");
        int number1 = Integer.parseInt(segment1[0]);
        int number2 = Integer.parseInt(segment2[0]);
        return Integer.compare(number1, number2);
    }
}
