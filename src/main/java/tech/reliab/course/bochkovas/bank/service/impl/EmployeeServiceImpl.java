package tech.reliab.course.bochkovas.bank.service.impl;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.entity.Employee;
import tech.reliab.course.bochkovas.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *  Singleton
 */
public class EmployeeServiceImpl implements EmployeeService {
    private static  EmployeeServiceImpl INSTANCE;

    private EmployeeServiceImpl(){}

    public static EmployeeServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new EmployeeServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private LinkedHashMap<Long, Employee> employees = new LinkedHashMap<Long, Employee>();

    @Override
    public Employee create(String firstName, String lastName, LocalDate birthDate,
                           String job, Bank bank, BankOffice bankOffice, double salary){
        var employee = new Employee(
                ++id,
                firstName,
                lastName,
                birthDate,
                job,
                bank,
                true,
                bankOffice,
                true,
                salary
        );
        bank.setNumberOfEmployees(bank.getNumberOfEmployees()+1);
        return employee;
    }

    @Override
    public Employee create(String firstName, String lastName, String patronymic, LocalDate birthDate,
                           String job, Bank bank, BankOffice bankOffice, double salary){
        var employee = new Employee(
                ++id,
                firstName,
                lastName,
                patronymic,
                birthDate,
                job,
                bank,
                true,
                bankOffice,
                true,
                salary
        );
        bank.setNumberOfEmployees(bank.getNumberOfEmployees()+1);
        return employee;
    }

    @Override
    public List<Employee> findAll(){
        return employees.values().stream().toList();
    }

    @Override
    public void addEmployee(Employee employee){
        employees.put(employee.getId(), employee);
    }

    @Override
    public Employee getEmployeeById(Long id){
        return employees.get(id);
    }

    @Override
    public void delEmployeeById(Long id){
        employees.remove(id);
    }

}
