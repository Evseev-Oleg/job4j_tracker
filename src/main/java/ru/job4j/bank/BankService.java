package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс описывающий функции банка по работе с клиентами и со счетами клиентов
 *
 * @author OLEG EVSEEV
 * @version 1.0
 */
public class BankService {
    /**
     * хранение данных по акааунту осуществляется по принципу ключ-значение,
     * в коллекии HashMap. Ключ это паспорт клиента, значение это список ArrayList
     * состоящий из реквизитов по счетам данного клиента
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет нового клиента в базу (пока с пустым листом счетов)
     *
     * @param user;
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод добавления клиенту нового счета
     *
     * @param passport;
     * @param account;
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> account1 = users.get(user);
            if (!account1.contains(account)) {
                account1.add(account);
            }
        }
    }

    /**
     * метод поиска клиента в базе по номеру паспорта
     *
     * @param passport;
     * @return User;
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * поиск аккаунта по номеру паспорта и рнквизитам клиента
     *
     * @param passport;
     * @param requisite;
     * @return Account;
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод для передвижения денежных средств между клиентами и счетами банка
     *
     * @param srcPassport;
     * @param srcRequisite;
     * @param destPassport;
     * @param destRequisite;
     * @param amount;
     * @return rsl;
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            src.setBalance(src.getBalance() - amount);
            return true;
        }
        return rsl;
    }
}
