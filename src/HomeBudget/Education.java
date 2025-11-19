package HomeBudget; //HomeBudget is where related classes are stored.

// This is an INHERITANCE.

public class Education extends ExpensesCategories { // ExpensesCategories is the parent class. While the Education is the child class. 
    // Education inherits all the methods from ExpensesCategories
    public Education(double limit) {
        super("Education", limit);  // "super" helps us to call the parent class
        // limit is for whatever the user wants to enter.
    }

    @Override // This is a method overriding
    public String getEducationReminder() { 
    // This is a POLYMORPHISM - as this is in the parent class method while the other one is at the child class (Education.ExpensesCategories) which overrides it. 
    // Has same method name (getEducationReminder, etc.,) but has different behavior - the parent returns an empty string while the child class returns a message.
        if (isWithinLimit())
            return "Knowledge is power - and apparently still affordable!";
        else
            return "Wow, education costs are skyrocketing! Time to hit the books on budgeting!";
    }
}
