package Main.Task3;

import Main.Task3.Employee.Developer;
import Main.Task3.Employee.Manager;

public class Main {


    public static void main(String[] args) throws Exception {
        Company company = new Company("aaa", 10000);
        company.getSalaryService().pay();

        company.addEmployee(new Manager(10, 21));
        company.addEmployee(new Developer(20, 21));
        company.addEmployee(new Developer(20, -21));
        try {
            company.setBonus(company.getEmployees().get(0), 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        company.getSalaryService().pay();

        try {
            company.setBonus(company.getEmployees().get(1), 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        company.getSalaryService().pay();

        try {
            company.setBonus(company.getEmployees().get(2), 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        company.getSalaryService().pay();


    }

}
