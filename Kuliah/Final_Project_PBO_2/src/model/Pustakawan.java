package model;

public class Pustakawan extends Pengguna {
    public Pustakawan(String nama, String id){
        super(nama, id);
    }

    public Mahasiswa daftarkanMahasiswa(String nama, String id){
        Mahasiswa mhs = new Mahasiswa(nama, id);
        System.out.println("Mahasiswa " + nama + " berhasil di daftarkan.");
        return mhs;
    }

    public void tambahBuku(Perpustakaan perpustakaan, Buku buku){
        perpustakaan.getDaftarBuku().add(buku);
        System.out.println("Buku '" + buku.getJudul() + "' ditambahkan ke perpustakaan.");
    }

    public void hapusBuku(Perpustakaan perpustakaan, Buku buku) {
        perpustakaan.getDaftarBuku().remove(buku);
        System.out.println("Buku '" + buku.getJudul() + "' dihapus dari perpustakaan.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Pustakawan: " + nama + " | ID: " + id);
    }
}
