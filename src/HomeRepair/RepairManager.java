package HomeRepair;

import HomeCommon.Input; // Holds the Scanner object
import HomeCommon.Manageable; // Holds the add, view, update, and delete
import java.util.ArrayList;
import java.util.List; // Using this to store repairs, etc,.

class Repair { // Stores details about what needs to repair.
    private String place;
    private String item;

   
    public Repair(String place, String item) {
        this.place = place;
        this.item = item;
    }

    // Allows to read the place and item.
    public String getPlace() {
        return place;
    }

    public String getItem() {
        return item;
    }

    // Setters allows to change the place or item.
    public void setPlace(String place) {
        this.place = place;
    }

    public void setItem(String item) {
        this.item = item;
    }

    // Prints the repair
    public void show() {
        System.out.println(" " + item + " in " + place);
    }

    @Override
    public String toString() { // toString returns a string 
        return item + " in " + place;
    }
}


public class RepairManager implements Manageable { // This manages a list of repairs.

    private final List<Repair> repairs = new ArrayList<>(); // This stores all repair entries, the final means it won't be reassigned but the contents can change.

    // Add new repair
    @Override
    public void add() {
        System.out.println("\n=== ADD NEW REPAIR ===");
        System.out.println("[1] Garage      [2] Living Room");
        System.out.println("[3] Kitchen     [4] Bedroom");
        System.out.print("Choose location (1-4): ");

        int choice = Input.SCANNER.nextInt();
        Input.SCANNER.nextLine(); 

        String place;

        place = switch (choice) { // switch - modern java style - to make it more cleaner
            case 1 -> "Garage";
            case 2 -> "Living Room";
            case 3 -> "Kitchen";
            case 4 -> "Bedroom";
            default -> "Other Room";
        };

        String item;
        while (true) {
            System.out.print("\nWhat needs repair in the " + place + "? ");
            item = Input.SCANNER.nextLine().trim();

            if (item.isEmpty()) {
                System.out.println("Error: Item cannot be empty. Try again.\n");
                continue;
            }

            if (!item.matches("[A-Za-z ]+")) {
                System.out.println("Error: Enter letters only. Try again.\n");
                continue;
            }

            if (item.length() < 2) {
                System.out.println("Error: Input too short. Enter a more specific item.\n");
                continue;
            }
            break; // Input valid
        }
        repairs.add(new Repair(place, item));
        System.out.println("Success: Repair added! [" + item + " in " + place + "]\n");
    }

    // view repairs
    @Override
    public void view() { // Show all pending repairs.
    System.out.println("\n=== PENDING REPAIRS ===");
    
    if (repairs.isEmpty()) {
        System.out.println("(No repairs scheduled yet. Your home is perfect!)\n");
    } else {
        System.out.println("Total repairs to do: " + repairs.size());
        System.out.println("---------------------------");
        for (int i = 0; i < repairs.size(); i++) {
            System.out.print((i + 1) + ". ");
            repairs.get(i).show();  
        }
        System.out.println(); 
    }
}
    // Update repair
    // Update repair
    @Override
    public void update() { // Modify an existing repair.
        if (repairs.isEmpty()) { // If the list is empty it will print the message and then exits. 
            System.out.println("No repairs to update.\n");
            return;
        }

        view(); // Calling view to show the current entries.
        int index = -1;
        while (true) {
            System.out.print("Enter number to update (0 to cancel): ");

            if (!Input.SCANNER.hasNextInt()) {
                System.out.println("Error: Please enter a valid number!\n");
                Input.SCANNER.nextLine();
                continue;
            }

            index = Input.SCANNER.nextInt();
            Input.SCANNER.nextLine();

            if (index == 0) {
                System.out.println("\nUpdate cancelled.\n");
                return;
            }
            index--; // convert to 0-based index

            if (index < 0 || index >= repairs.size()) {
                System.out.println("Error: Invalid number! Try again.\n");
                continue;
            }
            break;
        }
        Repair r = repairs.get(index);

        // ----- New Item (validate letters & length, allow blank to keep, allow cancel) -----
        String newItem;
        while (true) {
            System.out.print("\nNew item name (blank = keep \"" + r.getItem() + "\"): ");
            newItem = Input.SCANNER.nextLine().trim();

            if (newItem.isEmpty()) {
                // user chooses to keep current item
                break;
            }

            if (!newItem.matches("[A-Za-z ]+")) {
                System.out.println("Error: Enter letters and spaces only. Try again.");
                System.out.print("\nRetry (Y) / Cancel update (C) / Keep current (K): ");
                String opt = Input.SCANNER.nextLine().trim();
                if (opt.equalsIgnoreCase("C")) {
                    System.out.println("\nUpdate cancelled.\n");
                    return;
                } else if (opt.equalsIgnoreCase("K")) {
                    newItem = ""; // treat as keep current
                    break;
                } else {
                    // loop to retry
                    continue;
                }
            }

            if (newItem.length() < 2) {
                System.out.println("Error: Input too short. Enter a more specific item.");
                System.out.print("\nRetry (Y) / Cancel update (C) / Keep current (K): ");
                String opt = Input.SCANNER.nextLine().trim();
                if (opt.equalsIgnoreCase("C")) {
                    System.out.println("\nUpdate cancelled.\n");
                    return;
                } else if (opt.equalsIgnoreCase("K")) {
                    newItem = "";
                    break;
                } else {
                    continue;
                }
            }
            // valid newItem
            break;
        }

        if (!newItem.isEmpty()) {
            r.setItem(newItem);
        }
        // ----- New Place (validate letters & length, allow blank to keep, allow cancel) -----
        String newPlace;
        while (true) {
            System.out.print("\nNew location (blank = keep \"" + r.getPlace() + "\"): ");
            newPlace = Input.SCANNER.nextLine().trim();

            if (newPlace.isEmpty()) {
                // keep current place
                break;
            }

            if (!newPlace.matches("[A-Za-z ]+")) {
                System.out.println("Error: Enter letters and spaces only. Try again.");
                System.out.print("\nRetry (Y) / Cancel update (C) / Keep current (K): ");
                String opt = Input.SCANNER.nextLine().trim();
                if (opt.equalsIgnoreCase("C")) {
                    System.out.println("\nUpdate cancelled.\n");
                    return;
                } else if (opt.equalsIgnoreCase("K")) {
                    newPlace = "";
                    break;
                } else {
                    continue;
                }
            }

            if (newPlace.length() < 2) {
                System.out.println("Error: Input too short. Enter a more specific location.");
                System.out.print("\nRetry (Y) / Cancel update (C) / Keep current (K): ");
                String opt = Input.SCANNER.nextLine().trim();
                if (opt.equalsIgnoreCase("C")) {
                    System.out.println("\nUpdate cancelled.\n");
                    return;
                } else if (opt.equalsIgnoreCase("K")) {
                    newPlace = "";
                    break;
                } else {
                    continue;
                }
            }
            // valid newPlace
            break;
        }

        if (!newPlace.isEmpty()) {
            r.setPlace(newPlace);
        }
        System.out.println("Success: Repair updated!\n");
    }


    // Delete repair
    // Delete repair
    @Override
    public void delete() {
        if (repairs.isEmpty()) {
            System.out.println("No repairs to delete.\n");
            return;
        }

        // Show current list (like Update)
        System.out.println("\n=== Repair Task ===");
        System.out.println("Total Repairs: " + repairs.size());
        System.out.println("---------------------------");
        for (int i = 0; i < repairs.size(); i++) {
            System.out.println((i + 1) + ".  " + repairs.get(i));
        }
        System.out.println();

        int index = -1;
        while (true) {
            System.out.print("Enter number of fixed repair to remove: ");

            if (!Input.SCANNER.hasNextInt()) {
                System.out.println("Error: Please enter a valid number!\n");
                Input.SCANNER.nextLine();
                continue;
            }
            index = Input.SCANNER.nextInt() - 1;
            Input.SCANNER.nextLine();

            if (index < 0 || index >= repairs.size()) {
                System.out.println("Error: Invalid number! Try again.\n");
                continue;
            }
            break; // Valid input
        }

        // Remove the chosen repair and confirm success
        Repair removed = repairs.remove(index);
        System.out.println("Success! You fixed and removed: " + removed + "\n");
    }
    // Delete ALL repairs (used for Delete All option)
    public void deleteAll() {
        repairs.clear();
    }
}
