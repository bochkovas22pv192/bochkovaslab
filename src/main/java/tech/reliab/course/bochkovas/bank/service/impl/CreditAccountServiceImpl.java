package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.*;
import tech.reliab.course.bochkovas.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *  Singleton
 */
public class CreditAccountServiceImpl implements CreditAccountService {
    private static  CreditAccountServiceImpl INSTANCE;

    private CreditAccountServiceImpl(){}

    public static CreditAccountServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new CreditAccountServiceImpl();
        }
        return INSTANCE;
    }
    private Long id = 0L;
    private LinkedHashMap<Long, CreditAccount> creditAccounts = new LinkedHashMap<Long, CreditAccount>();


    @Override
    public CreditAccount create(User user, Bank bank, LocalDate start, LocalDate end, int month,
                                double sum, double monthPayment, Employee employee, PaymentAccount paymentAccount){
        var creditAccount = new CreditAccount(
                ++id,
                user,
                bank.getName(),
                start,
                end,
                month,
                sum,
                monthPayment,
                bank.getInterestRate(),
                employee,
                paymentAccount
        );
        return creditAccount;
    }

    @Override
    public List<CreditAccount> findAll() {
        return creditAccounts.values().stream().toList();
    }

    @Override
    public void addCreditAccount(CreditAccount creditAccount) {
        creditAccounts.put(creditAccount.getId(), creditAccount);
    }

    @Override
    public CreditAccount getCreditAccountById(Long id) {
        return creditAccounts.get(id);
    }

    @Override
    public void delCreditAccountById(Long id) {
        creditAccounts.remove(id);
    }


}
