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

/**
 * This class models a public library subscriber. A subscriber is a card holder who can borrow
 * (checkout) and return library books.
 * 
 * @author Jacob Sweis
 * @author Galen Quinn
 */
public class Subscriber {

    // static fields
    private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked
                                                         // out
                                                         // one subscriber
    private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
                                                     // code of the next subscriber to be created
    // Instance fields
    private int pin; // 4-digits Personal Identification Number to verify the identity of this
                     // subscriber
    private final Integer CARD_BAR_CODE; // card bar code of this subscriber

    private String name; // name of this subscriber
    private String address; // address of this subscriber
    private String phoneNumber; // phone number of this subscriber

    private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not
                                             // yet
                                             // returned. A subscriber can have at most 10 checked
                                             // out books
    private ArrayList<Book> booksReturned; // list of the books returned by this subscriber

    /**
     * Creates a new subscriber with given name, address, and phone number, and initializes its
     * other instance fields.
     */
    public Subscriber(String name, int pin, String address, String phoneNumber) {
        this.name = name;
        this.pin = pin;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.CARD_BAR_CODE = nextCardBarCode++;
        booksCheckedOut = new ArrayList<Book>();
        booksReturned = new ArrayList<Book>();
    }

    /**
     * Returns this subscriber's address.
     * 
     * @return address address of the subscriber
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates this subscriber's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns this subscriber's phone number.
     * 
     * @return phoneNumber phoneNumber of subscriber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Updates this subscriber's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns this subscriber PIN (4-digits Personal Identification Number)
     * 
     * @return pin personal identification number for subscriber
     */
    public int getPin() {
        return pin;
    }

    /**
     * Returns this subscriber's card bar code.
     * 
     * @return CARD_BAR_CODE card bar code of subscriber
     */
    public Integer getCARD_BAR_CODE() {
        return CARD_BAR_CODE;
    }

    /**
     * Returns this subscriber's name.
     * 
     * @return name name of subscriber
     */
    public String getName() {
        return name;
    }

    /**
     * Checks out an available book. The checkout operation fails if the maximum number of checked
     * out books by this subscriber is already reached.
     */
    public void checkoutBook(Book book) { // FIXME
        if (booksCheckedOut.contains(book)) { // if checked out books contains book, book has
                                              // already been checked out
            System.out.println("You have already checked out " + book.getTitle() + " book.");
        } else if (book.isAvailable()) { // otherwise if book is available, borrow book and add to
                                         // checked out books
            book.borrowBook(getCARD_BAR_CODE());
            booksCheckedOut.add(book);
        } else if (booksCheckedOut.size() == MAX_BOOKS_CHECKED_OUT) { // otherwise if checked out
                                                                      // max number of books,
                                                                      // checkout fails
            System.out.println("Checkout Failed: You cannot check out more than "
                + MAX_BOOKS_CHECKED_OUT + "books.");
        } else { // otherwise, book is not available
            System.out.println("Sorry, " + book.getTitle() + " is not available.");
        }
    }

    /**
     * Returns a library book.
     */
    public void returnBook(Book book) {
        if (booksCheckedOut.contains(book)) { // if checked out books contains book, return book,
                                              // remove from checked out books, and add to returned
                                              // books
            book.returnBook();
            booksCheckedOut.remove(book);
            booksReturned.add(book);
        }
    }

    /**
     * Checks if this subscriber booksCheckedOut list contains a given book.
     * 
     * @param book book to check if it is within this subscriber booksCheckedOut list
     * @return true if booksCheckedOut contains book, false otherwise
     */
    public boolean isBookInBooksCheckedOut(Book book) {
        return booksCheckedOut.contains(book);
    }

    /**
     * Displays the list of the books checked out and not yet returned.
     */
    public void displayBooksCheckedOut() {
        if (booksCheckedOut.isEmpty()) // empty list
            System.out.println("No books checked out by this subscriber");
        else
            // Traverse the list of books checked out by this subscriber and display its content
            for (int i = 0; i < booksCheckedOut.size(); i++) {
                System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
                System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
                System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
            }
    }

    /**
     * Displays the history of the returned books by this subscriber.
     */
    public void displayHistoryBooksReturned() {
        if (booksReturned.isEmpty()) // empty list
            System.out.println("No books returned by this subscriber");
        else
            // Traverse the list of borrowed books already returned by this subscriber and display
            // its
            // content
            for (int i = 0; i < booksReturned.size(); i++) {
                System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
                System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
                System.out.println("Author: " + booksReturned.get(i).getAuthor());
            }
    }


    /**
     * Displays this subscriber's personal information.
     */
    public void displayPersonalInfo() {
        System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
        System.out.println("  Name: " + name);
        System.out.println("  Address: " + address);
        System.out.println("  Phone number: " + phoneNumber);
    }
}
