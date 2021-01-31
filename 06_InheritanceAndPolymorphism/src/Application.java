import Company.Company;
import Employee.Employee;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Company company = new Company();
        company.hireAll(10, 80, 180); // нанять полный штат
        System.out.println("Полный штат " + company.getListEmployee().size());
        System.out.println("Доход компании " + (int) company.getIncome());
        System.out.println("Список самых высоких зарплат");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        company.printSalary(topSalaryStaff);
        System.out.println("Список самых низких зарплат");
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
        company.printSalary(lowestSalaryStaff);
        company.fireHalfRandomEmployee();
//        company.fireHalfEmployees();
        System.out.println("Увольнение 50% сотрудников. Штат: " + company.getListEmployee().size());
        System.out.println("Список самых высоких зарплат");
        company.printSalary(company.getTopSalaryStaff(15));
        System.out.println("Список самых низких зарплат");
        company.printSalary(company.getLowestSalaryStaff(30));
        System.out.println("Количество сотрудников " + company.getListEmployee().size());
    }
}
