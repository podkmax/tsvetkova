package Employee;

public interface Employee extends Comparable <Employee> {

    double getMonthSalary();

    @Override
    default int compareTo(Employee employee) {
        if (getMonthSalary() > employee.getMonthSalary()) {
            return 1;
        } else if (getMonthSalary() < employee.getMonthSalary()) {
            return -1;
        }
        return 0;
    }
}
