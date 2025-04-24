import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("==== Registrasi ====");
        System.out.println("Masukan username: ");
        String username = scan.nextLine();
        System.out.println("Masukan password: ");
        String password = scan.nextLine();

        User user1 = new Admin();
        user1.register(username, password);
        user1.notification();

    }
}