package com.praktikum.users;
import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.InputMismatchException;
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
        System.out.println("1. Lihat Semua Laporan");
        System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
        System.out.print("Pilih Menu:");

        try {
            int pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    for (Item item : LoginSystem.reportedItems) {
                        System.out.println(item.getItemName() + " | " + item.getStatus());
                    }
                    break;
                case 2:
                    for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                        Item item = LoginSystem.reportedItems.get(i);
                        if (item.getStatus().equals("Reported")) {
                            System.out.println(i + ". " + item.getItemName() + " - " + item.getStatus());
                        }
                    }
                    try {
                        System.out.print("Masukkan indeks item yang ingin ditandai: ");
                        int index = scan.nextInt();
                        scan.nextLine();
                        LoginSystem.reportedItems.get(index).setStatus("Claimed");
                        System.out.println("Item berhasil ditandai sebagai 'Claimed'.");
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Indeks tidak valid!");
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scan.nextLine();
        }
    }

    @Override
    public void manageUsers() {
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih Menu:");

        try {
            int pilihManageUser = scan.nextInt();
            scan.nextLine();

            switch (pilihManageUser) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    LoginSystem.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa ditambahkan.");
                    break;
                case 2:
                    System.out.print("NIM Mahasiswa yang ingin dihapus: ");
                    String nimHapus = scan.nextLine();
                    User userToRemove = null;
                    for (User u : LoginSystem.userList) {
                        if (u instanceof Mahasiswa && u.getNim().equals(nimHapus)) {
                            userToRemove = u;
                            break;
                        }
                    }
                    if (userToRemove != null) {
                        LoginSystem.userList.remove(userToRemove);
                        System.out.println("Mahasiswa berhasil dihapus.");
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scan.nextLine();
        }
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
                break;
            } else {
                System.out.println("Inputan Invalid!");
            }
        }
    }
}
