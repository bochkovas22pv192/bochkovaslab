package tech.reliab.course.bochkovas.bank.entity;

import java.time.LocalDate;

public class CreditAccount {
    Long id;
    User user;
    Bank bank;
    LocalDate start;
    LocalDate end;
    int monthNumber;
    double sum;
    double monthPayment;
    double interestRate;
    Employee employee;
    PaymentAccount paymentAccount;

    public CreditAccount() {}

    public CreditAccount(Long id, User user, Bank bank, LocalDate start,
                         LocalDate end, int monthNumber, double sum, double monthPayment,
                         double interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.start = start;
        this.end = end;
        this.monthNumber = monthNumber;
        this.sum = sum;
        this.monthPayment = monthPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(CreditAccount creditAccount) {
        this.id = creditAccount.getId();
        this.user = creditAccount.getUser();
        this.bank = creditAccount.getBank();
        this.start = creditAccount.getStart();
        this.end = creditAccount.getEnd();
        this.monthNumber = creditAccount.getMonthNumber();
        this.sum = creditAccount.getSum();
        this.monthPayment = creditAccount.getMonthPayment();
        this.interestRate = creditAccount.getInterestRate();
        this.employee = creditAccount.getEmployee();
        this.paymentAccount = creditAccount.getPaymentAccount();
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(double monthPayment) {
        this.monthPayment = monthPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", bankName='" + bank.getName() + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", monthNumber=" + monthNumber +
                ", sum=" + sum +
                ", monthPayment=" + monthPayment +
                ", interestRate=" + interestRate +
                ", employeeId=" + employee.getId() +
                ", paymentAccountId=" + paymentAccount.getId() +
                '}';
    }
}
