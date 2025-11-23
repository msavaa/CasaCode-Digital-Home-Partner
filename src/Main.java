import HomeBudget.Education;
import HomeBudget.EmergencyFund;
import HomeBudget.ExpensesCategories;
import HomeBudget.Groceries;
import HomeBudget.Health;
import HomeBudget.HouseFinance;
import HomeBudget.MonthlyBills;
import HomeCommon.Input;
import HomeRepair.RepairManager;
import HomeTasks.TaskChores;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = Input.SCANNER;

    // MAIN MENU 
    private static final String[] MAIN_MENU = {
            "[1]. Task Chores",
            "[2]. Repairs",
            "[3]. Budget",
            "[4]. View All",
            "[5]. Delete All",
            "[6]. Exit"
    };

    // TASK CHORES MENU 
    private static final String[] TASKS_MENU = {
            "1. Add Chore",
            "2. View Chores",
            "3. Update Chore",
            "4. Delete Chore",
            "5. Back to Main Menu"
    };

    // REPAIRS MENU
    private static final String[] REPAIRS_MENU = {
            "1. Add Repair Task",
            "2. View Repair Tasks",
            "3. Update Repair Task", 
            "4. Delete Repair Task",
            "5. Back to Main Menu"
    };

    // BUDGET MENU
    private static final String[] BUDGET_MENU = {
            "1. Enter Income",
            "2. Choose Expense Category + Budget Limit",
            "3. Expenses Breakdown",
            "4. Monthly Summary",
            "5. Reset Budget (Income & Categories)",
            "6. Back to Main Menu"
    };

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println();
            System.out.println("========== CASACODE: DIGITAL HOME PARTNER ==========");
            
            for (String option : MAIN_MENU) {
                System.out.println(option);
            }

            choice = user_choiceInt("Enter your choice: ");

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid choice. Please choose between 1 and 7.");
                continue;
            }

            switch (choice) {
                case 1 -> tasks_menu();
                case 2 -> repairs_menu();
                case 3 -> budget_menu();
                case 4 -> view_all();
                case 5 -> deleteAll();
                case 6 -> System.out.println("\nExiting CasaCode...");
            }
        } while (choice != 6);
    }

    // Task Chores Menu
    private static void tasks_menu() {
        int choice;

        do {
            System.out.println("\n=== TASK CHORES MENU ===");
            for (String option : TASKS_MENU) {
                System.out.println(option);
            }

            choice = user_choiceInt("Choose an option: ");

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid option. Please choose between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1 -> choreManager.add();
                case 2 -> choreManager.view();
                case 3 -> choreManager.update();
                case 4 -> choreManager.delete();
                case 5 -> System.out.println("\nReturning to Main Menu...");
            }
        } while (choice != 5);   
    }

    // Repairs Menu
    private static void repairs_menu() {
        int choice;

        do {
            System.out.println("\n=== REPAIRS MENU ===");
            for (String option : REPAIRS_MENU) {
                System.out.println(option);
            }

            choice = user_choiceInt("Choose an option: ");

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid option. Please choose between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1 -> repairManager.add();
                case 2 -> repairManager.view();
                case 3 -> repairManager.update();
                case 4 -> repairManager.delete();
                case 5 -> System.out.println("\nReturning to Main Menu...");
            }
        } while (choice != 5);  
    }

    // Budget Menu
    private static void budget_menu() {
        int choice;

        do {
            System.out.println("\n=== HOME BUDGET MENU ===");
            for (String option : BUDGET_MENU) {
                System.out.println(option);
            }

            choice = user_choiceInt("Choose an option: ");

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid option. Please choose between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    double isValidIncome = 0.0;
                    boolean validIncome = false;
                    
                    while (!validIncome) {
                        System.out.print("\nEnter your monthly income: ");
                        String incomeInput = scanner.nextLine();
                        try {
                            isValidIncome = Double.parseDouble(incomeInput.replace(",", ""));
                            validIncome = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for income.");
                        }
                    }
    
                    houseFinance.setIncome(isValidIncome);
                    System.out.println("Income is set to go!");
                }

                case 2 -> {
                    String Choice;

                    while (true) {
                        System.out.println("\nSelect Expense Category:");
                        System.out.println("A. Education");
                        System.out.println("B. Emergency Fund");
                        System.out.println("C. Groceries");
                        System.out.println("D. Health");
                        System.out.println("E. Monthly Bills");
                
                        System.out.printf("Select your category [A-E]: ");
                        Choice = scanner.nextLine().toUpperCase();

                        // Validating input is A-E only
                        if (Choice.matches("[A-E]")) {
                            break;
                        }
                        System.out.println("Invalid input. Please try again and select from A, B, C, D, or E.");
                    }

                    double limit = 0;
                    while (true) { 
                        System.out.print("\nSet your budget limit for this category: ");
                        String input = scanner.nextLine().replace(",", "");
                        try {
                            limit = Double.parseDouble(input);
                        break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for the budget limit.");
                        }
                    }

                    double spent = 0;
                    while (true) {
                        System.out.print("Enter amount spent in this category: ");
                        String input = scanner.nextLine().replace(",", "");
                        try {
                            spent = Double.parseDouble(input);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for amount spent.");
                        } 
                    }

                    System.out.println("");

                ExpensesCategories category = null;

                switch (Choice) {
                    case "A" -> category = new Education(limit);
                    case "B" -> category = new EmergencyFund(limit);
                    case "C" -> category = new Groceries(limit);
                    case "D" -> category = new Health(limit);
                    case "E" -> category = new MonthlyBills(limit);
                }

                if (category != null) {
                    category.setSpent(spent);
                    houseFinance.addCategory(category);

                    System.out.println(category.getName() + " added!");
                    System.out.println(category.getReminder());
                }
                break;
             }

                case 3 -> {
                    houseFinance.viewBreakdown();
                    break;
                }

                case 4 -> {
                    System.out.println("\n=== Monthly Summary ===\n");
                    
                    System.out.printf("Income: PHP %.2f\n", houseFinance.getIncome());
                    System.out.printf("Total Expenses: PHP %.2f.\n", houseFinance.getTotalExpenses());
                    System.out.printf("Remaining Balance: PHP %.2f\n", houseFinance.getRemainingBalance());
                    
                    if (houseFinance.getRemainingBalance() < 0) {
                    System.out.println("Warning: You have exceeded your budget!");
                    }

                    System.out.println("\n=== Expense Details ===");
                    if (houseFinance.expensesList.isEmpty()) {
                        System.out.println("(No expense categories have been added yet.)");
                    } else {
                        for (ExpensesCategories category : houseFinance.expensesList) {
                            System.out.printf("- %s: %s\n",
                                    category.getName(),
                                    category.getReminder());
                        }
                    }
                    break;
                }

                case 5 -> {

                    String resetChoice;

                    while (true) { 
                        System.out.print("Reset All? (Y/N): ");
                        resetChoice = scanner.nextLine().trim();
                    
                    if (resetChoice.equalsIgnoreCase("Y")) {
                        houseFinance.resetAll();
                        System.out.println("\nBudget has been reset.");
                        break;
                    } else if (resetChoice.equalsIgnoreCase("N")) {
                        System.out.println("\nReset cancelled.");
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again and choose between Y/y and N/n as Yes or No.");
                    }
                }
                }

                case 6 -> System.out.println("\nReturning to Main Menu...");
                }
                } while (choice != 6);  
    }
    
    private static final TaskChores choreManager = new TaskChores();
    private static final RepairManager repairManager = new RepairManager();
    private static final HouseFinance houseFinance = new HouseFinance();

    private static void view_all() {
        System.out.println("\n=== VIEW ALL DATA ===");

        System.out.println("\nTASK CHORES: ");
        choreManager.view();

        System.out.println("\nREPAIRS:");
        repairManager.view();

        System.out.println("\nHOME BUDGET:");
        houseFinance.viewBreakdown();
    }

    private static void deleteAll() {
        System.out.println("\n=== DELETE ALL DATA ===");

        System.out.println("""
    What would you like to delete?
    1. Task Chores only
    2. Repairs only
    3. Budget only
    4. ALL (Chores + Repairs + Budget)
    5. Cancel
    """);

        int choice = user_choiceInt("Enter your choice: ");

        switch (choice) {
            case 1 -> {
                System.out.print("Are you sure you want to delete ALL Task Chores? (Y/N): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                    choreManager.deleteAll();
                    System.out.println("\nAll Task Chores deleted!");
                } else {
                    System.out.println("\nCancelled.");
                }
            }
            case 2 -> {
                System.out.print("Are you sure you want to delete ALL Repairs? (Y/N): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                    repairManager.deleteAll();
                    System.out.println("\nAll Repairs deleted!");
                } else {
                    System.out.println("\nCancelled.");
                }
            }
            case 3 -> {
                System.out.print("Are you sure you want to delete ALL Budget Data? (Y/N): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                    houseFinance.deleteAll();
                    System.out.println("\nBudget reset and deleted!");
                } else {
                    System.out.println("\nCancelled.");
                }
            }
            case 4 -> {
                System.out.print("\nWARNING: This will delete EVERYTHING. Proceed? (Y/N): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                    choreManager.deleteAll();
                    repairManager.deleteAll();
                    houseFinance.deleteAll();
                    System.out.println("All data deleted!");
                } else {
                    System.out.println("\nCancelled.");
                }
            }
            case 5 -> System.out.println("\nDelete cancelled.");
            default -> System.out.println("\nInvalid option.");
        }
    }

    private static int user_choiceInt(String prompt) {
        int value = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); 
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        } // properly close while loop

        return value; // return after loop ends
    }
}
}
