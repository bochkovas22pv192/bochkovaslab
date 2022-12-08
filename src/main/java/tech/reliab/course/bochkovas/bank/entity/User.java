package tech.reliab.course.bochkovas.bank.entity;

import tech.reliab.course.bochkovas.bank.entity.parentClasses.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class User extends Person {
    String job;
    double salary;
    Bank bank;
    double creditRating;
    ArrayList<PaymentAccount> payments = new ArrayList<PaymentAccount>();
    ArrayList<CreditAccount> credits = new ArrayList<CreditAccount>();

    public User() {}

    public User(Long id, String firstName, String lastName, LocalDate birthDate, String job,
                double salary, Bank bank, double creditRating) {
        super(id, firstName, lastName, birthDate);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditRating = creditRating;
    }

    public User(Long id, String firstName, String lastName, String patronymic, LocalDate birthDate, String job,
                double salary, Bank bank, double creditRating) {
        super(id, firstName, lastName, patronymic, birthDate);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
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
        this.bank = user.getBank();
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }

    public ArrayList<PaymentAccount> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<PaymentAccount> payments) {
        this.payments = payments;
    }

    public ArrayList<CreditAccount> getCredits() {
        return credits;
    }

    public void setCredits(ArrayList<CreditAccount> credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", bank_id=" + bank.getId() +
                ", creditRating=" + creditRating +
                '}';
    }
}