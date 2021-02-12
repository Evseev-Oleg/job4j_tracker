package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
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
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Успешно удалено");
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
