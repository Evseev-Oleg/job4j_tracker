package ru.job4j.tracker.Action;

import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Tracker;

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
        Item[] elems = tracker.findAll();
        for (Item elem : elems) {
            System.out.println(elem);
        }
        return true;
    }
}
