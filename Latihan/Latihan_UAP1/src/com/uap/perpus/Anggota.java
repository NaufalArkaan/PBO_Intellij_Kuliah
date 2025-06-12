package com.uap.perpus;

public class Anggota {
    private final String id;
    private final String nama;

    public Anggota(String id, String nama){
        this.id = id;
        this.nama = nama;
    }

    public String getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }

    @Override
    public String toString(){
        return id + ": " + nama;
    }
}
