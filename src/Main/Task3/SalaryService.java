package Main.Task3;

import org.jetbrains.annotations.NotNull;

public class SalaryService {
    private Company company;

    public SalaryService(@NotNull Company company) {
        this.company = company;
    }

    /**
     * Check, if company has the ability to pay salaries
     * @param company company to check
     * @throws Exception will throw, if company have no ability to pay salaries
     */
    public static void pay(@NotNull Company company) throws Exception {
        if (company.getTotalSalary() > company.getBudget())
            throw new Exception(String.format("Companies %s need %f , but there are only %f . This is the reason for this exception",
                    company.getName(), company.getTotalSalary(), company.getBudget()));
        System.out.println("The company has the ability to pay salaries. Budget balance "+ company.getAvailableBudget());
    }
    /**
     * Check, if associated to service company has the ability to pay salaries
     * @throws Exception will throw, if company have no ability to pay salaries
     */
    public void pay() throws Exception {
        pay(company);
    }
}
