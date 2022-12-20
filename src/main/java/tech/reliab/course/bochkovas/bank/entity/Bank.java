package tech.reliab.course.bochkovas.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    Long id;
    String name;
    List<BankOffice> offices = new ArrayList<>();
    List<BankAtm> atms = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    List<User> users = new ArrayList<>();
    int rating;
    double moneyAmount;
    double interestRate;

    public Bank() {}

    public Bank(Long id, String name, int rating, double moneyAmount,
                double interestRate) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.moneyAmount = moneyAmount;
        this.interestRate = interestRate;
    }

    public Bank(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
        this.offices = bank.getOffices();
        this.atms = bank.getAtms();
        this.employees = bank.getEmployees();
        this.users = bank.getUsers();
        this.rating = bank.getRating();
        this.moneyAmount = bank.getMoneyAmount();
        this.interestRate = bank.getInterestRate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public List<BankOffice> getOffices() {
        return offices;
    }

    public void setOffices(List<BankOffice> offices) {
        this.offices = offices;
    }

    public List<BankAtm> getAtms() {
        return atms;
    }

    public void setAtms(List<BankAtm> atms) {
        this.atms = atms;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfOffices=" + offices.size() +
                ", numberOfAtms=" + atms.size() +
                ", numberOfEmployees=" + employees.size() +
                ", numberOfUsers=" + users.size() +
                ", rating=" + rating +
                ", moneyAmount=" + moneyAmount +
                ", interestRate=" + interestRate +
                '}';
    }
}
