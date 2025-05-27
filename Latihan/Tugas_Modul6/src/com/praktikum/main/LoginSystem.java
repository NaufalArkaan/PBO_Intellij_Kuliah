package com.praktikum.main;
import com.praktikum.data.Item;
import com.praktikum.users.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<Item> reportedItems = new ArrayList<>();
    public static ArrayList<User> userList = new ArrayList<>();
    public static void main(String[] args) {
        userList.add(new Admin("Naufal Arkaan", "020", "Admin020", "Password020"));
        userList.add(new Mahasiswa("Naufal Arkaan", "202410370110020"));
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("==== Selamat Datang Di Halaman Login System ====");
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

                boolean loginBerhasil = false;
                for (User user : userList) {
                    if (user instanceof Admin) {
                        if (user.login(username, password)) {
                            user.info();
                            user.displayAppMenu();
                            loginBerhasil = true;
                            break;
                        }
                    }
                }
                if (!loginBerhasil) {
                    System.out.println("Login Admin gagal! Username atau password salah.");
                }
            } else if (pilih == 2) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                boolean loginBerhasil = false;

                for (User user : userList) {
                    if (user instanceof Mahasiswa) {
                        if (user.login(nama, nim)) {
                            user.info();
                            user.displayAppMenu();
                            loginBerhasil = true;
                            break;
                        }
                    }
                }

                if (!loginBerhasil) {
                    System.out.println("Login Mahasiswa gagal! Nama atau NIM salah.");
                }
            } else if (pilih == 3) {
                System.out.println("Anda telah keluar dari program...");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
