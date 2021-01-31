package Employee;

public class Manager implements Employee {
    private final double interest = 0.05;
    private final int salary = 45000;
    private final int minProfit = 115000;
    private final int maxProfit = 140000;
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
