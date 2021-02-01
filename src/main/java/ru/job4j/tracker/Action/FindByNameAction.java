package ru.job4j.tracker.Action;

import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by name Item ===");
        String name = input.askStr("Введите название: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items
            ) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
