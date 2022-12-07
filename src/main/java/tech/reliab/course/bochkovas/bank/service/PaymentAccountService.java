package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.PaymentAccount;
import tech.reliab.course.bochkovas.bank.entity.User;

import java.util.List;


public interface PaymentAccountService {
    /**
     *
     * @param user - клиент
     * @param bankName - имя банка
     * @return - возвращает созданный объект платежный счет
     */
    PaymentAccount create(User user, String bankName);

    /**
     *
     * @return спимок платежных счетов
     */
    List<PaymentAccount> findAll();

    /**
     * добавляет платежный счет в коллекцию
     * @param paymentAccount - платежный счет
     */
    void addPaymentAccount(PaymentAccount paymentAccount);

    /**
     *
     * @param id - id платежного счета
     * @return платежный счет с данным id
     */
    PaymentAccount getPaymentAccountById(Long id);

    /**
     * удаляет платежный счет с данным id
     * @param id - id платежного счета
     */
    void delPaymentAccountById(Long id);
}
