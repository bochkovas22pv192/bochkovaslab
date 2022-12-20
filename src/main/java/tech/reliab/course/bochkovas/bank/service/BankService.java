package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.*;

import java.util.List;

public interface BankService {
    /**
     *
     * @param name - имя банка
     * @return - возвращает созданный объект банк
     */
    Bank create(String name);

    /**
     * выводит на экран информацию о банке с данным id
     * @param bank - банк
     */
    void outputBankInfo(Bank bank);

    /**
     * Добавляет офис в банк
     * @param bank - банк
     * @param office - офис
     */
    void addOffice(Bank bank, BankOffice office);

    /**
     * Удаляет офис из банка
     * @param bank - банк
     * @param office - офис
     */
    void deleteOffice(Bank bank, BankOffice office);

    /**
     * Добавляет банкомат в банк
     * @param bank - банк
     * @param atm - банкомат
     */
    void addAtm(Bank bank, BankAtm atm);

    /**
     * Удаляет офис из банка
     * @param bank - банк
     * @param atm - банкомат
     */
    void deleteAtm(Bank bank, BankAtm atm);

    /**
     * Добавляет сотрудника в банк
     * @param bank - банк
     * @param employee - сотрудник
     */
    void addEmployee(Bank bank, Employee employee);

    /**
     * Удаляет сотрудника из банка
     * @param bank - банк
     * @param employee - сотрудник
     */
    void deleteEmployee(Bank bank, Employee employee);

    /**
     * Добавляет пользователя в банк
     * @param bank - банк
     * @param user - пользователь
     */
    void addUser(Bank bank, User user);

    /**
     * Удаляет пользователя из банка
     * @param bank - банк
     * @param user - пользователь
     */
    void deleteUser(Bank bank, User user);

    /**
     * Возвращает офисы, которые могут выдать кредит на данную сумму
     * @param bank - банк
     * @param sum - сумма кридита
     */
    List<BankOffice> getOfficesForLoans(Bank bank, double sum);

    /**
     *
     * @param bank - банк
     * @param office - офис
     * @return Возврашает сотрудников банка из данного офиса, которые могут выдать кредит
     */
    List<Employee> getEmployeesForLoans(Bank bank, BankOffice office);

    void getCredit(List<Bank> banks, User user);
}
