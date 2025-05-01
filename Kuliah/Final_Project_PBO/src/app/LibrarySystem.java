package app;
import perpustakaan.*;
import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryCard card1 = new LibraryCard("CARD001", new GregorianCalendar(2026, Calendar.JANUARY, 1).getTime());
        Student s1 = new Student("Alice", "S001", card1);
        Librarian l1 = new Librarian("Mr. John", "L001");

        Book b1 = new Book("Java Programming", "James Gosling");
        Book b2 = new Book("Data Structures", "Robert Lafore");

        l1.manageBook(b1, true);
        l1.manageBook(b2, true);

        s1.displayInfo();
        l1.displayInfo();

        s1.searchBook("Java");

        s1.borrowBook(b1);
        s1.borrowBook(b2);

        Library.listBooks();

        s1.returnBook(b1);

        Library.listBooks();
    }
}