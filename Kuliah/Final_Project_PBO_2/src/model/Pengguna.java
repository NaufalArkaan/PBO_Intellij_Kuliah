package model;

public abstract class Pengguna {
    protected String nama;
    protected String id;

    public Pengguna(String nama, String id){
        this.nama = nama;
        this.id = id;
    }

    public abstract void tampilkanInfo();
}
