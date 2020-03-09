package Main.Task3.Employee;

public class ScrumMaster extends Employee {
    public ScrumMaster(double ratePerHour, int workdays) {
        super(ratePerHour, workdays);
        System.out.println("ScrumMaster war hired");
    }
}
