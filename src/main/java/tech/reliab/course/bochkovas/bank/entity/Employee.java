package tech.reliab.course.bochkovas.bank.entity;

import tech.reliab.course.bochkovas.bank.entity.parentClasses.Person;

import java.time.LocalDate;

public class Employee extends Person {
    String job;
    Bank bank;
    boolean workInOffice;
    BankOffice bankOffice;
    boolean canApplyLoan;
    double salary;

    public Employee() {}

    public Employee(Long id, String firstName, String lastName, LocalDate birthDate, String job,
                    Bank bank, boolean workInOffice, BankOffice bankOffice,
                    boolean canApplyLoan, double salary) {
        super(id, firstName, lastName, birthDate);
        this.job = job;
        this.bank = bank;
        this.workInOffice = workInOffice;
        this.bankOffice = bankOffice;
        this.canApplyLoan = canApplyLoan;
        this.salary = salary;
    }

    public Employee(Long id, String firstName, String lastName, String patronymic, LocalDate birthDate, String job,
                    Bank bank, boolean workInOffice, BankOffice bankOffice,
                    boolean canApplyLoan, double salary) {
        super(id, firstName, lastName, patronymic, birthDate);
        this.job = job;
        this.bank = bank;
        this.workInOffice = workInOffice;
        this.bankOffice = bankOffice;
        this.canApplyLoan = canApplyLoan;
        this.salary = salary;
    }

    public Employee(Employee employee) {
        super.setId(employee.getId());
        super.setFirstName(employee.getFirstName());
        super.setLastName(employee.getLastName());
        super.setPatronymic(employee.getPatronymic());
        super.setBirthDate(employee.getBirthDate());
        this.job = employee.getJob();
        this.bank = employee.getBank();
        this.workInOffice = employee.isWorkInOffice();
        this.bankOffice = employee.getBankOffice();
        this.canApplyLoan = employee.isCanApplyLoan();
        this.salary = employee.getSalary();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isWorkInOffice() {
        return workInOffice;
    }

    public void setWorkInOffice(boolean workInOffice) {
        this.workInOffice = workInOffice;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public boolean isCanApplyLoan() {
        return canApplyLoan;
    }

    public void setCanApplyLoan(boolean canApplyLoan) {
        this.canApplyLoan = canApplyLoan;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + super.getId() +
                ", office=" + bankOffice.getName() +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
