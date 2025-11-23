package HomeBudget; //HomeBudget is where related classes are stored.

import java.util.ArrayList;
import java.util.List;

public class HouseFinance {
    
    private double income = 0;
    public List<ExpensesCategories> expensesList = new ArrayList<>();

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public void addCategory(ExpensesCategories category) {
        expensesList.add(category);
    }

    public void resetAll() {
        income = 0;
        expensesList.clear();
    }

    public double getTotalExpenses() {
        double total = 0;
        for (ExpensesCategories category : expensesList) {
            total += category.getSpent();
        }
        return total;
    }

    public double getRemainingBalance() {
        return income - getTotalExpenses();
    }

    // This is where the Expenses Breakdown happens.
    public void viewBreakdown() {
        System.out.println("\n=== EXPENSES BREAKDOWN ===");
        
        // To check if the expenses list is empty then it will print the message.
        if (expensesList.isEmpty() && income == 0) {
            System.out.println("(No budget data yet.)");
            return;
        }
        // If the expenses list is not empty then it will return the Spent, Limit, and Balance.
        if (!expensesList.isEmpty()) {
            for (ExpensesCategories category : expensesList) {
                        System.out.printf("\n%s: Spent PHP%.2f | Limit PHP%.2f | Balance: PHP%.2f",
                                category.getName(),
                                category.getSpent(),
                                category.getLimit(),
                                category.getBalance());
            }
        } else {
            System.out.println("\nNo expense categories added yet.");
        }
    
        System.out.printf("\nTotal Expenses: PHP%.2f", getTotalExpenses());
        System.out.printf("\nRemaining Balance: PHP%.2f", getRemainingBalance());
        System.out.println("");
        if (getRemainingBalance() < 0) {
            System.out.println("Warning: You have exceeded your budget!");
        }
    }

    // If there is no budget data yet to delete.
    public void delete() {
        if (expensesList.isEmpty()) {
            System.out.println("\nNo budget data to delete.");
        }
    }
    // Delete ALL budget data (used for Delete All option)
    public void deleteAll() {
        resetAll();
    }
    // If there is no budget data yet to update.
    public void update() {
        if (expensesList.isEmpty()) {
            System.out.println("\nNo budget data to update.");
        }
    }
}
