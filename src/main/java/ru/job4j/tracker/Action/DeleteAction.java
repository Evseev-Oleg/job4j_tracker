package ru.job4j.tracker.Action;

import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item by Id ===");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            System.out.println("Успешно удалено");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
