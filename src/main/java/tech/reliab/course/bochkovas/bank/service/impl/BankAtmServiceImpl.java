package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankAtm;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.entity.Employee;
import tech.reliab.course.bochkovas.bank.enums.AtmStatus;
import tech.reliab.course.bochkovas.bank.service.BankAtmService;

import java.util.LinkedHashMap;
import java.util.List;

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
    private LinkedHashMap<Long, BankAtm> atms = new LinkedHashMap<Long, BankAtm>();


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
        bank.setNumberOfAtms(bank.getNumberOfAtms()+1);
        bankOffice.setAtmNumber(bankOffice.getAtmNumber()+1);
        return bankAtm;
    }

    @Override
    public List<BankAtm> findAll(){
        return atms.values().stream().toList();
    }

    @Override
    public void addBankAtm(BankAtm atm){
        atms.put(atm.getId(), atm);
    }

    @Override
    public BankAtm getBankAtmById(Long id){
        return atms.get(id);
    }

    @Override
    public void delBankAtmById(Long id){
        atms.remove(id);
    }


}
