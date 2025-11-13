package HomeBudget;

public class Education extends ExpensesCategory {
    public Education(double limit) {
        super("Education", limit);
    }

    // Polymorphism 
    public String getEducationReminder() {
        if (isitWithinLimit()) 
            return "Knowledge is power — and apparently still affordable!";
        else 
            return "Wow, education costs are skyrocketing! Time to hit the books on budgeting!";
    }  
}
