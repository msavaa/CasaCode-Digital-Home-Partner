package HomeBudget;

public class MonthlyBills extends ExpensesCategory {
    public MonthlyBills(double limit) {
        super("Monthly Bills", limit);
    }

    // Polymorphism 
    public String getMonthlyBillsReminder() {
        if (isitWithinLimit()) 
            return "Wow! Paying your bills on time keeps the lights on and stress off!";
        else 
            return "Yikes! Your bills are higher than your hopes! Maybe turn off a few lights or faucet?";
    }  
}
