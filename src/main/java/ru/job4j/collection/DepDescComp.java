package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        String[] segment1 = str1.split("/");
        String[] segment2 = str2.split("/");
        int rsl = segment2[0].compareTo(segment1[0]);
        if (rsl == 0) {
            return str1.compareTo(str2);
        } else {
            return rsl;
        }
    }
}
