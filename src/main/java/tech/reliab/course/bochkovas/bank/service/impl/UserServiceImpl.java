package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.User;
import tech.reliab.course.bochkovas.bank.service.UserService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
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
    private LinkedHashMap<Long, User> users = new LinkedHashMap<Long, User>();

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
        bank.setNumberOfClients(bank.getNumberOfClients()+1);
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
        bank.setNumberOfClients(bank.getNumberOfClients()+1);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public void delUserById(Long id) {
        users.remove(id);
    }

    @Override
    public void outputUserInfo(Long id) {
        System.out.println("User:");
        System.out.println(users.get(id));
        var pays = PaymentAccountServiceImpl.getInstance().findAll().stream()
                .filter(pay -> pay.getUser().getId().compareTo(id)==0).toList();
        System.out.println("\tPaymentAccounts:");
        for(var pay : pays){
            System.out.println("\t\t"+pay);
        }
        var credits = CreditAccountServiceImpl.getInstance().findAll().stream()
                .filter(pay -> pay.getUser().getId().compareTo(id)==0).toList();
        System.out.println("\tCreditAccounts:");
        for(var credit : credits){
            System.out.println("\t\t"+credit);
        }
    }


}
