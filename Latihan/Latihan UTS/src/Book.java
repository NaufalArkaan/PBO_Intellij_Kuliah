import java.util.ArrayList;
// Abstract Class Book
abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public abstract String getInfo();
}

// Subclass EBook
class EBook extends Book {
    private int fileSize;

    public EBook(String title, String author, String isbn, int fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }

    public String getInfo() {
        return "EBook: " + title + " oleh " + author + " - " + fileSize + "MB";
    }
}

// Subclass PrintedBook
class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, String author, String isbn, int pages) {
        super(title, author, isbn);
        this.pages = pages;
    }

    public String getInfo() {
        return "Printed Book: " + title + " oleh " + author + " - " + pages + " halaman";
    }
}

// Abstract Class User
abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String userType();
}

// Member Class

class Member extends User {
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        super(name);
    }

    public String userType() {
        return "Member";
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(getName() + " meminjam " + book.title);
    }
}

// Librarian Class
class Librarian extends User {
    public Librarian(String name) {
        super(name);
    }

    public String userType() {
        return "Librarian";
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println(getName() + " menambahkan buku: " + book.title);
    }
}

// Library Class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
    }
}
