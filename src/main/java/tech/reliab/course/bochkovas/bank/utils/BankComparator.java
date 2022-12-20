package tech.reliab.course.bochkovas.bank.utils;

import tech.reliab.course.bochkovas.bank.entity.Bank;

import java.util.Comparator;

public class BankComparator implements Comparator<Bank> {
    @Override
    public int compare(Bank left, Bank right){
        if(!((left.getInterestRate() - right.getInterestRate()) < 0.00001)){
            return left.getInterestRate() < right.getInterestRate() ? -1: 1;
        }

        if(left.getRating() != right.getRating()){
            return left.getRating() > right.getRating() ? -1: 1;
        }

        if(left.getUsers().size() != right.getUsers().size()){
            return  left.getUsers().size() > right.getUsers().size() ? -1: 1;
        }

        if(left.getOffices().size() != right.getOffices().size()){
            return left.getOffices().size() > right.getOffices().size() ? -1: 1;
        }

        if(left.getAtms().size() != right.getAtms().size()){
            return left.getAtms().size() > right.getAtms().size() ? -1: 1;
        }

        if(left.getEmployees().size() != right.getEmployees().size()){
            return left.getEmployees().size() > right.getEmployees().size() ? -1: 1;
        }

        return  0;
    }
}
