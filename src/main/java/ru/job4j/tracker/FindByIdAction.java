package ru.job4j.tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by Id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElse(item, "Заявка с таким id не найдена"));
        return true;
    }
}
