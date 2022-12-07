package tech.reliab.course.bochkovas.bank.entity;

public class Bank {
    Long id;
    String name;
    int numberOfOffices = 0;
    int numberOfAtms = 0;
    int numberOfEmployees = 0;
    int numberOfClients = 0;
    int rating;
    double moneyAmount;
    double interestRate;

    public Bank() {}

    public Bank(Long id, String name, int numberOfOffices, int numberOfAtms,
                int numberOfEmployees, int numberOfClients, int rating, double moneyAmount,
                double interestRate) {
        this.id = id;
        this.name = name;
        this.numberOfOffices = numberOfOffices;
        this.numberOfAtms = numberOfAtms;
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfClients = numberOfClients;
        this.rating = rating;
        this.moneyAmount = moneyAmount;
        this.interestRate = interestRate;
    }

    public Bank(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
        this.numberOfOffices = bank.getNumberOfOffices();
        this.numberOfAtms = bank.getNumberOfAtms();
        this.numberOfEmployees = bank.getNumberOfEmployees();
        this.numberOfClients = bank.getNumberOfClients();
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

    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(int numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public int getNumberOfAtms() {
        return numberOfAtms;
    }

    public void setNumberOfAtms(int numberOfAtms) {
        this.numberOfAtms = numberOfAtms;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
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
                ", numberOfOffices=" + numberOfOffices +
                ", numberOfAtms=" + numberOfAtms +
                ", numberOfEmployees=" + numberOfEmployees +
                ", numberOfClients=" + numberOfClients +
                ", rating=" + rating +
                ", moneyAmount=" + moneyAmount +
                ", interestRate=" + interestRate +
                '}';
    }
}
