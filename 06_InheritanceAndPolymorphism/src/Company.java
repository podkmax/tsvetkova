import Employee.Employee;
import Employee.Manager;
import Employee.Operator;
import Employee.TopManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private static ArrayList<Employee> listEmployee;
    private static double income;

    public static void main(String[] args) {
        Company company = new Company();
        company.hireAll(10, 80, 180); // нанять полный штат
        System.out.println("Полный штат " + listEmployee.size());
        System.out.println("Доход компании " + (int) company.getIncome());
        System.out.println("Список самых высоких зарплат");
        company.printHighSalary();
        System.out.println("Список самых низких зарплат");
        company.printLowSalary();
        company.fireHalfEmployee();
        System.out.println("Увольнение 50% сотрудников. Штат: " + listEmployee.size());
        System.out.println("Список самых высоких зарплат");
        company.printHighSalary();
        System.out.println("Список самых низких зарплат");
        company.printLowSalary();
//        System.out.println("Количество сотрудников " + listEmployee.size());
//        // увольнение 50% штата
//        for (int u = 0; u < (int) (listEmployee.size() * 0.5); u++) {
//            company1.fire();
//        }
//        System.out.println("Количество сотрудников " + listEmployee.size());
//
//        //      печать списка
//        for (Employee employee : listEmployee) {
//            System.out.println(employee + " " + employee.getMonthSalary());
//        }

    }

    public Company() {
        listEmployee = new ArrayList<>();
    }

    public void hire() {
        listEmployee.add(new TopManager(getIncome()));
        listEmployee.add(new Manager());
        listEmployee.add(new Operator());
    }

    public void hireAll(int countTopManager, int countManager, int countOperator) {
        for (int j = 0; j < countManager; j++) {
            listEmployee.add(new Manager());
        }
        for (int y = 0; y < countOperator; y++) {
            listEmployee.add(new Operator());
        }
        for (int i = 0; i < countTopManager; i++) {
            listEmployee.add(new TopManager(getIncome()));
        }
    }

    public void fire(Employee employee) {
        if (!listEmployee.isEmpty()) {
            listEmployee.remove(employee);
            listEmployee.trimToSize();
        } else {
            System.out.println("Список пуст");
        }
    }

    public double getIncome() {
        for (int i = 0; i < listEmployee.size(); i++) {
            income = income + listEmployee.get(i).getMonthSalary();
        }
        return income;
    }

    /**
     * Распечатывает на экране 15 самых высоких зарплат
     */
    public void printHighSalary() {
        List<Double> employeeBySalary = listEmployee.stream()
                .sorted(Comparator.comparingDouble(Employee::getMonthSalary).reversed())
                .map(Employee::getMonthSalary)
                .distinct()
                .collect(Collectors.toList());
        for (int i = 0; i <= 15; i++) {
            System.out.format("%.2f\n", employeeBySalary.get(i));
        }
    }

    /**
     * Распечатывает на экране 30 самых низких зарплат
     */
    public void printLowSalary() {
        List<Double> employeeBySalary = listEmployee.stream()
                .sorted(Comparator.comparingDouble(Employee::getMonthSalary))
                .map(Employee::getMonthSalary)
                .distinct()
                .collect(Collectors.toList());
        for (Double aDouble : employeeBySalary) {
            System.out.format("%.2f\n", aDouble);
        }
    }

    /**
     * Увольнение 50% случайных сотрудников
     */
    public void fireHalfEmployee() {
        int laidOffAmount = (listEmployee.size() - 1) / 2;
        for (int i = 0; i <= laidOffAmount; i++) {
            int index = (int) (Math.random() * listEmployee.size()) /2;
            fire(listEmployee.get(index));
        }
    }
}
