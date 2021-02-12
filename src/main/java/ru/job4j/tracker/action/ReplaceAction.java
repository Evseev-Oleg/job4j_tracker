package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace Item by Id ===");
        int id = input.askInt("Enter id: ");
        Item item = new Item(input.askStr("Enter name: "));
        if (tracker.replace(id, item)) {
            out.println("Успешно изменено ");
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
