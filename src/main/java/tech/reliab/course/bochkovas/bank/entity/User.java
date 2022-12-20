package tech.reliab.course.bochkovas.bank.entity;

import tech.reliab.course.bochkovas.bank.entity.parentClasses.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    String job;
    double salary;
    List<Bank> banks = new ArrayList<>();
    List<CreditAccount> creditAccounts = new ArrayList<>();
    List<PaymentAccount> paymentAccounts = new ArrayList<>();
    double creditRating;

    public User() {}

    public User(Long id, String firstName, String lastName, LocalDate birthDate, String job,
                double salary, double creditRating) {
        super(id, firstName, lastName, birthDate);
        this.job = job;
        this.salary = salary;
        this.creditRating = creditRating;
    }

    public User(Long id, String firstName, String lastName, String patronymic, LocalDate birthDate, String job,
                double salary, double creditRating) {
        super(id, firstName, lastName, patronymic, birthDate);
        this.job = job;
        this.salary = salary;
        this.creditRating = creditRating;
    }

    public User(User user) {
        super.setId(user.getId());
        super.setFirstName(user.getFirstName());
        super.setLastName(user.getLastName());
        super.setPatronymic(user.getPatronymic());
        super.setBirthDate(user.getBirthDate());
        this.job = user.getJob();
        this.salary = user.getSalary();
        this.banks = user.getBanks();
        this.creditRating = user.getCreditRating();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void addBank(Bank bank) {
        this.banks.add(bank);
    }

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(List<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public List<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", banks=" + banks.stream().map(Bank::getName).toList() +
                ", creditRating=" + creditRating +
                '}';
    }
}