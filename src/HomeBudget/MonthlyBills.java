package HomeBudget; //HomeBudget is where related classes are stored.

public class MonthlyBills extends ExpensesCategories { // ExpensesCategories is the parent class. While the MonthlyBills is the child class. 
    public MonthlyBills(double limit) {
        super("Monthly Bills", limit);
    }

    @Override
    public String getMonthlyBillsReminder() {
        if (isWithinLimit())
            return "Wow! Paying your bills on time keeps the lights on and the stress off!";
        else
            return "Yikes! Your bills are higher than your hopes! Maybe turn off a few lights or faucets?";
    }
}
