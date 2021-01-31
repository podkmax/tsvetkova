package Employee;

public class TopManager implements Employee {
    private final double interest = 1.5; // бонус Топ-менеджера
    private final double salary = 200000.00;
    private final double profitLimit = 10000000.00; // предельная сумма
    private final double companyProfit;

    public TopManager (double companyProfit) {
        this.companyProfit = companyProfit;
    }

    @Override
    public double getMonthSalary() {
        if (companyProfit > profitLimit) {
            return interest * salary;
        }
        return salary;
    }
}
