package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        String[] segment1 = str1.split("/");
        String[] segment2 = str2.split("/");
        int len = Math.min(segment1.length, segment2.length);
        if (!segment1[0].equals(segment2[0])) {
            return segment2[0].compareTo(segment1[0]);
        } else if (len == 1) {
            return Integer.compare(segment1.length, segment2.length);
        } else {
            for (int i = 1; i < len; i++) {
                if (!segment1[i].equals(segment2[i])) {
                    return segment1[i].compareTo(segment2[i]);
                }
            }
        }
        return 0;
    }
}
