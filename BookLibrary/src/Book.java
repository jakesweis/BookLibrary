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
/**
 * This class models a simple book.
 * 
 * @author Jacob Sweis
 * @author Galen Quinn
 */
public class Book {

    // class/static fields
    private static int nextId = 1; // class variable that represents the identifier of the next
                                   // book
    // Instance fields
    private final int ID; // unique identifier of this book
    private String author; // name of the author of this book
    private String title; // title of this book
    private Integer borrowerCardBarCode; // card bar code of the borrower of this book
                                         // When borrowerCardBarCode == null, the book is available
                                         // (no one has the book)

    /**
     * Constructs a new Book object and initializes its instance fields.
     * 
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.ID = nextId++;
        borrowerCardBarCode = null;
    }

    /**
     * Returns the ID of this Book object.
     * 
     * @return ID identifier of book
     */
    public int getID() {
        return ID;
    }

    /**
     * Returns the title of this book.
     * 
     * @return title title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of this book.
     * 
     * @return author author of book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Return the the borrower's card bar code of this book if the book has been checked out or null
     * if not.
     * 
     * @return borrowCardBarCode card bard code of the borrower of this book
     */
    public Integer getBorrowerCardBarCode() {
        if (borrowerCardBarCode == null) { // if book is available, returns null
            return null;
        } else { // otherwise, return borrower card bar code
            return borrowerCardBarCode;
        }
    }

    /**
     * Records the borrower's card bar code of this book if the book is available. If this book is
     * not available, this method does nothing.
     */
    public void borrowBook(Integer borrowerCardBarCode) {
        if (this.borrowerCardBarCode == null) { // if book is available, set instance field to
                                                // parameter
            this.borrowerCardBarCode = borrowerCardBarCode;
        }
    }

    /**
     * Sets this book to be available. When the borrowerCardBarCode is set to null, no one is
     * borrowing it.
     */
    public void returnBook() {
        borrowerCardBarCode = null;
    }

    /**
     * Checks if this book is available.
     * 
     * @return true if no one is borrowing this book, false otherwise
     */
    public boolean isAvailable() {
        if (borrowerCardBarCode == null) { // if book is available, return true
            return true;
        } else { // otherwise, return false
            return false;
        }
    }
}
