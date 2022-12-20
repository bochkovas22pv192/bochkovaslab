package tech.reliab.course.bochkovas.bank.entity;

public class PaymentAccount {
    Long id;
    User user;
    Bank bank;
    double sum;

    public  PaymentAccount() {}

    public PaymentAccount(Long id, User user, Bank bank, double sum) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.sum = sum;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        this.id = paymentAccount.getId();
        this.user = paymentAccount.getUser();
        this.bank = paymentAccount.getBank();
        this.sum = paymentAccount.getSum();
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", bankName='" + bank.getName() + '\'' +
                ", sum=" + sum +
                '}';
    }
}
