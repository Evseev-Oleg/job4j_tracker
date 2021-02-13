package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет в банке
 *
 * @author OLEG EVSEEV
 * @version 1.0
 */
public class Account {
    /**
     * содержит private поля: реквизиты и баланс
     */
    private String requisite;
    private double balance;

    /**
     * имеет один констркутор с двумя полями
     *
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * метод для получения реквизитов счета
     *
     * @return
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * метод для получения баланса счета
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * метод для работы с балансом счета
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * переопределения метода equals
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределение метода hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
