package com.praktikum.users;

public abstract class User { //abstract
    private String nama;
    private String nim;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public void setNim(String nim){
        this.nim = nim;
    }
    public String getNim(){
        return nim;
    }

    public abstract boolean login(String input1, String input2);

    public void info(){
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }

    public abstract void displayAppMenu(); //abstract method
}
