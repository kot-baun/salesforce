package Main;

import Main.Employees.Developer;
import Main.Employees.Employee;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;

public class Company {
    @Getter
    private String name;
    @Setter
    private double budget;
    private List<Employee> employees;

    public Company(String name, double budget) {
        this.name = name;
        this.budget = budget;
        employees = new ArrayList<>();
    }

    /**
     * Try to add new employee to company.
     * Throw exception if employee already exist in company,
     * or company's free budget less than current employee salary.
     *
     * @param employee to add, cannot be a null value
     */
    public void addEmployee(@NonNull Employee employee) throws IllegalArgumentException {
        try {
            //may be current employee already exist?
            if (employees.stream().anyMatch(x -> x.getName().equals(employee.getName())))
                throw new IllegalArgumentException(String.format(
                        "current employer, %s, already exist\n", employee.getName()));

            //do we have enough budget?
            double totalSalary = calcTotalSalary();
            totalSalary += employee.getSalary();
            if (budget < totalSalary)
                throw new IllegalArgumentException(String.format(
                        "%s company have only %.2f available budget, but %s need %.2f\n",
                        this.getName(), this.availableBudget(), employee.getName(), employee.getSalary()));

            //if all tests pass, add it
            employees.add(employee);
            System.out.printf("company %s hire %s and still have %.2f available budget\n",
                    this.getName(), employee.getName(), this.availableBudget());
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }

    /**
     * Give bonuses to employee
     *
     * @param employee
     */
    public void giveBonus(Employee employee, double bonus) {
        try {
            synchronized (employee) {
                if (!(employee instanceof Developer))
                    throw new IllegalArgumentException(String.format("The current employee %s is not in the bonus program\n", employee.getName()));
                if (this.availableBudget() < bonus)
                    throw new IllegalArgumentException(String.format("The current employee %s bonus %.2f more then available budget(%.2f)\n",
                            employee.getName(), bonus, this.availableBudget()));

                ((Developer) employee).setBonuses(bonus);
                System.out.printf("employee %s have %.2f bonus\n", employee.getName(), bonus);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }

    private double calcTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees)
            totalSalary += employee.getSalary();
        return totalSalary;
    }

    public boolean checksAbilityToPay() {
        return budget > calcTotalSalary();
    }

    public double availableBudget() {
        return budget - calcTotalSalary();
    }

}
