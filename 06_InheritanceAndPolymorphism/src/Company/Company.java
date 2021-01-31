package Company;

import Employee.Employee;
import Employee.Manager;
import Employee.Operator;
import Employee.TopManager;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Company {
    public ArrayList<Employee> listEmployee;
    private static double income;

    public Company() {
        listEmployee = new ArrayList<>();
    }

    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    public void hire(Employee employee) {
        listEmployee.add(employee);
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
     * Возвращает список сотрудников, отсортированных по убыванию зарплаты
     */
    public List<Employee> getTopSalaryStaff(int count) {
        return listEmployee.stream()
                .sorted(Comparator.comparingDouble(Employee::getMonthSalary).reversed())
//                .map(Employee::getMonthSalary)
//                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Возвращает список сотрудников, отсортированных по возрастанию зарплаты
     */
    public List<Employee> getLowestSalaryStaff(int count) {
        return listEmployee.stream()
                .sorted(Comparator.comparingDouble(Employee::getMonthSalary))
//                .map(Employee::getMonthSalary)
//                .distinct()
                .collect(Collectors.toList());
    }

    public void printSalary(List<Employee> list) {
        List<Double> salaryList = list.stream().map(Employee::getMonthSalary)
                .distinct()
                .collect(Collectors.toList());
        DecimalFormatSymbols formatter = new DecimalFormatSymbols(Locale.ENGLISH);
        formatter.setGroupingSeparator(' ');
        DecimalFormat decimalFormat = new DecimalFormat("###,###", formatter);
        for (int i = 0; i <= salaryList.size() - 1; i++) {
            System.out.println(decimalFormat.format(salaryList.get(i)) + " руб.");
        }
    }

    /**
     * Увольнение 50% случайных сотрудников
     */
    public void fireHalfRandomEmployee() {
        int laidOffAmount = (listEmployee.size() - 1) / 2;
        for (int i = 0; i <= laidOffAmount; i++) {
            int index = (int) (Math.random() * listEmployee.size()) /2;
            fire(listEmployee.get(index));
        }
    }

//    public void fireHalfEmployees() {
//        int operators = 0;
//        int managers = 0;
//        int topManagers = 0;
//        for (int i = 0; i <= listEmployee.size() - 1; i++) {
//            if (listEmployee.get(i) instanceof Operator && operators <= 90) {
//                fire(listEmployee.get(i));
//                operators++;
//            } else if (listEmployee.get(i) instanceof Manager && managers <= 40) {
//                fire(listEmployee.get(i));
//                managers++;
//            } else if (listEmployee.get(i) instanceof TopManager && topManagers <= 5) {
//                fire(listEmployee.get(i));
//                topManagers++;
//            }
//        }
//    }
}
