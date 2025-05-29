package com.praktikum.users;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.Scanner;

public class Mahasiswa  extends User implements MahasiswaActions {
    Scanner scan = new Scanner(System.in);
    public Mahasiswa(String nama, String nim){
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return this.getNama().equals(inputNama) && this.getNim().equals(inputNim);
    }

    @Override
    public void info() {
        System.out.println("Login berhasil sebagai Mahasiswa!");
        super.info();
    }

    @Override
    public void reportItem(){
        scan.nextLine();
        System.out.print("Nama Barang: ");
        String namaBarang = scan.nextLine();
        System.out.print("deskripsi Barang: ");
        String deskripsiBarang = scan.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasiBarang = scan.nextLine();
        System.out.println("==== Cetak ====");
        System.out.println("Nama Barang = " + namaBarang);
        System.out.println("deskripsi Barang = " + deskripsiBarang);
        System.out.println("Lokasi Terakhir/Ditemukan = " + lokasiBarang);

        Item item = new Item(namaBarang, deskripsiBarang, lokasiBarang, "Reported");
        LoginSystem.reportedItems.add(item);
        System.out.println("Laporan berhasil ditambahkan.");

    }

    @Override
    public void viewReportedItems(){
        if(LoginSystem.reportedItems.isEmpty()){
            System.out.println("Belum ada laporan barang.");
        }else {
            System.out.println("Daftar barang yang dilaporkan:");
            for(Item item : LoginSystem.reportedItems){
                if (item.getStatus().equals("Reported")) {
                    System.out.println("- " + item.getItemName() + " | " + item.getDescription() + " | " + item.getLocation());
                }
            }
        }

    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println();
            System.out.println("==== Selamat Datang Di Display App Menu Mahasiswa ====");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukan pilihan: ");
            int pilihMenu = scan.nextInt();

            if (pilihMenu == 1) {
                reportItem();
            } else if (pilihMenu == 2) {
                viewReportedItems();
            } else if (pilihMenu == 0) {
                System.out.println("Anda logout ...");
                break;
            } else {
                System.out.println("Inputan Invalid!");
            }
        }
    }
}