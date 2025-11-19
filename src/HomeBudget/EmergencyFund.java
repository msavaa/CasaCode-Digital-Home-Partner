package HomeBudget; //HomeBudget is where related classes are stored.

// This is an INHERITANCE.

public class EmergencyFund extends ExpensesCategories { // ExpensesCategories is the parent class. While the EmergencyFund is the child class.
    public EmergencyFund(double limit) {
        super("Emergency Fund", limit);
    }

    @Override
    public String getEmergencyFundReminder() {
    // This is a POLYMORPHISM - as this is in the parent class method while the other one is at the child class (EmergencyFund.ExpensesCategories) which overrides it. 
    // Has same method name (getEmergencyFundReminder, etc.,) but has different behavior - the parent returns an empty string while the child class returns a message.

        if (isWithinLimit())
            return "Smart move! Future you just smiled.";
        else
            return "If this is an emergency, your wallet definitely knows the feeling now!";
    }
}
