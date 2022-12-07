package tech.reliab.course.bochkovas;

import tech.reliab.course.bochkovas.bank.entity.*;
import tech.reliab.course.bochkovas.bank.service.*;
import tech.reliab.course.bochkovas.bank.service.impl.*;

import java.time.LocalDate;

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

        //Создание сущьностей
        for(int numBunk=0; numBunk<5; numBunk++){
            var bank = bankService.create("Bank"+(numBunk+1));
            for(int numOffice=0; numOffice<3; numOffice++){
                var office = officeService.create(
                        "Office"+(numOffice+1),
                        bank,
                        "Address",
                        1000.
                );
                officeService.addOffice(office);
                for(int numEmpl=0; numEmpl<5; numEmpl++){
                    var employee = employeeService.create(
                            "vasia",
                            "pupkin",
                            LocalDate.now(),
                            "job",
                            bank,
                            office,
                            10000.
                    );
                    employeeService.addEmployee(employee);
                }
            }
            for(int numAtm=0; numAtm<3; numAtm++){
                var atm = atmService.create(
                        "atm"+(numAtm+1),
                        bank,
                        officeService.getOfficeById(1L),
                        employeeService.getEmployeeById(1L),
                        100.
                );
                atmService.addBankAtm(atm);
            }
            for(int numUser=0; numUser<5; numUser++){
                var user = userService.create(
                        "user",
                        "user",
                        LocalDate.now(),
                        "job",
                        bank
                );
                userService.addUser(user);
                for(int numPay=0; numPay<2; numPay++){
                    var paymentAccount = paymentAccountService.create(
                            user,
                            bank.getName()
                    );
                    paymentAccountService.addPaymentAccount(paymentAccount);
                    var credit = creditAccountService.create(
                            user,
                            bank,
                            LocalDate.now(),
                            LocalDate.now(),
                            12,
                            100000.,
                            1000.,
                            employeeService.findAll().stream().filter(
                                            empl -> empl.getBank().getId().compareTo(bank.getId())==0)
                                    .toList().get(0),
                            paymentAccount
                    );
                    creditAccountService.addCreditAccount(credit);
                }
            }
            bankService.addBank(bank);
        }
        //Вывод информации по всем банкам
        for(var bank : bankService.findAll()){
            bankService.outputBankInfo(bank.getId());
        }
    }
}