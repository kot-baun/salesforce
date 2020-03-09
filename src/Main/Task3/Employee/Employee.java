package Main.Task3.Employee;

import Main.Task3.Main;

public abstract class Employee {
    double ratePerHour;
    int workdays;
    static int id = 0;
    String name;

    public Employee(double ratePerHour, int workdays) {
        this.ratePerHour = ratePerHour;
        this.workdays = workdays;
    }

//    public Employee(double ratePerHour, int workdays, String name) {
//        this.ratePerHour = ratePerHour;
//        this.workdays = workdays;
//        this.name = name + " id:" + id;
//        id++;
//    }
//
//    public Employee(double ratePerHour, int workdays, boolean addId) {
//        this.ratePerHour = ratePerHour;
//        this.workdays = workdays;
//        if (addId) {
//            this.name = "id:" + id;
//            this.id++;
//        }
//    }


    public double getSalary() {
        return ratePerHour * workdays * 8;
    }
}
