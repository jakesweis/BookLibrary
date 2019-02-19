//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BookLibrary
// Files: Book.java, BookLibraryTests.java, Subscriber.java, Librarian.java, Library.java
// Course: CS 300, Spring, 2019
//
// Author: Jacob Sweis
// Email: jdsweis@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Galen Quinn
// Partner Email: gaquinn@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class models a simple book library. The main method of this class implements the management
 * system for this library.
 * 
 * @author Jacob Sweis
 * @author Galen Quinn
 */
public class Library {
    // instance fields
    private String address; // Street address of this library
    private Librarian librarian; // this library's librarian. This library must have only ONE
                                 // librarian
    private ArrayList<Book> books; // list of the books in this library
    private ArrayList<Subscriber> subscribers; // list of this library's subscribers

    /**
     * Creates a new Library and initializes all its instance fields. Initially both books and
     * subscribers lists are empty.
     */
    public Library(String address, String librarianUsername, String librarianLogin) {
        librarian = new Librarian(librarianUsername, librarianLogin);
        this.address = address;
        books = new ArrayList<Book>();
        subscribers = new ArrayList<Subscriber>();
    }

    /**
     * Returns the librarian of this library.
     * 
     * @return librarian librarian of library
     */
    public Librarian getLibrarian() {
        return librarian;
    }

    /**
     * Returns the address of this library.
     * 
     * @return address address of library
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns a Book given a book identifier if found, and null otherwise. If the book is not
     * found, this method displays the following message: "Error: this book identifier didn't match
     * any of our books identifiers."
     * 
     * @return reference to the Book if found and null otherwise
     */
    public Book findBook(int bookId) {
        for (int i = 0; i < books.size(); i++) { // iterate through library
            if (books.get(i).getID() == bookId) { // if ID in library matches bookID, return book
                return books.get(i);
            }
        }
        System.out
            .println("Error: this book identifier didn't match any of our books identifiers.");
        return null;
    }

    /**
     * Returns the list of books having a given title in this library. The comparison used by this
     * method is case insensitive.
     * 
     * @return ArrayList of the books having a given title in this library (0 or more books can be
     *         found)
     */
    public ArrayList<Book> findBookByTitle(String title) {
        ArrayList<Book> matchingTitles = new ArrayList<>(); // list of books with matching titles
        title = title.toUpperCase();

        for (int i = 0; i < books.size(); i++) { // iterate through library
            if (books.get(i).getTitle().toUpperCase().equals(title)) { // if titles are same, add
                                                                       // book to matching titles
                matchingTitles.add(books.get(i));
            }
        }
        displayBooks(matchingTitles);
        return matchingTitles;
    }

    /**
     * Returns the list of books having a given author. The comparison used by this method is case
     * insensitive.
     * 
     * @return ArrayList of the books having a given author (0 or more books can be found)
     */
    public ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> matchingAuthors = new ArrayList<>(); // list of books with matching authors
        author = author.toUpperCase();

        for (int i = 0; i < books.size(); i++) { // iterate through library
            if (books.get(i).getAuthor().toUpperCase().equals(author)) { // if authors are the same,
                                                                        // add book to matching
                                                                        // authors
                matchingAuthors.add(books.get(i));
            }
        }
        displayBooks(matchingAuthors);
        return matchingAuthors;
    }

    /**
     * Adds a new book to the library (to the books list). This method displays the following
     * message: "Book with Title " + title + " is successfully added to the library."
     */
    public void addBook(String title, String author) {
        Book book = new Book(title, author); // new book object
        books.add(book);
        System.out.println("Book with Title " + title + " is successfully added to the library.");
    }

    /**
     * Removes a book given its identifier from the library (from books list).
     * 
     * @return a reference to the removed book, and null if the book is not found in this library or
     *         if it is not available
     */
    public Book removeBook(int bookId) {
        for (int i = 0; i < books.size(); i++) { // iterate through library
            if (books.get(i).getID() == bookId) { // if book IDs match, remove book from library and
                                                  // return book
                return books.remove(i);
            }
        }
        return null;
    }

    /**
     * Adds a new subscriber to this library (to subscribers list). This method displays the
     * following message: "Library card with bar code " + card bar code + " is successfully issued
     * to the new subscriber " + name + "."
     */
    public void addSubscriber(String name, int pin, String address, String phoneNumber) {
        Subscriber subscriber = new Subscriber(name, pin, address, phoneNumber); // new subscriber
                                                                                 // object
        subscribers.add(subscriber);
        System.out.println("Library card with bar code " + subscriber.getCARD_BAR_CODE()
            + " is successfully issued to the new subscriber " + subscriber.getName() + ".");
    }

    /**
     * Finds a subscriber given its cardBarCode. This method displayed the following message:
     * "Error: this card bar code didn't match any of our records." and returns null if the provided
     * cardBarCode did not match with any of the subscribers' card bar codes.
     * 
     * @return a reference to the subscriber if found, otherwise null
     */
    public Subscriber findSubscriber(int cardBarCode) {
        for (int i = 0; i < subscribers.size(); i++) { // iterate through subscriber list
            if (subscribers.get(i).getCARD_BAR_CODE() == cardBarCode) { // if card bar codes match,
                                                                        // return subscriber
                return subscribers.get(i);
            }
        }
        System.out.println("Error: this card bar code didn't match any of our records.");
        return null;
    }


    /**
     * Displays a list of books.
     * 
     * @param books ArrayList of books
     */
    public static void displayBooks(ArrayList<Book> books) {
        // Traverse the list of books and display book id, title, author, and availability of each
        // book
        for (int i = 0; i < books.size(); i++) {
            System.out.print("<Book ID>: " + books.get(i).getID() + " ");
            System.out.print("<Title>: " + books.get(i).getTitle() + " ");
            System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
            System.out.println("<Is Available>: " + books.get(i).isAvailable());
        }
    }

    /**
     * Reads and processes the user commands with respect to the menu of this application.
     * 
     * @param scanner Scanner object used to read the user command lines
     */
    public void readProcessUserCommand(Scanner scanner) {
        final String promptCommandLine = "ENTER COMMAND: ";
        displayMainMenu(); // display the library management system main menu
        System.out.print(promptCommandLine);
        String command = scanner.nextLine(); // read user command line
        String[] commands = command.trim().split(" "); // split user command
        while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
            switch (commands[0].trim().charAt(0)) {
                case '1': // login as librarian commands[1]: password
                    if (this.librarian.checkPassword(commands[1])) {
                        // read and process librarian commands
                        readProcessLibrarianCommand(scanner);
                    } else { // error password
                        System.out.println("Error: Password incorrect!");
                    }
                    break;
                case '2': // login as subscriber commands[1]: card bar code
                    Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
                    if (subscriber != null) {
                        if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
                            // read and process subscriber commands
                            readProcessSubscriberCommand(subscriber, scanner);
                        else
                            System.out.println("Error: Incorrect PIN.");
                    }
                    break;
            }
            // read and split next user command line
            displayMainMenu(); // display the library management system main menu
            System.out.print(promptCommandLine);
            command = scanner.nextLine(); // read user command line
            commands = command.trim().split(" "); // split user command line
        }
    }

    /**
     * Displays the main menu for this book library application.
     */
    private static void displayMainMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("     Welcome to our Book Library Management System");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter one of the following options:");
        System.out.println("[1 <password>] Login as a librarian");
        System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
        System.out.println("[3] Exit"); // Exit the application
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Displays the menu for a Subscriber.
     */
    private static void displaySubscriberMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("    Welcome to Subscriber's Space");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter one of the following options:");
        System.out.println("[1 <book ID>] Check out a book");
        System.out.println("[2 <book ID>] Return a book");
        System.out.println("[3 <title>] Search a Book by title");
        System.out.println("[4 <author>] Search a Book by author");
        System.out.println("[5] Print list of books checked out");
        System.out.println("[6] Print history of returned books");
        System.out.println("[7 <address>] Update address");
        System.out.println("[8 <phone number>] Update phone number");
        System.out.println("[9] Logout");
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Displays the menu for the Librarian.
     */
    private static void displayLibrarianMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("    Welcome to Librarian's Space");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter one of the following options:");
        System.out.println("[1 <title> <author>] Add new Book");
        System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
        System.out.println("[3 <card bar code> <book ID>] Check out a Book");
        System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
        System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
        System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
        System.out.println("[7] Display All Books");
        System.out.println("[8 <book ID>] Remove a Book");
        System.out.println("[9] Logout");
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Display the Application GoodBye and logout message.
     */
    private static void displayGoodByeLogoutMessage() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("       Thanks for Using our Book Library App!!!!");
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Reads and processes the librarian commands according to the librarian menu.
     * 
     * @param scanner Scanner object used to read the librarian command lines
     */
    private void readProcessLibrarianCommand(Scanner scanner) {
        final String promptCommandLine = "ENTER COMMAND: "; // command prompt
        displayLibrarianMenu(); // display the librarian menu
        System.out.print(promptCommandLine);
        String command = scanner.nextLine(); // read user command line
        String[] commands = command.trim().split(" "); // split user command
        while (commands[0].trim().charAt(0) != '9') { // '9': Exit the application
            switch (commands[0].trim().charAt(0)) {
                case '1': // add book to library
                    addBook(commands[1], commands[2]);
                    break;
                case '2': // add subscriber to subscriber list
                    addSubscriber(commands[1], Integer.parseInt(commands[2]), commands[3],
                        commands[4]);
                    break;
                case '3': // check out a book
                    Book book = findBook(Integer.parseInt(commands[2])); // new book object
                    Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1])); // new
                                                                                                // subscriber
                                                                                                // object
                    subscriber.checkoutBook(book);
                    break;
                case '4': // return a book
                    book = findBook(Integer.parseInt(commands[2]));
                    subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
                    subscriber.returnBook(book);
                    break;
                case '5': // display personal info of subscriber
                    subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
                    subscriber.displayPersonalInfo();
                    break;
                case '6': // display books checked out by a subscriber
                    subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
                    subscriber.displayBooksCheckedOut();
                    break;
                case '7': // display library
                    displayBooks(books);
                    break;
                case '8': // removes book from library
                    removeBook(Integer.parseInt(commands[1]));
                    break;
            }
            // read and split next user command line
            displayLibrarianMenu(); // display the librarian menu
            System.out.print(promptCommandLine);
            command = scanner.nextLine(); // read user command line
            commands = command.trim().split(" "); // split user command line
        }
    }


    /**
     * Reads and processes the subscriber commands according to the subscriber menu.
     * 
     * @param subscriber Current logged in subscriber
     * @param scanner Scanner object used to read the librarian command lines
     */
    private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
        final String promptCommandLine = "ENTER COMMAND: "; // command prompt
        displaySubscriberMenu(); // display the subscriber menu
        System.out.print(promptCommandLine);
        String command = scanner.nextLine(); // read user command line
        String[] commands = command.trim().split(" "); // split user command
        while (commands[0].trim().charAt(0) != '9') { // '9': Exit the application
            switch (commands[0].trim().charAt(0)) {
                case '1': // check out a book
                    Book book = findBook(Integer.parseInt(commands[1]));
                    subscriber.checkoutBook(book);
                    break;
                case '2': // return a book
                    book = findBook(Integer.parseInt(commands[1]));
                    subscriber.returnBook(book);
                    break;
                case '3': // search book based on title
                    findBookByTitle(commands[1]);
                    break;
                case '4': // search book based on author
                    findBookByAuthor(commands[1]);
                    break;
                case '5': // print books subscriber has checked out
                    subscriber.displayBooksCheckedOut();
                    break;
                case '6': // print history of returned books by a subscriber
                    subscriber.displayHistoryBooksReturned();
                    break;
                case '7': // update subscriber address
                    subscriber.setAddress(commands[1]);
                    break;
                case '8': // update subscriber phone number
                    subscriber.setPhoneNumber(commands[1]);
                    break;
            }
            // read and split next user command line
            displaySubscriberMenu(); // display the subscriber menu
            System.out.print(promptCommandLine);
            command = scanner.nextLine(); // read user command line
            commands = command.trim().split(" "); // split user command line
        }
    }

    /**
     * Main method that represents the driver for this application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
        // create a new library object
        Library madisonLibrary = new Library("Madison, WI", "april", "abc");
        // read and process user command lines
        madisonLibrary.readProcessUserCommand(scanner);
        displayGoodByeLogoutMessage(); // display good bye message
        scanner.close();// close this scanner
    }
}
