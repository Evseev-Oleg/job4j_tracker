package ru.job4j.tracker.Action;

import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Tracker;

public class Exit implements UserAction {
    private final Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit ===");
        return false;
    }
}
