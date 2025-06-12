package com.uap.perpus;

public abstract class Transaksi {
    protected Buku buku;
    protected Anggota anggota;
    protected String tanggal;

    public Transaksi(Buku buku, Anggota anggota, String tanggal){
        this.buku = buku;
        this.anggota = anggota;
        this.tanggal = tanggal;
    }

    public abstract void  proses();

    @Override
    public String toString(){
        return tanggal + " - " + anggota.getNama() + " : " + buku.getJudul();
    }
}
