package com.praktikum.main;
import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        while (true) {
            User user1 = new Admin("Naufal Arkaan", "020", "Admin020", "Password020");
            User user2 = new Mahasiswa("Naufal Arkaan", "202410370110020");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pilih login: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukan pilihan: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                if (user1.login(username, password)) {
                    user1.info();
                    user1.displayAppMenu();
                } else {
                    System.out.println("Login Admin gagal! Username atau password salah.");
                }
            } else if (pilih == 2) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                if (user2.login(nama, nim)) {
                    user2.info();
                    user2.displayAppMenu();
                } else {
                    System.out.println("Login Mahasiswa gagal! Nama atau NIM salah.");
                }
            } else if (pilih == 3) {
                System.out.println("Anda telah keluar dari program...");
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
