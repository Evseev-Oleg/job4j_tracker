package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all Item ===");
        List<Item> elems = tracker.findAll();
        for (Item elem : elems) {
            out.println(elem);
        }
        return true;
    }
}
