package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.service.BankOfficeService;

import java.util.LinkedHashMap;
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
    private LinkedHashMap<Long, BankOffice> offices = new LinkedHashMap<Long, BankOffice>();

    @Override
    public BankOffice create(String name, Bank bank, String address, double rent){
        var bankOffice = new BankOffice(
                ++id,
                bank,
                name,
                address,
                true,
                true,
                bank.getNumberOfAtms(),
                true,
                true,
                true,
                bank.getMoneyAmount(),
                rent
        );
        bank.setNumberOfOffices(bank.getNumberOfOffices()+1);
        return bankOffice;
    }

    @Override
    public List<BankOffice> findAll(){
        return offices.values().stream().toList();
    }

    @Override
    public void addOffice(BankOffice office){
        offices.put(office.getId(), office);
    }

    @Override
    public BankOffice getOfficeById(Long id){
        return offices.get(id);
    }

    @Override
    public void delOfficeById(Long id){
        offices.remove(id);
    }
}
