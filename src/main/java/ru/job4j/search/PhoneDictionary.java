package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> predPhone = x -> x.getPhone().contains(key);
        Predicate<Person> predName = x -> x.getName().contains(key);
        Predicate<Person> predSurname = x -> x.getSurname().contains(key);
        Predicate<Person> predAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = predPhone.or(predName).or(predSurname).or(predAddress);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
