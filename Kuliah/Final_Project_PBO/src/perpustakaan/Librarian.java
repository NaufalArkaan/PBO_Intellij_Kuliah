package perpustakaan;

public class Librarian extends Person {

    public Librarian(String name, String id) {
        super(name, id);
    }

    public void registerStudent(Student student) {
        System.out.println("Librarian " + name + " registered student: " + student.name);
    }

    public void manageBook(Book book, boolean add) {
        if (add) {
            Library.addBook(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            Library.removeBook(book);
            System.out.println("Book removed: " + book.getTitle());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Librarian: " + name);
    }
}