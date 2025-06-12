package com.uap.perpus;

public class Peminjaman extends Transaksi implements Laporan{
    public Peminjaman(Buku buku, Anggota anggota, String tanggal){
        super(buku, anggota, tanggal);
    }

    @Override
    public void proses(){
        System.out.println("[Peminjama] " + anggota.getNama() + " meminjam " + buku.getJudul() + "'");
    }

    @Override
    public void cetakLaporan(){
        System.out.println("Laporan peminjaman: " + this);
    }

    public void cetakLaporan(String header){
        System.out.println(header);
        cetakLaporan();
    }

}
