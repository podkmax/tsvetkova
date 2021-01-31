package Employee;

public class Operator implements Employee {
    private final int salary = 50000;

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
