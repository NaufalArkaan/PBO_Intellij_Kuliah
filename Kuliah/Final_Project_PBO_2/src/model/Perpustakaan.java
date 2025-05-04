package model;
import java.util.*;

public class Perpustakaan {
    private final String nama;
    private final List<Buku> daftarBuku = new ArrayList<>();
    private final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public Perpustakaan(String nama){
        this.nama = nama;
    }

    public void buka(){
        System.out.println("Perpustkaan " + nama + " dibuka.");
    }

    public void tutup(){
        System.out.println("Perpustkaan " + nama + " ditutup.");
    }

    public List<Buku> getDaftarBuku(){
        return daftarBuku;
    }

    public void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }

    public void tampilkanBuku(){
        System.out.println("==== Daftar Buku ====");
        for(Buku b : daftarBuku){
            b.tampilkanInfo();
        }
    }

    public void cariBuku(String kataKunci){
        System.out.println("Hasil pencarian untuk: " + kataKunci);
        for(Buku b : daftarBuku){
            if(b.getJudul().toLowerCase().contains(kataKunci.toLowerCase())){
                b.tampilkanInfo();
            }
        }
    }
}
