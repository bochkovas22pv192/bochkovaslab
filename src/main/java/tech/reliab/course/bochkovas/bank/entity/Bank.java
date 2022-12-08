package tech.reliab.course.bochkovas.bank.entity;

import java.util.ArrayList;

public class Bank {
    Long id;
    String name;
    ArrayList<BankOffice> listOfOffices = new ArrayList<BankOffice>();
    ArrayList<BankAtm> listOfAtms = new ArrayList<BankAtm>();
    ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
    ArrayList<User> listOfClients = new ArrayList<User>();
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

    public ArrayList<BankOffice> getListOfOffices() {
        return listOfOffices;
    }

    public void setListOfOffices(ArrayList<BankOffice> listOfOffices) {
        this.listOfOffices = listOfOffices;
    }

    public ArrayList<BankAtm> getListOfAtms() {
        return listOfAtms;
    }

    public void setListOfAtms(ArrayList<BankAtm> listOfAtms) {
        this.listOfAtms = listOfAtms;
    }

    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public ArrayList<User> getListOfClients() {
        return listOfClients;
    }

    public void setListOfClients(ArrayList<User> listOfClients) {
        this.listOfClients = listOfClients;
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

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfOffices=" + listOfOffices.size() +
                ", numberOfAtms=" + listOfAtms.size() +
                ", numberOfEmployees=" + listOfEmployees.size() +
                ", numberOfClients=" + listOfClients.size() +
                ", rating=" + rating +
                ", moneyAmount=" + moneyAmount +
                ", interestRate=" + interestRate +
                '}';
    }
}
