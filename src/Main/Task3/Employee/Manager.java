package Main.Task3.Employee;

public class Manager extends Employee {
    public Manager(double ratePerHour, int workdays) {
        super(ratePerHour, workdays);
        System.out.println("Manager was hired");
    }
}
