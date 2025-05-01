package actions;
import perpustakaan.Book;

public interface UserActions {
    void searchBook(String keyword);
    void borrowBook(Book book);
    void returnBook(Book book);
}
