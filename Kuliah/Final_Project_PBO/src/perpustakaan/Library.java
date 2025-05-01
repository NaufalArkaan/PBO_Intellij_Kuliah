package perpustakaan;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final static List<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void removeBook(Book book) {
        books.remove(book);
    }

    public static void searchBook(String keyword) {
        System.out.println("Searching books with keyword: " + keyword);
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public static void listBooks() {
        System.out.println("Book List:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}