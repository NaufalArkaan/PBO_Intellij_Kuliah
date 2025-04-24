public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Bu Diah");
        Member member = new Member("Andi");

        Book ebook = new EBook("Belajar Java", "Dino", "12345", 10);
        Book pbook = new PrintedBook("Dasar OOP", "Rina", "67890", 250);

        librarian.addBook(library, ebook);
        librarian.addBook(library, pbook);

        System.out.println("\nDaftar Buku:");
        library.listBooks();

        System.out.println("\nAktivitas Peminjaman:");
        member.borrowBook(pbook);
    }
}
