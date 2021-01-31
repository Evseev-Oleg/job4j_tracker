package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            System.out.println("Успешно удалено");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
