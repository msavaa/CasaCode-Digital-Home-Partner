package HomeBudget; //HomeBudget is where related classes are stored.

public class Health extends ExpensesCategories { // ExpensesCategories is the parent class. While the Health is the child class. 
    public Health(double limit) {
        super("Health", limit);
    }

    @Override
    public String getHealthReminder() {
        if (isWithinLimit())
            return "Nice! Health is wealth. Investing in your health is the best insurance!";
        else
            return "Whoa there, buddy! At this rate, your wallet might need medical attention too!";
    }
}
