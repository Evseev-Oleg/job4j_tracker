package ru.job4j.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Student {
    private String fullName;
    private int numberGroup;
    private Date dataReceipt;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Date getDataReceipt() {
        return dataReceipt;
    }

    public void setDataReceipt(Date dataReceipt) {
        this.dataReceipt = dataReceipt;
    }
}
