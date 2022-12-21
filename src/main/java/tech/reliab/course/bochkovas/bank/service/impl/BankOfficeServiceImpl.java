package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankAtm;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.bochkovas.bank.exceptions.NegativeSumException;
import tech.reliab.course.bochkovas.bank.service.BankOfficeService;

import java.util.List;

/**
 *  Singleton
 */
public class BankOfficeServiceImpl implements BankOfficeService {

    private static  BankOfficeServiceImpl INSTANCE;

    private BankOfficeServiceImpl(){}

    public static BankOfficeServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankOfficeServiceImpl();
        }
        return INSTANCE;
    }

    Long id = 0L;

    @Override
    public BankOffice create(String name, Bank bank, String address, double rent){
        var bankOffice = new BankOffice(
                ++id,
                bank,
                name,
                address,
                true,
                true,
                true,
                true,
                true,
                bank.getMoneyAmount(),
                rent
        );
        bank.getOffices().add(bankOffice);
        return bankOffice;
    }

    @Override
    public void addAtm(BankOffice office, BankAtm atm) {
        office.getAtms().add(atm);
    }

    @Override
    public void deleteAtm(BankOffice office, BankAtm atm) {
        if(!office.getAtms().contains(atm)){
            throw new DeletingNotExistentObjectException();
        }
        office.getAtms().remove(atm);
    }

    @Override
    public List<BankAtm> getAtmsForLoans(BankOffice office, double sum) {
        if(sum < 0){
            throw new NegativeSumException();
        }
        return office.getAtms().stream().filter(
                atm-> atm.isCanPaymentOfMoney() && atm.getMoneyAmount() > sum).toList();
    }

}
