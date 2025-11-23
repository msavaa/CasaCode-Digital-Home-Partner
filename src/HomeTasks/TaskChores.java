package HomeTasks;

import HomeCommon.Input; // Holds the Scanner object
import HomeCommon.Manageable; // Holds the add, view, update, and delete
import java.util.ArrayList; 
import java.util.List; // Using this to store chores, etc,.

public class TaskChores implements Manageable { // Manages the chores and implements the Manageable method

    private final List<Chore> chores = new ArrayList<>(); // This stores all chores //Keyword "new" creates a new 'something'

   
    private abstract static class Chore { // Base class for specific chores po ito
        private String name; // chore name
        private String assignedTo;

        protected Chore(String name, String assignedTo) {
            this.name = name;
            this.assignedTo = assignedTo; 
        }

        public String getName() {
            return name;
        }

        public String getAssignedTo() {
            return assignedTo;
        }

        public void setName(String name) {
            if (name != null && !name.isEmpty()) {
                this.name = name;
            }
        }

        public void setAssignedTo(String assignedTo) {
            if (assignedTo != null && !assignedTo.isEmpty()) {
                this.assignedTo = assignedTo;
            }
        }

        public abstract void display();
    }

    // Daily chore
    private static class DailyChore extends Chore { // DailyChore as a subclass
        private String time;

        public DailyChore(String name, String assignedTo, String time) {
            super(name, assignedTo); // Uses super() to access the methods or constructors from the parent class and then this will enable the subclass to inherit those mthods and constructors.
            this.time = time != null ? time : "Not specified";
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            if (time != null && !time.isEmpty()) {
                this.time = time;
            }
        }

        @Override
        public void display() {
            System.out.printf("Daily Chore: %s assigned to %s at %s%n",
                getName(), getAssignedTo(), getTime());
        }
    }

    // Weekly chore
    private static class WeeklyChore extends Chore { // This is also a subclass.
        private int dayOfWeek;

        public WeeklyChore(String name, String assignedTo, int dayOfWeek) {
            super(name, assignedTo); // Uses super() to access the methods or constructors from the parent class and then this will enable the subclass to inherit those mthods and constructors.
            setDayOfWeek(dayOfWeek);
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }

        public void setDayOfWeek(int dayOfWeek) {
            if (dayOfWeek >= 1 && dayOfWeek <= 7) {
                this.dayOfWeek = dayOfWeek;
            } else {
                this.dayOfWeek = 1; 
            }
        }

        private String getDayName() {
            String[] days = {"", "Monday", "Tuesday", "Wednesday",
                             "Thursday", "Friday", "Saturday", "Sunday"};
            return days[dayOfWeek];
        }

        @Override
        public void display() {
            System.out.printf("Weekly Chore: %s assigned to %s on %s%n",
                              getName(), getAssignedTo(), getDayName());
        }
    }

    @Override
    public void add() { // Adds a new chore
        System.out.println("\n=== ADD NEW CHORE ===");
        System.out.println("1. Daily Chore");
        System.out.println("2. Weekly Chore");
        
        int type;

        while (true) { 
            type = readInt("Choose type (1 or 2): ");
            if (type == 1 || type == 2) {
                break;
            }
            System.out.println("Invalid input. Please choose 1 for Daily or 2 for Weekly.");
        }

        String name = readValidName("Enter chore name: ");
        String person = readValidPerson("Assigned to: ");

        if (type == 1) {
            String time = readValidTime("Time (e.g., 7:00 PM): ");
            chores.add(new DailyChore(name, person, time));
        } else {
            int day;
            while (true) { 
                day = readInt("Day of week (1=Monday, 7=Sunday): ");
                if (day >= 1 && day <= 7) {
                    break;
                }
                System.out.println("Invalid input. Please enter a day number between 1 and 7.");
            } 
            chores.add(new WeeklyChore(name, person, day));
        }

        System.out.println("Chore successfully added!\n");
    }

    @Override
    public void view() { // To list all the chores.
        System.out.println("\n=== CHORES TO DO:  ===");
        if (chores.isEmpty()) {
            System.out.println("(No chores assigned. You're free today!)\n");
            return;
        }

        System.out.println("Task Chores: ");
        System.out.println("-".repeat(68));
        for (int i = 0; i < chores.size(); i++) {
            System.out.printf("%2d. ", i + 1);
            chores.get(i).display();
        }
        System.out.println();
    }

    @Override
    public void update() { // To modify an existing chore.
        if (chores.isEmpty()) {
            System.out.println("No chores to update.\n");
            return;
        }

        view();
        
        int index;

        while (true) {
            index = readInt("Enter number to update (0 to cancel): ") - 1;

            if (index == -1) {
                System.out.println("Update canceled.\n");
                return;
            }

            if (index >= 0 && index < chores.size()) {
                break; // valid selection
            }

            System.out.println("Invalid selection. Please choose a valid number.\n");
            }


        Chore chore = chores.get(index);

        String newName = readValidNameAllowEmpty("New name (Enter to keep): ");
        if (!newName.isBlank()) chore.setName(newName);

        String newPerson = readValidPersonAllowEmpty("New person (Enter to keep): ");
        if (!newPerson.isBlank()) chore.setAssignedTo(newPerson);

        switch (chore) {
            case DailyChore daily -> {
                String newTime = readValidTimeAllowEmpty("New time (Enter to keep): ");
                if (!newTime.isBlank()) daily.setTime(newTime);
            }
            case WeeklyChore weekly -> {
                int newDay = readInt("New day (1-7, 0 to keep): ");
                if (newDay >= 1 && newDay <= 7) weekly.setDayOfWeek(newDay);
            }
            default -> {
            }
        }

        System.out.println("Chore updated successfully!\n");
    }

    @Override
    public void delete() { // To remove or delete a chore.
        if (chores.isEmpty()) {
            System.out.println("No chores to delete.\n");
            return;
        }

        view();

        int index;

        while (true) {
            index = readInt("Enter number to delete (0 to cancel): ") - 1;

            if (index == -1) {
                System.out.println("Delete canceled.\n");
                return;
            }

            if (index >= 0 && index < chores.size()) {
                break; // valid selection
            }

            System.out.println("Invalid number. Please choose a valid chore number.\n");
        }
        String removed = chores.remove(index).getName();
        System.out.println("Deleted: " + removed + "\n");
    }

    // Delete ALL chores (used for Delete All option)
    public void deleteAll() {
        chores.clear();
    }

    private int readInt(String prompt) { // This will loop until the user enters a valid number or integer.
        while (true) {
            System.out.print(prompt);
            if (Input.SCANNER.hasNextInt()) {
                int value = Input.SCANNER.nextInt();
                Input.SCANNER.nextLine();
                return value;
            }
            System.out.println("Error: Please enter a valid number.");
            Input.SCANNER.next(); 
        }
    }

    private String readValidName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = Input.SCANNER.nextLine().trim();

            if (input.matches("[A-Za-z ]{2,}")) {
                return input;
            }
            System.out.println("Invalid name. Please enter correct chore name (no numbers or symbols).");
        }
    }

    private String readValidPerson(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = Input.SCANNER.nextLine().trim();

            if (input.matches("[A-Za-z ]{2,}")) {
                return input;
            }
            System.out.println("Invalid input. Assigned person should contain correct name and letters only.");
        }
    }

    private String readValidTime(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = Input.SCANNER.nextLine().trim();

            if (input.matches("(?i)^([0-1]?\\d|2[0-3]):[0-5]\\d(\\s?(AM|PM))?$")) {
                return input;
            }
            System.out.println("Invalid time format. Example: 7:00 PM or 19:30");
        }
    }

    private String readValidNameAllowEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = Input.SCANNER.nextLine().trim();

            if (input.isBlank()) {
                return ""; // signal to caller to keep old value
            }

            if (input.matches("[A-Za-z ]{2,}")) {
                return input;
            }

            System.out.println("Invalid name. Please enter letters only (no numbers or symbols), or press Enter to keep the current name.");
        }
    }

    private String readValidPersonAllowEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = Input.SCANNER.nextLine().trim();

            if (input.isBlank()) {
                return "";
            }

            if (input.matches("[A-Za-z ]{2,}")) {
                return input;
            }

            System.out.println("Invalid input. Assigned person should contain letters only, or press Enter to keep the current person.");
        }
    }

    private String readValidTimeAllowEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = Input.SCANNER.nextLine().trim();

            if (input.isBlank()) {
                return "";
            }

            if (input.matches("(?i)^([0-1]?\\d|2[0-3]):[0-5]\\d(\\s?(AM|PM))?$")) {
                return input;
            }

            System.out.println("Invalid time format. Example: 7:00 PM or 19:30. Or press Enter to keep current time.");
        }
    }
}
