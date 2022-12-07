package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankAtm;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.entity.Employee;

import java.util.List;

public interface BankAtmService {
    /**
     *
     * @param name - назание банкомата
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param employee - обслуживающий сотрудник
     * @param maintenance - стоимость обслуживания
     * @return - возвращает созданный объект банкомат
     */
    BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance);

    /**
     *
     * @return список всех банкоматов
     */
    List<BankAtm> findAll();

    /**
     * добавляет банкомат в коллекцию
     * @param atm - банкомат
     */
    void addBankAtm(BankAtm atm);

    /**
     *
     * @param id - id банкомата
     * @return банкомат с данным id или null
     */
    BankAtm getBankAtmById(Long id);

    /**
     * удаляет банкомат по id
     * @param id - id банкомата
     */
    void delBankAtmById(Long id);
}
