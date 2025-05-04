package model;

public class Buku {
    private final String judul;
    private final String penulis;
    private boolean tersedia = true;

    public Buku(String judul, String penulis){
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul(){
        return judul;
    }
    public String getPenulis(){
        return penulis;
    }
    public boolean isTersedia(){
        return tersedia;
    }
    public void setTersedia(boolean tersedia){
        this.tersedia = tersedia;
    }

    public void tampilkanInfo(){
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tersedia: " + tersedia + ".");
    }
}
