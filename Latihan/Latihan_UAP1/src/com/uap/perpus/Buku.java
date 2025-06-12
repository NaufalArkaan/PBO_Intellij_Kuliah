package com.uap.perpus;

public class Buku {
    private final String id;
    private final String judul;
    private final String penulis;

    public Buku(String id, String judul, String penulis){
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getId(){
        return id;
    }
    public String getJudul(){
        return judul;
    }
    public String getPenulis(){
        return penulis;
    }

    @Override
    public String toString(){
        return id + ": " + judul + " oleh " + penulis;
    }
}
