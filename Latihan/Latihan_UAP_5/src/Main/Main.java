package Main;
import utama.PesertaMahasiswa;
import utama.PesertaUmum;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static ArrayList<PesertaMahasiswa> skorMhs = new ArrayList<>();
    public static void main(String[] args) {
        utama();
    }

    public static void utama(){
        int pilih;
        Scanner scanner = new Scanner(System.in);
        do {
            try{
                System.out.println("=== MENU UTAMA ===");
                System.out.println("1. Tampilkan skor seleksi Peserta Mahasiswa");
                System.out.println("2. Tampilkan semua data peserta lomba");
                System.out.println("3. Keluar");
                System.out.print("Masukan opsi:");
                pilih = scanner.nextInt();
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            switch (pilih){
                case 1:
                    data();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input Invalid");
            }
        }while(pilih != 4);
    }

    public static void data(){
        ArrayList<Integer> penampungskor = new ArrayList<>();
        penampungskor.add(90);
        penampungskor.add(70);
        penampungskor.add(80);
        penampungskor.add(40);
        skorMhs.add(new PesertaMahasiswa("halileo", "123", penampungskor));
        Iterator<PesertaMahasiswa> it = skorMhs.iterator();
        while(it.hasNext()){
            PesertaMahasiswa pesertamhs = it.next();
            pesertamhs.dataScore();
        }
    }

    public static void tampil(){
        PesertaUmum umum = new PesertaUmum("haha", "011", "kediri");
        umum.cetakData();
        ArrayList<Integer> penampungskor = new ArrayList<>();
        penampungskor.add(80);
        penampungskor.add(85);
        penampungskor.add(90);
        penampungskor.add(95);
        PesertaMahasiswa mhs = new PesertaMahasiswa("huhu", "02", penampungskor);
        mhs.cetakData();
    }
}
