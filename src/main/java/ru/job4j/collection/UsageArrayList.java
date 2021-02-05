package ru.job4j.collection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UsageArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        for (String value : list
        ) {
            System.out.println(value);
        }
    }
}
