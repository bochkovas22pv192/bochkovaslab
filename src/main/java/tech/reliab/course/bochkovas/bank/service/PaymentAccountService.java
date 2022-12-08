package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.PaymentAccount;
import tech.reliab.course.bochkovas.bank.entity.User;

public interface PaymentAccountService {
    /**
     *
     * @param user - клиент
     * @param bankName - имя банка
     * @return - возвращает созданный объект платежный счет
     */
    PaymentAccount create(User user, String bankName);
    PaymentAccount read();
    void update(PaymentAccount paymentAccount);
    void delete(PaymentAccount paymentAccount);
}
