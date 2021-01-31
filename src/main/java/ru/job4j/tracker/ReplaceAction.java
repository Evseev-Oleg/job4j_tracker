package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Change Item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
