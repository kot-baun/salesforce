package Main;

import static Main.Main.*;

public class SalaryService {
    private Company company;


    private SalaryService(Company company) {
        this.company = company;
    }


    public static SalaryService builder(Company company) {
        return new SalaryService(company);
    }

    public static void pay(Company company) throws Exception {
        if (!company.checksAbilityToPay())
            throw new Exception(String.format("company %s inability to pay salary", company.getName()));

        System.out.printf(ANSI_GREEN + "company %s salary paid successfully\n" + ANSI_RESET, company.getName());
    }
}
