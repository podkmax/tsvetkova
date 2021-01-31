package Employee;

public class Operator implements Employee {
    private final double salary = 50000.00;

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
