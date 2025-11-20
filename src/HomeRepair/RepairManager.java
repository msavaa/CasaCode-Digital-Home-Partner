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

        System.out.print("What needs repair in the " + place + "? ");
        String item = Input.SCANNER.nextLine();

        if (item.isEmpty()) {
            System.out.println("Error: Item cannot be empty. Cancelled.\n");
            return;
        }

        repairs.add(new Repair(place, item));
        System.out.println("Success: Added \"" + item + "\" in " + place + "\n");
    }

    // view repairs
    @Override
    public void view() { // Show all pending repairs.
    System.out.println("\n=== PENDING REPAIRS ===");
    
    if (repairs.isEmpty()) {
        System.out.println("No repairs scheduled yet. Your home is perfect!\n");
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
    @Override
    public void update() { // Modify an existing repair.
        if (repairs.isEmpty()) { // If the list is empty it will print the message and then exits. 
            System.out.println("No repairs to update.\n");
            return;
        }

        view(); // Calling view to show the current entries.
        System.out.print("Enter number to update: ");
        int index = Input.SCANNER.nextInt() - 1;
        Input.SCANNER.nextLine();

        if (index < 0 || index >= repairs.size()) {
            System.out.println("Error: Invalid number!\n");
            return;
        }

        Repair r = repairs.get(index);

        System.out.print("New item name (blank = keep \"" + r.getItem() + "\"): ");
        String newItem = Input.SCANNER.nextLine();
        if (!newItem.isEmpty()) {
            r.setItem(newItem);  
        }

        System.out.print("New location (blank = keep \"" + r.getPlace() + "\"): ");
        String newPlace = Input.SCANNER.nextLine();
        if (!newPlace.isEmpty()) {
            r.setPlace(newPlace);  
        }

        System.out.println("Success: Repair updated!\n");
    }

    // Delete repair
    @Override
    public void delete() { // To remove a finished repair.
        if (repairs.isEmpty()) {
            System.out.println("No repairs to remove.\n");
            return;
        }

        view();
        System.out.print("Enter number of fixed repair to remove: ");
        int index = Input.SCANNER.nextInt() - 1;

        if (index >= 0 && index < repairs.size()) {
            Repair removed = repairs.remove(index);
            System.out.println("Success: Fixed & Removed → " + removed + "\n");
        } else {
            System.out.println("Error: Invalid number!\n");
        }
    }

    
}
