package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Action.*;
import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Input.StubInput;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Output.StubOutput;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;


public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAllItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Add item"));
        Input in = new StubInput(
                new String[]{"0","1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(),is("Menu.\\r\\n0. Find all\\r\\n1. Exit\\r\\n=== Find all Item ===\\r\\nItem{id=1, name='Add item'}\\r\\nMenu.\\r\\n0. Find all\\r\\n1. Exit\\r\\n=== Exit ===\\r\\n"));
    }

    @Test
    public void whenFindByIdItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Add item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu.\\r\\n0. Find by name\\r\\n1. Exit\\r\\n=== Find Item by name Item ===\\r\\nЗаявки с таким именем не найдены\\r\\nMenu.\\r\\n0. Find by name\\r\\n1. Exit\\r\\n=== Exit ===\\r\\n"));
    }

    @Test
    public void whenFindByNameItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Add item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu.\\r\\n0. Find by name\\r\\n1. Exit\\r\\n=== Find Item by name Item ===\\r\\nЗаявки с таким именем не найдены\\r\\nMenu.\\r\\n0. Find by name\\r\\n1. Exit\\r\\n=== Exit ===\\r\\n"));
    }
}