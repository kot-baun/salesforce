package Main;

import Main.Employees.Developer;
import Main.Employees.Employee;
import Main.Employees.Manager;
import Main.Employees.ScrumMaster;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        Company cat = new Company("Cat", 2000);
        Company dog = new Company("Dog", 5000);
        Company hamster = new Company("Hamster", 10000);

        Employee Ash = new Manager("Ash", 10, 10);
        Employee Ember = new Manager("Ember", 8, 10);
        Employee Equinox = new Manager("Equinox", 14, 10);
        Employee Excalibur = new Manager("Excalibur", 6, 10);

        Employee Ivara = new Developer("Ivara", 10, 10);
        Employee Loki = new Developer("Loki", 12, 10);
        Employee Nova = new Developer("Nova", 6, 10);

        Employee Octavia = new ScrumMaster("Octavia", 10, 5);
        Employee Rhino = new ScrumMaster("Rhino", 12, 5);
        Employee Trinity = new ScrumMaster("Trinity", 6, 5);

        cat.addEmployee(Ash);
        cat.addEmployee(Ember);
        cat.addEmployee(Loki);
        try {
            SalaryService.pay(cat);
        } catch (Exception e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
        System.out.println();
        dog.addEmployee(Ember);
        dog.addEmployee(Ivara);
        dog.addEmployee(Loki);
        dog.addEmployee(Octavia);
        dog.addEmployee(Ember);
        dog.giveBonus(Ember, 1000);
        dog.giveBonus(Ivara, 1000);
        dog.giveBonus(Loki, 999999999);
        try {
            SalaryService.pay(dog);
        } catch (Exception e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
        dog.setBudget(100);
        try {
            SalaryService.pay(dog);
        } catch (Exception e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }









}
