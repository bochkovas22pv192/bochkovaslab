package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankAtm;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {
    /**
     *
     * @param name - имя офиса
     * @param bank - банк офиса
     * @param address - адрес офиса
     * @param rent - стоимость аренды офиса
     * @return - возвращает созданный объект офис
     */
    BankOffice create(String name, Bank bank, String address, double rent);

    /**
     * Добавляем банкомат в офис
     * @param office - офис
     * @param atm - банкомат
     */
    void addAtm(BankOffice office, BankAtm atm);

    /**
     * Удаляем банкомат в офиса
     * @param office - офис
     * @param atm - банкомат
     */
    void deleteAtm(BankOffice office, BankAtm atm);

    /**
     *
     * @param office - офис
     * @param sum - сумма кредита
     * @return - возвращает список банкоматов, которые могут выдать данную сумму
     */
    List<BankAtm> getAtmsForLoans(BankOffice office, double sum);
}