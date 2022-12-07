package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.BankOffice;
import tech.reliab.course.bochkovas.bank.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    Employee create(String firstName, String lastName, LocalDate birthDate, String job,
                    Bank bank, BankOffice bankOffice, double salary
    );

    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    Employee create(String firstName, String lastName, String patronymic, LocalDate birthDate,
                    String job, Bank bank, BankOffice bankOffice, double salary
    );

    /**
     *
     * @return список сотрудников
     */
    List<Employee> findAll();

    /**
     * добавляет сотрудника в коллекцию
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     *
     * @param id - id сотрудника
     * @return сотрудник с данным id
     */
    Employee getEmployeeById(Long id);

    /**
     * удаляет сотрудника с данным id
     * @param id - id сотрудника
     */
    void delEmployeeById(Long id);
}
