package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.CreditAccount;
import tech.reliab.course.bochkovas.bank.entity.PaymentAccount;
import tech.reliab.course.bochkovas.bank.entity.User;
import tech.reliab.course.bochkovas.bank.service.UserService;

import java.time.LocalDate;
import java.util.Random;

/**
 *  Singleton
 */
public class UserServiceImpl implements UserService {

    private static  UserServiceImpl INSTANCE;

    private UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }
    private Long id = 0L;
    private Random random = new Random();

    @Override
    public User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank){
        double salary = random.nextInt(10000);
        var user = new User(
                ++id,
                firstName,
                lastName,
                birthDate,
                job,
                salary,
                bank,
                salary / 10
        );
        bank.getListOfClients().add(user);
        return user;
    }

    @Override
    public User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank){
        double salary = random.nextInt(10000);
        var user = new User(
                ++id,
                firstName,
                lastName,
                patronymic,
                birthDate,
                job,
                salary,
                bank,
                salary / 10
        );
        bank.getListOfClients().add(user);
        return user;
    }

    public void addCreditAccout(User user, CreditAccount credit){
        user.getCredits().add(credit);
    }

    public void delCreditAccout(User user, CreditAccount credit){
        user.getCredits().remove(credit);
    }

    public void addPaymentAccount(User user, PaymentAccount paymentAccount){
        user.getPayments().add(paymentAccount);
    }

    public void delPaymentAccount(User user, PaymentAccount paymentAccount){
        user.getPayments().remove(paymentAccount);
    }

    @Override
    public void outputUserInfo(User user) {
        System.out.println("User:");
        System.out.println(user.getFullName());
        System.out.println("\tPaymentAccounts:");
        for(var pay : user.getPayments()){
            System.out.println("\t\t"+pay);
        }
        System.out.println("\tCreditAccounts:");
        for(var credit : user.getCredits()){
            System.out.println("\t\t"+credit);
        }
    }


}
