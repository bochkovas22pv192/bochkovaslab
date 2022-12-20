package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.*;
import tech.reliab.course.bochkovas.bank.exceptions.DeletingNotExistentObjectException;
import tech.reliab.course.bochkovas.bank.exceptions.IdException;
import tech.reliab.course.bochkovas.bank.exceptions.LendingTermsException;
import tech.reliab.course.bochkovas.bank.exceptions.NegativeSumException;
import tech.reliab.course.bochkovas.bank.service.BankService;
import tech.reliab.course.bochkovas.bank.utils.BankComparator;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        int money = random.nextInt(200000);
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
        System.out.println("Bank:");
        System.out.println("\t"+bank);
        System.out.println("\tOffices:");
        for(var office: bank.getOffices()){
            System.out.println("\t\t"+office);
        }
        System.out.println("\tEmployees:");
        for(var employee: bank.getEmployees()){
            System.out.println("\t\t"+employee);
        }
        System.out.println("\tAtms:");
        for(var atm: bank.getAtms()){
            System.out.println("\t\t"+atm);
        }
        System.out.println("\tUsers:");
        for(var user: bank.getUsers()){
            UserServiceImpl.getInstance().outputUserInfo(user);
        }
    }

    @Override
    public void addOffice(Bank bank, BankOffice office) {
        bank.getOffices().add(office);
    }

    @Override
    public void deleteOffice(Bank bank, BankOffice office){
        if(!bank.getOffices().contains(office)){
            throw new DeletingNotExistentObjectException();
        }
        bank.getOffices().remove(office);
    }

    @Override
    public void addAtm(Bank bank, BankAtm atm) {
        bank.getAtms().add(atm);
    }

    @Override
    public void deleteAtm(Bank bank, BankAtm atm) {
        if(!bank.getAtms().contains(atm)){
            throw new DeletingNotExistentObjectException();
        }
        bank.getAtms().remove(atm);
    }

    @Override
    public void addEmployee(Bank bank, Employee employee) {
        bank.getEmployees().add(employee);
    }

    @Override
    public void deleteEmployee(Bank bank, Employee employee) {
        if(!bank.getEmployees().contains(employee)){
            throw new DeletingNotExistentObjectException();
        }
        bank.getEmployees().remove(employee);
    }

    @Override
    public void addUser(Bank bank, User user) {
        bank.getUsers().add(user);
    }

    @Override
    public void deleteUser(Bank bank, User user) {
        if(!bank.getUsers().contains(user)){
            throw new DeletingNotExistentObjectException();
        }
        bank.getUsers().remove(user);
    }

    @Override
    public List<BankOffice> getOfficesForLoans(Bank bank, double sum) {
        if(sum < 0){
            throw new NegativeSumException();
        }
        return bank.getOffices().stream().filter(
                office -> office.isCanApplyLoan() && office.getMoneyAmount() > sum && office.isWorking()).toList();
    }

    @Override
    public List<Employee> getEmployeesForLoans(Bank bank, BankOffice office) {
        if(!bank.getOffices().contains(office)){
            throw new IdException();
        }
        return bank.getEmployees().stream().filter(
                emp -> emp.getBankOffice().getId().compareTo(office.getId())==0 && emp.isCanApplyLoan()).toList();
    }

    @Override
    public void getCredit(List<Bank> banks, User user) {
        Scanner reader = new Scanner(System.in);
        banks.sort(new BankComparator());
        System.out.println("Input credit sum: ");
        double sum = reader.nextDouble();
        System.out.println("Banks:");
        for(int i=0; i<banks.size(); i++){
            System.out.println(String.format("index: %d  ",i)+banks.get(i));
        }
        System.out.println("Choose bank: ");
        int indexOfBank = reader.nextInt();
        Bank bank = banks.get(indexOfBank);
        System.out.println("Offices:");
        List<BankOffice> offices = BankServiceImpl.getInstance().getOfficesForLoans(bank, sum);
        if(offices.isEmpty()){
            System.out.println("Offices not found");
            throw new LendingTermsException();
        }
        for(int i=0; i<bank.getOffices().size(); i++){
            System.out.println(String.format("index: %d  ",i)+bank.getOffices().get(i));
        }
        System.out.println("Choose office: ");
        int indexOfOffice = reader.nextInt();
        BankOffice office = offices.get(indexOfOffice);
        List<Employee> employees = BankServiceImpl.getInstance().getEmployeesForLoans(bank, office);
        if(employees.isEmpty()){
            System.out.println("Employees not found");
            throw new LendingTermsException();
        }
        for(int i=0; i<employees.size(); i++){
            System.out.println(String.format("index: %d  ",i)+employees.get(i));
        }
        System.out.println("Choose employee: ");
        int indexOfEmployee = reader.nextInt();
        Employee employee = employees.get(indexOfEmployee);
        List<BankAtm> atms = BankOfficeServiceImpl.getInstance().getAtmsForLoans(office, sum);
        if(atms.isEmpty()){
            System.out.println("Atms not found");
            throw new LendingTermsException();
        }
        if(!user.getBanks().contains(bank)){
            BankServiceImpl.getInstance().addUser(bank, user);
            PaymentAccount payment = PaymentAccountServiceImpl.getInstance().create(user,bank);
        }
        if(user.getCreditRating() < 5000 && bank.getRating() > 50){
            throw new LendingTermsException();
        }
        int month = Math.toIntExact(Math.round(sum/ user.getSalary()));
        CreditAccount creditAccount = CreditAccountServiceImpl.getInstance().create(
                user,
                bank,
                LocalDate.now(),
                LocalDate.now(),
                month,
                sum,
                sum/12,
                employee,
                user.getPaymentAccounts().stream().filter(
                        pay -> pay.getBank().getId().compareTo(bank.getId())==0).findFirst().get()
        );
        BankAtmServiceImpl.getInstance().withdrawMoney(atms.get(0), sum);
    }
}
