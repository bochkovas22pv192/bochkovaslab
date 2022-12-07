package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.Bank;

import java.util.List;

public interface BankService {
    /**
     *
     * @param name - имя банка
     * @return - возвращает созданный объект банк
     */
    Bank create(String name);

    /**
     *
     * @return список всех банков
     */
    List<Bank> findAll();

    /**
     * добавляет банк в коллекцию
     * @param bank - банк
     */
    void addBank(Bank bank);

    /**
     *
     * @param id - id банка
     * @return банк с данным id или null
     */
    Bank getBankById(Long id);

    /**
     * удаляет банк по id
     * @param id - id банка
     */
    void delBankById(Long id);

    /**
     * выводит на экран информацию о банке с данным id
     * @param id - id банка
     */
    void outputBankInfo(Long id);
}
