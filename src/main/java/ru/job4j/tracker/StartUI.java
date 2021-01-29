package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        int idItem = tracker.add(new Item()).getId();
        System.out.println(tracker.findById(idItem));
    }

}
