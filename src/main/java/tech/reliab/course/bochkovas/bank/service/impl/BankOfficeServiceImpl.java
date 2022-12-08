package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.service.BankOfficeService;

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
    private BankOffice bankOffice;

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
        bank.getListOfOffices().add(bankOffice);
        return bankOffice;
    }

    /**
     *
     * @return - возвращает объект офис
     */
    @Override
    public BankOffice read(){
        return bankOffice;
    }

    /**
     *
     * @param bankOffice - новый объект
     */
    @Override
    public  void update(BankOffice bankOffice){
        this.bankOffice = bankOffice;
    }

    /**
     *
     * @param bankOffice - офис для удалеия
     */
    @Override
    public void delete(BankOffice bankOffice){
        if(bankOffice == this.bankOffice){
            this.bankOffice = null;
        }
    }

}
