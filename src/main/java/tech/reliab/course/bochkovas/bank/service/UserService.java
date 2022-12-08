package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.CreditAccount;
import tech.reliab.course.bochkovas.bank.entity.PaymentAccount;
import tech.reliab.course.bochkovas.bank.entity.User;

import java.time.LocalDate;

public interface UserService {
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank);
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank);

    void addCreditAccout(User user, CreditAccount credit);

    void delCreditAccout(User user, CreditAccount credit);

    void addPaymentAccount(User user, PaymentAccount paymentAccount);

    void delPaymentAccount(User user, PaymentAccount paymentAccount);

    void outputUserInfo(User user);

}
