package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        int idItem = tracker.add(new Item()).getId();
        System.out.println(tracker.findById(idItem));

//        Item item = new Item();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//        String currentDateTimeFormat = item.getCreated().format(formatter);
//        System.out.println(currentDateTimeFormat);
    }
}
