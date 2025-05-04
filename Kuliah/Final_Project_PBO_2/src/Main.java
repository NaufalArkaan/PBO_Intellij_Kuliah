import model.*;

public class Main {
    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan("UMM Library");

        Pustakawan pustakawan = new Pustakawan("Ibu Intan", "L001");
        Mahasiswa mhs1 = pustakawan.daftarkanMahasiswa("Arkaan", "B020");
        perpustakaan.tambahMahasiswa(mhs1);

        Buku buku1 = new Buku("Struktur Data", "Dewi");
        Buku buku2 = new Buku("Java Dasar", "Budi");
        pustakawan.tambahBuku(perpustakaan, buku1);
        pustakawan.tambahBuku(perpustakaan, buku2);

        perpustakaan.buka();
        perpustakaan.tampilkanBuku();

        mhs1.cariBuku("Java");
        perpustakaan.cariBuku("Java");

        mhs1.pinjamBuku(buku2);
        mhs1.bacaBuku(buku2);
        mhs1.kembalikanBuku(buku2);

        perpustakaan.tutup();
    }
}