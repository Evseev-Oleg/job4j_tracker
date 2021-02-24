package ru.job4j.bank;

import java.util.*;
import java.util.Optional;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> account1 = users.get(user.get());
            if (!account1.contains(account)) {
                account1.add(account);
            }
        }
    }

    /**
     * метод поиска клиента в базе по номеру паспорта
     *
     * @param passport ;
     * @return User;
     */

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * поиск аккаунта по номеру паспорта и рнквизитам клиента
     *
     * @param passport  ;
     * @param requisite ;
     * @return Account;
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> acc = Optional.empty();
        return user.map(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst()).orElse(acc);
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            return true;
        }
        return rsl;
    }
}
