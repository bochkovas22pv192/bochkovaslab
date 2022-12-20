package tech.reliab.course.bochkovas;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.User;
import tech.reliab.course.bochkovas.bank.service.*;
import tech.reliab.course.bochkovas.bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Сервисы
        BankService bankService = BankServiceImpl.getInstance();
        BankOfficeServiceImpl officeService = BankOfficeServiceImpl.getInstance();
        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        BankAtmService atmService = BankAtmServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
        CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();

        List<Bank> bankList = new ArrayList<>();

        //Создание сущностей
        for(int numBunk=0; numBunk<5; numBunk++){
            var bank = bankService.create("Bank"+(numBunk+1));
            for(int numOffice=0; numOffice<3; numOffice++){
                var office = officeService.create(
                        "Office"+(numOffice+1),
                        bank,
                        "Address",
                        1000.
                );
                for(int numEmpl=0; numEmpl<5; numEmpl++){
                    var employee = employeeService.create(
                            "denis",
                            "cherny",
                            LocalDate.now(),
                            "engineer",
                            bank,
                            office,
                            10000.
                    );
                }
            }
            for(int numAtm=0; numAtm<3; numAtm++){
                var atm = atmService.create(
                        "atm"+(numAtm+1),
                        bank,
                        bank.getOffices().stream().findFirst().get(),
                        bank.getEmployees().stream().findFirst().get(),
                        100.
                );
            }
            for(int numUser=0; numUser<5; numUser++){
                var user = userService.create(
                        "user",
                        "user",
                        LocalDate.now(),
                        "job"
                );
                bankService.addUser(bank, user);
                for(int numPay=0; numPay<2; numPay++){
                    var paymentAccount = paymentAccountService.create(
                            user,
                            bank
                    );
                    var credit = creditAccountService.create(
                            user,
                            bank,
                            LocalDate.now(),
                            LocalDate.now(),
                            12,
                            100000.,
                            1000.,
                            bank.getEmployees().stream().findFirst().get(),
                            paymentAccount
                    );
                }
            }
            bankList.add(bank);
        }

        User user = userService.create("Test", "User", LocalDate.now(), "job");

        bankService.getCredit(bankList, user);

        userService.outputUserInfo(user);

    }
}