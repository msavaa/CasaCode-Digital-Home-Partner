package HomeBudget;

public class Groceries extends ExpensesCategory {
    public Groceries(double limit) {
        super("Groceries", limit);
    }

    // Polymorphism 
    public String getGroceriesReminder() {
        if (isitWithinLimit()) 
            return "Well done! Smart grocery shopping keeps your belly and wallet full!";
        else 
            return "Wow, planning to feed a whole village? Maybe check your fridge first!";
    }
}
