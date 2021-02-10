package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByIdAscending implements Comparator<Item> {

    @Override
    public int compare(Item a, Item b) {
//        return Integer.compare(a.getId(), b.getId());
        return a.getId() - b.getId();
    }
}
