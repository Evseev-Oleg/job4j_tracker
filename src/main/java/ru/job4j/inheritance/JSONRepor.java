package ru.job4j.inheritance;

public class JSONRepor extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator() + "name : " + name
                + "," + System.lineSeparator() + "body : " + body + System.lineSeparator() + "}";
    }
}
