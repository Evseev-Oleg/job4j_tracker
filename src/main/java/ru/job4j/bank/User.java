package ru.job4j.bank;

import java.util.Objects;

/**
 * класс описывает клиента банка
 *
 * @author OLEG EVSEEV
 * @version 1.0
 */
public class User {
    /**
     * приватные поля: паспорт и имя
     */
    private String passport;
    private String username;

    /**
     * имеет один конструктор с двумя параметрами
     *
     * @param passport
     * @param username
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * метод прлучения данных паспорта
     *
     * @return
     */
    public String getPassport() {
        return passport;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * переопределение метода hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
