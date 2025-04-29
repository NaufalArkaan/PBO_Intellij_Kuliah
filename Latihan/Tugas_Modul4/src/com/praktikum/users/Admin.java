package com.praktikum.users;
import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    Scanner scan = new Scanner(System.in);
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void info() {
        System.out.println("Login berhasil sebagai Admin!");
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println();
            System.out.println("==== Selamat Datang Di Display App Menu Admin ====");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Masukan pilihan: ");
            int pilihMenu = scan.nextInt();

            if (pilihMenu == 1) {
                manageItems();
            } else if (pilihMenu == 2) {
                manageUsers();
            } else if (pilihMenu == 0) {
                System.out.println("Anda logout ...");
                System.exit(0);
            } else {
                System.out.println("Inputan Invalid!");
            }
        }
    }
}