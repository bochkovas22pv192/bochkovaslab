package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.PaymentAccount;
import tech.reliab.course.bochkovas.bank.entity.User;
import tech.reliab.course.bochkovas.bank.service.PaymentAccountService;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *  Singleton
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static  PaymentAccountServiceImpl INSTANCE;

    private PaymentAccountServiceImpl(){}

    public static PaymentAccountServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new PaymentAccountServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private LinkedHashMap<Long, PaymentAccount> paymentAccounts = new LinkedHashMap<Long, PaymentAccount>();


    @Override
    public PaymentAccount create(User user, String bankName){
        var paymentAccount = new PaymentAccount(
                ++id,
                user,
                bankName,
                0
        );
        return paymentAccount;
    }

    @Override
    public List<PaymentAccount> findAll(){
        return paymentAccounts.values().stream().toList();
    }

    @Override
    public void addPaymentAccount(PaymentAccount paymentAccount) {
        paymentAccounts.put(paymentAccount.getId(), paymentAccount);
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long id) {
        return paymentAccounts.get(id);
    }

    @Override
    public void delPaymentAccountById(Long id) {
        paymentAccounts.remove(id);
    }


}
