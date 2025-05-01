package perpustakaan;

public class Book {
    private final String title;
    private final String author;
    private boolean available = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return title + " by " + author + (available ? " [Available]" : " [Borrowed]"); //if else condition
    }
}