package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Action.*;
import ru.job4j.tracker.Input.Input;
import ru.job4j.tracker.Input.StubInput;
import ru.job4j.tracker.Output.Output;
import ru.job4j.tracker.Output.StubOutput;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


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
        tracker.add(new Item("Add item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new Exit(output)
        };
        String expected = "Menu." + System.lineSeparator() +
                "0. Find all" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Find all Item ===" + System.lineSeparator() +
                "Item{id=1, name='Add item'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find all" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Exit ===" + System.lineSeparator();
        new StartUI(output).init(in, tracker, actions);
        Assert.assertEquals(expected, output.toString());
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
        String expected = "Menu." + System.lineSeparator() +
                "0. Find by Id" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Find Item by Id ===" + System.lineSeparator() +
                "Item{id=1, name='Add item'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find by Id" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Exit ===" + System.lineSeparator();
        new StartUI(output).init(in, tracker, actions);
        Assert.assertEquals(expected, output.toString());
    }

    @Test
    public void whenFindByNameItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Add item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new Exit(output)
        };
        String expected = "Menu." + System.lineSeparator() +
                "0. Find by name" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Find by name Item ===" + System.lineSeparator() +
                "Item{id=1, name='Add item'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find by name" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Exit ===" + System.lineSeparator();
        new StartUI(output).init(in, tracker, actions);
        Assert.assertEquals(expected, output.toString());
    }
}