package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.*;
import tech.reliab.course.bochkovas.bank.service.CreditAccountService;

import java.time.LocalDate;

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
    private CreditAccount creditAccount;

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
    /**
     *
     * @return - возвращает объект кредитный счет
     */
    @Override
    public CreditAccount read(){
        return creditAccount;
    }

    /**
     *
     * @param creditAccount - новый кредитный счет
     */
    @Override
    public void update(CreditAccount creditAccount){
        this.creditAccount = creditAccount;
    }

    /**
     *
     * @param creditAccount - кредитный счет для удаления
     */
    @Override
    public void delete(CreditAccount creditAccount){
        if(this.creditAccount == creditAccount){
            this.creditAccount = null;
        }
    }
}
