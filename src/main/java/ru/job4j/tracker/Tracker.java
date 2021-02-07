package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private static Tracker tracker;

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }


    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsWithoutNull = new ArrayList<>();
        int size = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsWithoutNull.add(item);
                size++;
            }
        }
        return itemsWithoutNull;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean res = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            res = true;
        }
        return res;
    }

    public boolean delete(int id) {
        boolean res = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            res = true;
        }
        return res;
    }
}