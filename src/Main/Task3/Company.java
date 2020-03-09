package Main.Task3;

import Main.Task3.Employee.Developer;
import Main.Task3.Employee.Employee;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import static Main.Task3.ColorANCII.RED;

public class Company implements ColorANCII{
    @Getter
    String name;
    @Getter
    double budget;
    @Getter
    private double availableBudget;
    @Getter
    private List<Employee> employees;
    private SalaryService salaryService;

    public Company(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.availableBudget = budget;
        this.employees = new ArrayList<>();
    }

    /**
     * Add an employee to the company
     *
     * @param employee
     */
    public synchronized void addEmployee(@NotNull Employee employee) {
        //do we have enough budget?
        if (employee.getSalary() > availableBudget)
            throw new IllegalArgumentException("a current employee isn't in budget with total salary at " + employee.getSalary() +
                    " , but available budget is " + availableBudget);
        if (employee.getSalary() <= 0)
            System.out.println(RED("I hope you know what you do. Employee salary less than zero"));
        employees.add(employee);
        availableBudget -= employee.getSalary();
    }

    /**
     * @return SalaryService, associated with this company
     */
    public SalaryService getSalaryService() {
        if (null == salaryService)
            salaryService = new SalaryService(this);
        return salaryService;
    }

    /**
     * calculates and returns the total salary, including bonuses
     *
     * @return salary
     */
    double getTotalSalary() {
        double result = 0.0;
        for (Employee employee : employees)
            result += employee.getSalary();
        return result;
    }

    /**
     * try to give bonuses to the employee
     * @param employee
     * @param bonus
     */
    public void setBonus(Employee employee, double bonus) {
        if(bonus > availableBudget)
            throw new IllegalArgumentException("Too many bonuses, not enough budget");

        try {
            Developer dev = (Developer) employee;
            dev.setBonus(bonus);
            availableBudget -= bonus;
        } catch (ClassCastException e) {
            System.err.println();
            throw new IllegalArgumentException("Only developer can have bonus, but current employee is " + employee.getClass().getSimpleName());
        }
    }


}
