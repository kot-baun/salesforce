package Main.Employees;

import lombok.Getter;
import lombok.Setter;

public abstract class Employee {
    @Getter
    protected double ratePerHour;
    @Getter
    protected int workdays;
    @Getter
    protected String name;
//    Now it is not used, but will protect against collisions.
//    @Getter
//    @Setter
//    protected int ID;

    public double getSalary() {
        return ratePerHour * workdays * 8;
    }



}
