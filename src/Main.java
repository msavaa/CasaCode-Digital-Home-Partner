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
            "[5]. Update All",
            "[6]. Delete All",
            "[7]. Exit"
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
                case 5 -> updateAll();
                case 6 -> deleteAll();
                case 7 -> System.out.println("Exiting CasaCode...");
            }
        } while (choice != 7);
    }

    // Task Chores Menu
    private static void tasks_menu() {
        int choice;

        do {
            System.out.println("\n=== Task Chores Menu ===");
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
                case 5 -> System.out.println("Returning to Main Menu...");
            }
        } while (choice != 5);   
    }

    // Repairs Menu
    private static void repairs_menu() {
        int choice;

        do {
            System.out.println("\n=== Repairs Menu ===");
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
                case 5 -> System.out.println("Returning to Main Menu...");
            }
        } while (choice != 5);  
    }

    // Budget Menu
    private static void budget_menu() {
        int choice;

        do {
            System.out.println("\n=== Home Budget Menu ===");
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
                        System.out.print("Enter your monthly income: ");
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
                    System.out.println("\n=== Monthly Summary ===");
                    
                    System.out.printf("This month you have spent a total of PHP%.2f.\n",
                            houseFinance.getTotalExpenses());
            
                    System.out.println("\n=== Expense Details ===");

                    for (ExpensesCategories category : houseFinance.expensesList) {
                        System.out.println(category.getName() + ": " + category.getReminder());
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
                        System.out.println("Budget has been reset.");
                        break;
                    } else if (resetChoice.equalsIgnoreCase("N")) {
                        System.out.println("Reset cancelled.");
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again and choose between Y/y and N/n as Yes or No.");
                    }
                }
                }

                case 6 -> System.out.println("Returning to Main Menu...");
                }
                } while (choice != 5);  
    }
    
    private static final TaskChores choreManager = new TaskChores();
    private static final RepairManager repairManager = new RepairManager();
    private static final HouseFinance houseFinance = new HouseFinance();

    private static void view_all() {
        System.out.println("\n=== VIEW ALL DATA ===");

        System.out.println("\nTask Chores: ");
        choreManager.view();

        System.out.println("\nRepairs:");
        repairManager.view();

        System.out.println("\nHome Budget:");
        houseFinance.viewBreakdown();
    }

    private static void deleteAll() {
        System.out.println("\n=== DELETE ALL DATA ===");

        choreManager.delete();   
        repairManager.delete();  
        houseFinance.delete();
    }

    private static void updateAll() {
        System.out.println("\n=== UPDATE ALL DATA ===");

        choreManager.update();   
        repairManager.update(); 
        houseFinance.update(); 
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

    public static TaskChores getChoreManager() {
        return choreManager;
    }
}

