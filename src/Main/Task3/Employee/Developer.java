package Main.Task3.Employee;

import lombok.Getter;
import lombok.Setter;

public class Developer extends Employee {
    @Getter
    @Setter
    private double bonus;

    public Developer(double ratePerHour, int workdays) {
        super(ratePerHour, workdays);
        System.out.println("Developer war born");
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

}
