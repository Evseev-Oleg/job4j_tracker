package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByIdDescending implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return b.getId() - a.getId();
    }
}
