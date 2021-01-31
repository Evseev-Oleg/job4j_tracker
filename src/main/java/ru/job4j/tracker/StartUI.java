package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItem(Tracker tracker) {
        System.out.println("===Show all Item===");
        Item[] elems = tracker.findAll();
        for (Item elem : elems) {
            System.out.println(elem);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("===Change Item by Id===");
        int id = input.askInt("Введите id: ");
        Item item = new Item(input.askStr("Введите название: "));
        if (tracker.replace(id, item)) {
            System.out.println("Успешно изменено ");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("===Delete Item by Id===");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            System.out.println("Успешно удалено");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("===Find Item by Id===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("===Find Item by name Item===");
        String name = input.askStr("Введите название: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items
            ) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {
        Input input = new ConsoleInp();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
