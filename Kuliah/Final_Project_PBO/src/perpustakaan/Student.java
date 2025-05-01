package perpustakaan;

import actions.UserActions;

import java.util.*;

public class Student extends Person implements UserActions {
    private LibraryCard card;
    private List<Book> borrowedBooks;

    public Student(String name, String id, LibraryCard card) {
        super(name, id);
        this.card = card;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + name + ", ID: " + id);
    }

    @Override
    public void searchBook(String keyword) {
        System.out.println(name + " is searching for: " + keyword);
        Library.searchBook(keyword);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println(name + " doesn't have this book.");
        }
    }
}