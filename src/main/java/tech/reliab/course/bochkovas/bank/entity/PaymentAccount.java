package tech.reliab.course.bochkovas.bank.entity;

public class PaymentAccount {
    Long id;
    User user;
    String bankName;
    double sum;

    public  PaymentAccount() {}

    public PaymentAccount(Long id, User user, String bankName, double sum) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.sum = sum;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        this.id = paymentAccount.getId();
        this.user = paymentAccount.getUser();
        this.bankName = paymentAccount.getBankName();
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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
                ", bankName='" + bankName + '\'' +
                ", sum=" + sum +
                '}';
    }
}
