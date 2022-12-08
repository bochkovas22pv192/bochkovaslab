package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.*;
import tech.reliab.course.bochkovas.bank.service.BankService;

import java.util.Random;

/**
 *  Singleton
 */
public class BankServiceImpl implements BankService {

    private static  BankServiceImpl INSTANCE;

    private BankServiceImpl(){}

    public static BankServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private static Random random = new Random();

    @Override
    public Bank create(String name){
        int rating = random.nextInt(100);
        int money = random.nextInt(1000000);
        double rate = (20 - (20 * rating)/100.0);
        var bank = new Bank(
                ++id,
                name,
                rating,
                money,
                rate
        );

        return bank;
    }

    @Override
    public void outputBankInfo(Bank bank){
        System.out.println(bank);
        for(var office:bank.getListOfOffices()){
            System.out.println("\t"+office);
        }
        for(var atm:bank.getListOfAtms()){
            System.out.println("\t\t"+atm);
        }
        for(var employee:bank.getListOfEmployees()){
            System.out.println("\t\t\t"+employee);
        }
        for(var user:bank.getListOfClients()){
            UserServiceImpl.getInstance().outputUserInfo(user);
        }

    }

    @Override
    public void addAtm(Bank bank, BankAtm atm){
        bank.getListOfAtms().add(atm);
    }
    @Override
    public void addOffice(Bank bank, BankOffice office){
        bank.getListOfOffices().add(office);
    }

    @Override
    public void addEmployee(Bank bank,  Employee employee){
        bank.getListOfEmployees().add(employee);
    }

    @Override
    public void addUser(Bank bank,  User user){
        bank.getListOfClients().add(user);
    }

    @Override
    public void delAtm(Bank bank, BankAtm atm){
        bank.getListOfAtms().remove(atm);
    }

    @Override
    public void delOffice(Bank bank, BankOffice bankOffice){
        bank.getListOfOffices().remove(bankOffice);
    }

    @Override
    public void delEmployees(Bank bank, Employee employee){
        bank.getListOfEmployees().remove(employee);
    }

    @Override
    public void delUser(Bank bank, User user){
        bank.getListOfClients().remove(user);
    }

}
