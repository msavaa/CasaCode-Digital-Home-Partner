CasaCode - Digital Home Partner
DESCRIPTION 
      
      Most households face increasing circumstances in managing daily responsibility due to busy schedules that lead for repairs to be delayed, often forgetting to do the chores, and to track the budget or expenses at home. With CasaCode: Digital Home Partner, this provides a home management system that is made to help users handle their daily household tasks in a smarter and more enjoyable way. Through this program, it lets users keep track of chores, manage their budget, and monitor home repairs—all in one organized system. The system supports full CRUD functions, allowing users to easily create, view, update, or delete records whenever needed. This will be developed using Object-Oriented Programming (OOP) principles like Encapsulation, Inheritance, Polymorphism, and Abstraction. It does not only demonstrate coding practices but also real-life functionality. To make things less boring, CasaCode includes fun reminders that humorously remind users to do or fix things around the house. Overall, it turns home management into something simple, efficient, and even a little entertaining.

OOP CONCEPTS APPLIED
CasaCode applies the four major Object-Oriented Programming (OOP) principles. These principles help us organize our program in making the system easier to maintain.

1. ENCAPSULATION: 
Within our system, Encapsulation is applied throughout the program by keeping the class fields private and then exposing them only through public methods such as the getters and setters. 
In the budget system, the ExpensesCategories() class hides its data fields such as the name, limit, and spent, so that they cannot be modified from the outside class. Instead, the program uses methods like getLimit(), setLimit(), getSpent(), and setSpent() to manage the values safely. 
This is also the same that is used in the HomeRepair(), where the Repair class keeps the place and item fields private and allows access only through getters and setters; getters: getPlace(), getItem(). And setters: setPlace(), setItem().
The TaskChores also uses encapsulation, with Chore, under DailyChore, and WeeklyChore classes that store fields such as name and assignedTo privately. From the private class DailyChore and WeeklyChore, we have a private class from both of them, private String name; and private String assignedTo;, which can only be accessed using the getters and setters, get and set Name and AssignedTo. This ensures that the chore names and assignments prevent unauthorized access.

2. INHERITANCE: 
In our system, inheritance is applied to avoid repeating the code and to create relationships between classes. It allows the child classes to reuse and extend the functionality of a parent class. 
In the HomeTasks package, inheritance is used through a base class Chore, which is extended by DailyChore and WeeklyChore. They inherit the shared attributes like name and assignedTo while adding their own features such as the time of the task or the day of the week. This shows how inheritance helps organize the structure of our system and reduce duplicated code.
For the Home Budget, inheritance can be seen as it receives the common properties or methods from a main or parent class. In the HomeBudget package, Education, EmergencyFund, Groceries, Health, and MonthlyBills all extend ExpensesCategories, which means they inherit budget-related fields and methods such as getBalance() and isWithinLimit(). This allows each child class to reuse the budgeting logic without rewriting it. 
This project has a Repair class that uses inheritance by implicitly extending Java’s built-in Object class, which gives it essential inherited behaviors, and its simple structure allows it to act as a base class that future repair types could extend making the Repair class a foundational parent for any more specific repair categories to add. The Repair class automatically inherits from Java’s built-in Object class, gaining essential core behaviors. The Repair class is intentionally designed as a simple, clean data model with private fields and public getters/setters, which makes it an ideal base class that could extend Repair and inherit its structure while adding their own unique properties. This allows our HomeRepair class to grow using inheritance while keeping all repair objects compatible with the same system.
Inheritance is used in our program to create more structured and reusable components in our project.

3. POLYMORPHISM: 
From the program, polymorphism was achieved through the use of abstract classes and overridden methods such as display in different chore types including the DailyChore and WeeklyChore, allowing flexible behavior. This also makes different manager classes like TaskChores and RepairManager that implement the same Manageable interface. Polymorphism allows different types to be treated uniformly through a shared parent type, enabling the system to call the same method on any repair object while still letting each subclass provide its own specialized behavior, which makes the repair management capable of handling new repair categories without modifying existing code.
Polymorphism allows our system to handle different chore types through a common interface. Both DailyChore and WeeklyChore extend the base Chore class and implement their own display methods, enabling flexible behavior while maintaining consistent treatment across all chore categories.
We can also see a polymorphism in ExpensesCategories, with the methods like getEducationReminder(), getEmergencyFundReminder(), and other reminders. Each child class overrides its corresponding reminder method to produce a unique message based on the category’s spending status. 

4. ABSTRACTION: 
The concept of Abstraction is applied through creating an interface class named Manager that helps the system to expose only essential features, such as create or add, view, update and delete. The system also includes abstract classes like Chore, supporting the polymorphism of display that has two sub-classes including the daily chore and weekly chore.

PROGRAM STRUCTURED

1, MAIN CLASS: 
The central controller of the program CasaCode that displays the system’s main menu and also handles the user’s navigation throughout the three modules: Task Chores, Home Repairs, and Home Budget. From this, the program takes the user’s input and runs a loop and uses switch cases, then guides them to the correct submenu. It also uses the shared Scanner from the Input class. Overall, the Main class is the command system that handles the input, menu display, and the method execution for all the other classes.

2. HOMETASKS CLASS: 
Manages household chores, incorporating daily and weekly tasks. It handles all operations involving chores, such as: Adding a chore, viewing all chores, updating a chore, deleting a chore. This class is where the logic for managing chores is implemented. It keeps a list of Chore objects (List<Chore> chores), fully implements the Manageable interface and controls all interaction with chore data:Creating new Chore objects--Reading and showing them--Editing existing ones--Removing them.

3. HOMEREPAIR CLASS: 
A class that handles all operations involving repairs, such as: Adding a repair, Viewing all repairs, Updating a repair, Deleting a repair. This class is where the logic for managing repairs is implemented. It keeps a list of Repair objects (List<Repair> repairs), fully implements the Manageable interface and controls all interaction with repair data: Creating new Repair objects--Reading and showing them--Editing existing ones--Removing them.

4. HOMEBUDGET CLASS:
The HomeBudget package is composed of several interconnected classes that work together to manage the financial planning. The parent class, ExpensesCategories, uses encapsulation to protect its field and provides getters, setters, and computations like checking the limit and balance remaining. By polymorphism and inheritance, the base class is extended by several categories such as: Education, EmergencyFund, Groceries, Health, and Monthly Bills—each overriding the reminder message get{Categories}Reminder() to reflect the category’s behavior.
While we have the HouseFinance that acts as the manager class and it stores the income values, handles multiple ExpensesCategories, computes the totals, and prints a complete budget breakdown. This also supports the deleting and resetting of all the budget data. Combining these, creates a flexible budgeting system that supports the category, the limits, expenses tracking and personalized financial reminder.

5. HOMECOMMON
The HomeCommon package  contains the shared components used by all modules to maintain the reusability and standardized logic.
MANAGEABLE.JAVA: 
- An abstract interface that provides core CRUD operations such as add, view, update and delete.
INPUT.JAVA: 
- A class that centralizes the input handling that ensures the entire program uses the Scanner. This prevents errors caused by creating multiple scanners and provides a cleaner input-handling system.

HOW TO RUN THE PROGRAM
- To run CasaCode: Digital Home Partner, do the following:

Requirements:
- Make sure your system has the Java Development Kit (JDK) installed (version 11 or later is recommended).
- Configure your JDK installation directory as the value of the JAVA_HOME environment variable.
- Make sure your system's PATH contains java and javac commands.

Compilation:
1. Save all Java files in the appropriate directory structure matching the package declarations.
2. Open a command prompt or terminal.
3. Navigate to the root directory containing the Main.java file.
4. Compile the code using the command: javac Main.java

Execution:
- Use the command java Main to launch the application or just find the run button on the upper right corner and press it to start the program. 
User Interface:
- The application will launch with a console-based user interface. To engage with the digital home management system, follow the menu prompts displayed on the screen. To choose menu selections and enter the needed information, enter the corresponding numbers.


SAMPLE OUTPUT
This is the Home Menu.
 The user chooses which system to open:
1 – Task Chores 2 – Repairs 3 – Budget 
4 – View all stored data 5 – Delete all 6 – Exit Program

<img width="622" height="189" alt="Screenshot 2025-11-26 181026" src="https://github.com/user-attachments/assets/9de52396-da38-461f-b585-856d2b86fd4b" />
- When the user chooses Task Chores from the main menu, the program shows:
This means the user must pick what they want to do with chores.

<img width="619" height="220" alt="image" src="https://github.com/user-attachments/assets/6d426bde-21f1-474d-b123-068714beeb36" />
- When the user chooses “Add Chore,” the program will ask several questions.
 These questions depend on your TaskChores code, but usually include things like:
* The name of the chore
* Whom it is assigned to
* The schedule

<img width="523" height="186" alt="image" src="https://github.com/user-attachments/assets/6ecf401d-fd4b-4122-a2cc-c5b2c92c1e44" />
- The program asks one question at a time and waits for the user to type an answer.

- After all answers are complete, it shows a confirmation message.
<img width="532" height="40" alt="image" src="https://github.com/user-attachments/assets/31b026b8-4385-48b0-9070-9257a972ae4d" />

- When the user chooses “View Chores,” the program displays all chores saved so far.
- Each chore is shown with its number and details.
<img width="618" height="108" alt="image" src="https://github.com/user-attachments/assets/a445081a-fb83-4005-ae96-7476af8668c5" />

- When the user chooses “Update Chore,” the program first shows a list of chores, like:
<img width="619" height="153" alt="image" src="https://github.com/user-attachments/assets/65c9370a-d5b5-4de5-8929-4e9c6ea5c504" />

- The user types the number of the chore they want to change.
- Then the program asks questions again, similar to adding a chore, such as:
<img width="603" height="180" alt="image" src="https://github.com/user-attachments/assets/2edf1cdd-39f3-42d1-98d2-fbbeaf3108f4" />

- When the user chooses “Delete Chore,” the program shows the list.
- When the user types the number, the program removes it and prints:
<img width="620" height="165" alt="image" src="https://github.com/user-attachments/assets/cabab360-87de-4e67-9789-762fb68bf643" />

- All the menu-related classes share the same output function because they inherit it from a common parent class, allowing them to use the same method while keeping their own specific display menu behaviors and messages that guide the user through creating, reading, updating, and deleting records fully applying CRUD using simple input and output interactions.

AUTHORS

Fajilan,  Klyxzl Ike Mico F.
Fiecas, Joshua Roi F.
Gonzales, Ava
Guirre, Christine Madel M.

ACKNOWLEDGEMENT

   First of all, the developers/programmers would like to give all the glory, honor and praise to our Almighty God for His faithfulness, guidance, wisdom and protection that He provided us throughout the journey of this project.

   The programmers would like to share and express their greatest gratitude to their professor, Mr. Jayson for his willingness in teaching every lesson, wisdom that he shares and patience he has for his students. His dedication to finish the lessons in teaching the students, helped them to learn, improve and explore in creating a system through Java programming language.

  To their parents, who have always supported them financially, emotionally and spiritually to accomplish this project. All their inspiring or encouraging messages everyday, helped them to keep going and pursuing the process in spite of everything with their guidance.

    Lastly, they would like to thank their fellow classmates and friends who's always willing to help one another, for simulating discussions and entertaining questions that helped them to improve more. To everyone who joined this journey, the unity, suggestions, and wisdom made the challenges bearable and achievable.

FUTURE ENHANCEMENT

For future improvements to the CasaCode system, it can focus on making the system more user-friendly and capable of supporting a wide range of household needs. One enhancement that the system can have is the addition of graphical user interface (GUI), which would allow the users to interact with the program through buttons, visual elements, and forms, instead of relying only on text-based commands. The system may also be upgraded by implementing notification features, such as the automated reminders for the chores, scheduled repairs, and budget warnings, that are delivered through email or mobile notifications.
For the HomeBudget package, features that can be added are savings goal tracking and visual expenses charts that could provide the users with clearer insights into their financial status. For the TaskChores and HomeRepair, improvements such as priority levels, deadlines, and progress indicators could help the user organize and manage their tasks more effectively.
Lastly, implementing a file-based storage system would enable the program to save and retrieve user’s data even after closing the application/system, making it more reliable and practical for long-term use. These future enhancements aim to elevate the system’s overall functionality and create a more modern and comprehensive home management tool.
