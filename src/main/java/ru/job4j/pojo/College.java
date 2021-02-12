package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Евсеев Олег Владимирович");
        student.setNumberGroup(2);
        student.setDataReceipt(new Date());
        System.out.println("Student name: " + student.getFullName() + ", group number: "
                + student.getNumberGroup() + ", date of receipt: " + student.getDataReceipt());
    }
}
