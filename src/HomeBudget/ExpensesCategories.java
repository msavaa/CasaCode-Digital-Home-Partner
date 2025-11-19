package HomeBudget; //HomeBudget is where related classes are stored.

public class ExpensesCategories {
    // This uses ENCAPSULATION - the fields are private and values can only change through setters and getters.
    private final String name;
    private double limit;
    private double spent;

    public ExpensesCategories(String name, double limit) {
        this.name = name;
        this.limit = limit;// user will be the one setting the limit
        this.spent = 0;
    }

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

    // For the remaining money.
    public double getBalance() {
        return limit - spent;
    }

    // To check if it is still within the budget.
    public boolean isWithinLimit() {
        return spent <= limit;
    }
    public void updateAllData(double limit, double spent) {
        setLimit(limit);
        setSpent(spent);
    }
    public void clearAllData() {
        setLimit(0);
        setSpent(0);
    }

    // This is also a POLYMORPHISM.
    public String getReminder() {
        return switch (name) {
            case "Education" -> getEducationReminder();
            case "Emergency Fund" -> getEmergencyFundReminder();
            case "Groceries" -> getGroceriesReminder();
            case "Health" -> getHealthReminder();
            case "Monthly Bills" -> getMonthlyBillsReminder();
            default -> "No reminder available for this category.";
        };
    }

    // This is a Polymorphism - as this is in the parent class method while the other one is at the child class (Education.ExpensesCategories) which overrides it. 
    // Has same method name (getEducationReminder, etc.,) but has different behavior - the parent returns an empty string while the child class returns a message.
    public String getEducationReminder() {
        return "";
    }
    public String getEmergencyFundReminder() {
        return "";
    }
    public String getGroceriesReminder() {
        return "";
    }
    public String getHealthReminder() {
        return "";
    }
    public String getMonthlyBillsReminder() {
        return "";
    }
}   
