package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.*;

public interface BankService {
    /**
     *
     * @param name - имя банка
     * @return - возвращает созданный объект банк
     */
    Bank create(String name);

    /**
     * выводит на экран информацию о банке с данным id
     * @param id - id банка
     */
    void outputBankInfo(Bank bank);

    void addAtm(Bank bank, BankAtm bankatm);

    void addOffice(Bank bank, BankOffice bankOffice);

    void addEmployee(Bank bank, Employee employee);

    void addUser(Bank bank, User user);

    void delAtm(Bank bank, BankAtm bankatm);

    void delOffice(Bank bank, BankOffice bankOffice);

    void delEmployees(Bank bank, Employee employee);

    void delUser(Bank bank, User user);

}
