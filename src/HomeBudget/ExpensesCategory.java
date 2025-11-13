package HomeBudget;

public class ExpensesCategory {
    private final String name;
    private double limit;
    private double spent;

    public ExpensesCategory(String name, double limit) {
        this.name = name;
        this.limit = limit;
        this.spent = 0.0; // This is set to zero pa // Why? Because no spending has occurred yet
    }

    // Encapsulation (getters and setters)
    public String getName() {
        return name;
    }
    public double getLimit() {
        return limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public double getSpent() {
        return spent;
    }
    public void setSpent(double spent) {
        this.spent = spent;
    }
    // This is to get the Balance 
    public double getBalance() { 
        return limit - spent; 
    }
    // Purpose of this is to know if the spending is within the limit
    public boolean isitWithinLimit() {
        return spent <= limit;
    }


    // We can put here a default reminder message so that when spending is updated, we can notify the user
    public String getReminder() {
        return "Keep tracking your expenses wisely here in CasaCode!";
    }
}
