package model;
import aksi.Pencarian;
import java.util.*;

public class Mahasiswa extends Pengguna implements Pencarian {
    private final List<Buku> koleksiPinjaman = new ArrayList<>();

    public Mahasiswa(String nama, String id){
        super(nama, id);
    }

    public void pinjamBuku(Buku buku){
        if(buku.isTersedia()){
            buku.setTersedia(false); //Jika ya: tandai sebagai tidak tersedia dan tambahkan ke daftar pinjaman.
            koleksiPinjaman.add(buku);
            System.out.println(nama + " meminjam buku: " + buku.getJudul());
        }else{
            System.out.println("Buku tidak tersedia.");
        }
    }

    public void kembalikanBuku(Buku buku){
        if(koleksiPinjaman.contains(buku)){ //Dalam Java, metode contains() digunakan untuk memeriksa apakah sebuah string mengandung substring tertentu.
            buku.setTersedia(true);
            koleksiPinjaman.remove(buku);
            System.out.println(nama + " mengembalikan buku: " + buku.getJudul());
        }else{
            System.out.println("Buku tidak sedang dipinjam");
        }
    }

    public void bacaBuku(Buku buku){
        System.out.println(nama + " sedang membaca buku: " + buku.getJudul());
    }

    @Override
    public void cariBuku(String kataKunci){
        System.out.println(nama + " mencari buku dengan kata kunci: " + kataKunci);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mahasiswa: " + nama + " | ID: " + id);
    }
}
