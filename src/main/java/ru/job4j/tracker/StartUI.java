package ru.job4j.tracker;

import ru.job4j.tracker.Action.*;
import ru.job4j.tracker.Input.ConsoleInput;
import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Output.ConsoleOutput;
import ru.job4j.tracker.Output.Output;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new FindAllAction(output), new ReplaceAction(output), new DeleteAction(output),
                new FindByIdAction(output), new FindByNameAction(output), new Exit(output)
        };
        new StartUI().init(input, tracker, actions);
    }
}
