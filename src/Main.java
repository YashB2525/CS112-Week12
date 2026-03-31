import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Kyle Meikle's Class -  Main Class

public class Main {
    // Initialises all objects to be used across the class and its methods
    private static Scanner scanner = new Scanner(System.in);
    private static RecordManager manager = new RecordManager();
    private static FileHandler handler = new FileHandler("testFile.txt");

    public static void main(String[] args) {
        int choice = 0;
        displayMenu();

        // Sets up a loop that will repeatedly allow the user to see the menu and select an option
        // Unless option 5 to exit is chosen, it also ensures only one of the 5 options can be selected
        while (choice != 5) {
            try {
                System.out.print("Please enter and available option (1-5): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                menuChoice(choice);
            }
            catch (InputMismatchException | IOException e) {
                System.out.println("An integer must be entered");
                scanner.nextLine();
            }

        }
    }

    //Display the menu and all available options to the user
    private static void displayMenu() {
        System.out.println(" \n Book Management Menu");
        System.out.println("1. Add Book");
        System.out.println("2. Display Books");
        System.out.println("3. Save Records");
        System.out.println("4. Load Records");
        System.out.println("5. Exit");
    }

    // Handles the user's choice in the menu and calls the coresponding methods
    public static void menuChoice(int choice) throws IOException {
        switch (choice) {
            case 1:
                addBookRecord();
                displayMenu();
                break;
            case 2:
                manager.displayAllRecords();
                displayMenu();
                break;
            case 3:
                saveAllRecords();
                displayMenu();
                break;
            case 4:
                loadAllRecords();
                displayMenu();
                break;
            case 5:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid choice, please try again");
                displayMenu();
        }
    }

    // Creates a book class with user input and adds it to the list of records
    public static void addBookRecord() {
        try{
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Author: ");
            String author = scanner.nextLine();

            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            BookRecord book = new BookRecord(title, author, year);;
            System.out.println("Book added");
            manager.addRecord(book);
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter a whole number for the year");
            scanner.nextLine();
        }
    }

    // Takes all current records and saves them to testFile.txt
    public static void saveAllRecords() throws IOException {
        ArrayList<DisplayableRecord> records = manager.getAllRecords();
        handler.saveRecords(records);
    }

    // Takes all records from testFile.txt and replaces the current list of records with them
    public static void loadAllRecords() throws IOException {
        ArrayList<DisplayableRecord> records = handler.loadRecords();
        manager.setRecords(records);
    }


}