package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> students1;
        students1 = students.stream().filter(predict).collect(Collectors.toList());
        return students1;
    }
}
