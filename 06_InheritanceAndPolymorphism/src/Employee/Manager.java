package Employee;

public class Manager implements Employee {
    private final double interest = 0.05;
    private final double salary = 45000.00;
    private final double minProfit = 115000.00;
    private final double maxProfit = 140000.00;
    private double profit;

    public Manager() {
        calculateProfit();
    }

    private void calculateProfit() {
        this.profit = Math.random() * (minProfit - maxProfit) + minProfit;
    }

    @Override
    public double getMonthSalary() {
        return salary + (profit * interest);
    }
}
