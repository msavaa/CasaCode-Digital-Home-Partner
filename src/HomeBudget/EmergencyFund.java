package HomeBudget;

public class EmergencyFund extends ExpensesCategory {
    public EmergencyFund(double limit) {
        super("Emergency Fund", limit);
    }

    // Polymorphism 
    public String getEmergencyFundReminder() {
        if (isitWithinLimit()) 
            return "Smart move! Future you just smiled.";
        else 
            return "If this is an emergency, your wallet definitely knows the feeling now!";
    }
}
