package Main.Employees;

import lombok.Getter;
import lombok.Setter;

public class Developer extends Employee {
    @Getter
    @Setter
    private double bonuses;


    public Developer(String name, int rate, int workdays) {
        this.name = name;
        this.ratePerHour = rate;
        this.workdays = workdays;
    }


    @Override
    public double getSalary() {
        return ratePerHour * workdays * 8 + bonuses;
    }


}
