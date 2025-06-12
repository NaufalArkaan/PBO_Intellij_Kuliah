package com.uap.perpus;

public class Pengembalian extends Transaksi implements Laporan{
    public Pengembalian(Buku buku, Anggota anggota, String tanggal){
        super(buku, anggota, tanggal);
    }

    @Override
    public void proses(){
        System.out.println("[Pengembalian}" + anggota.getNama() + " mengembalikan " + buku.getJudul() + "'");
    }

    @Override
    public void cetakLaporan(){
        System.out.println("Laporan Pengembalian " + this);
    }
}
