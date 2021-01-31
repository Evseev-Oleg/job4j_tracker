package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] elems = tracker.findAll();
        for (Item elem : elems) {
            System.out.println(elem);
        }
        return true;
    }
}
