package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankAtm;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.entity.Employee;
import tech.reliab.course.bochkovas.bank.enums.AtmStatus;
import tech.reliab.course.bochkovas.bank.service.BankAtmService;

/**
 *  Singleton
 */
public class BankAtmServiceImpl implements BankAtmService {
    private static  BankAtmServiceImpl INSTANCE;

    private BankAtmServiceImpl(){}

    public static BankAtmServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankAtmServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private BankAtm bankAtm;

    @Override
    public BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance){
        var bankAtm = new BankAtm(
                ++id,
                name,
                AtmStatus.WORKING,
                bankOffice.getAddress(),
                bank,
                bankOffice,
                employee,
                true,
                true,
                bank.getMoneyAmount(),
                maintenance
        );
        bank.getListOfAtms().add(bankAtm);
        bankOffice.getAtmList().add(bankAtm);
        return bankAtm;
    }

    /**
     *
     * @return - возвращает банкомат
     */
    @Override
    public BankAtm read(){
        return bankAtm;
    }

    /**
     *
     * @param bankAtm - новый объект банкомат
     */
    @Override
    public void update(BankAtm bankAtm){
        this.bankAtm = bankAtm;
    }

    /**
     *
     * @param bankAtm - банкомат для удаления
     */
    @Override
    public void delete(BankAtm bankAtm){
        if(this.bankAtm == bankAtm){
            this.bankAtm = null;
        }
    }

}
