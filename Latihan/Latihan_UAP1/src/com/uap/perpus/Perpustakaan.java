package com.uap.perpus;

import java.util.Iterator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Perpustakaan{
    private static List<Buku> daftarBuku = new ArrayList<>();
    private static List<Anggota> daftarAnggota = new ArrayList<>();
    private static List<Transaksi> riwayatTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do{
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Peminjaman");
            System.out.println("5. Pengembalian");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();

            try{
                switch(pilihan){
                    case 1:
                        tambahBuku(scanner);
                        break;
                    case 2:
                        tampilkanBuku();
                        break;
                    case 3:
                        cariBuku(scanner);
                        break;
                    case 4:
                        prosesPeminjaman(scanner);
                        break;
                    case 5:
                        prosesPengembalian(scanner);
                        break;
                    case 6:
                        System.out.println("Keluar...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }catch(BukuTidakDitemukanException | NumberFormatException e){
                System.out.println("Eror: " + e.getMessage());
            }

        }while (pilihan != 6);
        scanner.close();
    }

    private static void tambahBuku(Scanner scanner){
        scanner.nextLine();
        System.out.print("ID Buku: ");
        String id = scanner.nextLine();
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();
        daftarBuku.add(new Buku(id, judul, penulis));
        System.out.println("Buku berhasil ditambahkan.");
    }

    private static void tampilkanBuku(){
        System.out.println("\n--- Daftar Buku ---");
        Iterator<Buku> it = daftarBuku.iterator();
        while ((it.hasNext())){
            System.out.println(it.next());
            break;
        }
    }

    private static Buku cariBuku(Scanner scanner) throws BukuTidakDitemukanException{
        scanner.nextLine();
        System.out.print("Masukkan ID Buku yang dicari: ");
        String id = scanner.nextLine();
        for(Buku b : daftarBuku){
            if(b.getId().equals(id)){
                System.out.println("Buku ditemukan: " + b);
                return b;
            }
        }
        throw new BukuTidakDitemukanException("Buku dengan ID " + id + " Tidak ditemukan.");
    }

    private static void prosesPeminjaman(Scanner scanner) throws BukuTidakDitemukanException {
        System.out.println("\n-- Peminjaman Buku --");
        Buku buku = cariBuku(scanner);
        System.out.print("ID Anggota: ");
        String aid = scanner.nextLine();
        System.out.print("Nama Anggota: ");
        String aname = scanner.nextLine();
        System.out.print("Tanggal (dd-MM-yyyy): ");
        String tanggal = scanner.nextLine();

        Anggota anggota = new Anggota(aid, aname);
        daftarAnggota.add(anggota);
        Peminjaman pinjam = new Peminjaman(buku, anggota, tanggal);
        pinjam.proses();
        riwayatTransaksi.add(pinjam);
        pinjam.cetakLaporan("** Laporan Peminjaman **");
    }

    private static void prosesPengembalian(Scanner scanner) throws BukuTidakDitemukanException {
        System.out.println("\n-- Pengembalian Buku --");
        Buku buku = cariBuku(scanner);
        System.out.print("ID Anggota: ");
        String aid = scanner.nextLine();
        System.out.print("Nama Anggota: ");
        String aname = scanner.nextLine();
        System.out.print("Tanggal (dd-MM-yyyy): ");
        String tanggal = scanner.nextLine();

        Anggota anggota = new Anggota(aid, aname);
        daftarAnggota.add(anggota);
        Pengembalian kembali = new Pengembalian(buku, anggota, tanggal);
        kembali.proses();
        riwayatTransaksi.add(kembali);
        kembali.cetakLaporan();
    }
}
