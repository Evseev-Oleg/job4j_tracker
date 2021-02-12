package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        String[] segment1 = str1.split("\\.");
        String[] segment2 = str2.split("\\.");
        int number1 = Integer.parseInt(segment1[0]);
        int number2 = Integer.parseInt(segment2[0]);
        for (int i = 0; i < segment1.length; i++) {
            if (segment1[i].matches("[0-9]+") && segment2[i].matches("[0-9]+")) {
                number1 = Integer.parseInt(segment1[i]);
                number2 = Integer.parseInt(segment2[i]);
                if (number1 != number2) {
                    return Integer.compare(number1, number2);
                }
            } else if (segment1[i].matches("[0-9]+") || segment2[i].matches("[0-9]+")) {
                if (segment1[i].matches("[0-9]+")) {
                    return Integer.compare(number1, 0);
                } else {
                    return Integer.compare(0, number2);
                }
            } else {
                break;
            }
        }
        return Integer.compare(number1, number2);
    }
}
