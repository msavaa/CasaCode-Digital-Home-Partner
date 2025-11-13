package HomeBudget;

public class Personal extends ExpensesCategory {
    public Personal(double limit) {
        super("Personal", limit);
    }

    // Polymorphism 
    public String getPersonalReminder() {
        if (isitWithinLimit()) 
            return "A small treat here and there keeps life interesting, right?!";
        else 
            return "Uh-oh! Your personal expenses are getting a bit too personal for your wallet!";
    } 
}
