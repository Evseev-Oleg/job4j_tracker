package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private int score;
    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(score, surname);
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", surname='" + surname + '\''
                + '}';
    }

    public static void main(String[] args) {
        Map<String, Student> map;
        List<Student> students = Arrays.asList(new Student(1, "Петров"),
                new Student(2, "Иванов"),
                new Student(3, "Сидоров"));
        map = students.stream().collect(Collectors.toMap(Student::getSurname,
                s -> s, (f, s) -> f.equals(s) ? f : s));
        System.out.println(map);
    }
}
