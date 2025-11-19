package HomeBudget; //HomeBudget is where related classes are stored.

public class Groceries extends ExpensesCategories { // ExpensesCategories is the parent class. While the Groceries is the child class. 
    public Groceries(double limit) {
        super("Groceries", limit);
    }

    @Override
    public String getGroceriesReminder() {
        if (isWithinLimit())
            return "Well done! Smart grocery shopping keeps your belly and wallet full!";
        else
            return "Wow, planning to feed a whole village? Maybe check your fridge first!";
    }
}
