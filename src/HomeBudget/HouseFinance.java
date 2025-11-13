package HomeBudget;

import java.util.ArrayList;
import java.util.List;

public class HouseFinance {
    private double income;
    private final List<ExpensesCategory> categories;

    public HouseFinance() {
        categories = new ArrayList<>();
    }

    // Here is the Encapsulation (getters and setters)
    public double getIncome() { 
        return income; }
        
        public void setIncome(double income) 
        { this.income = income; }

        public List<ExpensesCategory> getCategories() 
        { return categories; }

        // Here is the CRUD Functions
        public void addCategory(ExpensesCategory category) 
        { categories.add(category);
    }

    // This is for the Spending
    public void updateSpending(String categoryName, double spent) {
        for (ExpensesCategory category : categories) { // This will loop through the categories
            if (category.getName().equalsIgnoreCase(categoryName)) {
                category.setSpent(spent);
                System.out.println(category.getReminder());
                break;
            }
        }
    }

    // This is for the delete
    public void deleteCategory(String categoryName) {
        categories.removeIf(category -> category.getName().equalsIgnoreCase(categoryName));
    }

    // This is the Breakdown of Expenses
    public void viewBreakdown() {
        System.out.println("\n---- EXPENSES BREAKDOWN ----");
        double TotalExpenses = 0;
        for (ExpensesCategory category : categories) {
            System.out.printf("%s: Spent ₱%.2f / Limit  ₱%.2f | Balance:  ₱%.2f\n",
                    category.getName(),
                    category.getSpent(),
                    category.getLimit(),
                    category.getBalance());
                    TotalExpenses += category.getSpent();
        }
        System.out.printf("\nTotal Expenses:  ₱%.2f\n", TotalExpenses);
        System.out.printf("Remaining Balance:  ₱%.2f\n", income - TotalExpenses);
        
        if (TotalExpenses > income) {
            System.out.println("Warning ⚠️: You're wallet is dry!");
        }

        System.out.println("\nMonthly Summary: ");
        System.out.printf("This month you have spent ₱%.2f in %d categories.\n", TotalExpenses, categories.size());
    }
}
