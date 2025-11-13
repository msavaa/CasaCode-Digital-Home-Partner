package HomeBudget;

public class Health extends ExpensesCategory {
    public Health(double limit) {
        super("Health", limit);
    }

    // Polymorphism 
    public String getHealthReminder() {
        if (isitWithinLimit()) 
            return "Nice! Health is wealth. Investing in your health is the best insurance!";
        else 
            return "Whoa there, buddy! At this rate, your wallet might need medical attention too!";
    }
}
