package ru.job4j.tracker.Action;

import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output.Output;
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
        int id = input.askInt("Введите id: ");
        Item item = new Item(input.askStr("Введите название: "));
        if (tracker.replace(id, item)) {
            System.out.println("Успешно изменено ");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
