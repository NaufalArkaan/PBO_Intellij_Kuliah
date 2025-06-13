package main;
import actions.CetakData;
import komunitas.Pembaca;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static ArrayList<Pembaca> skorReview = new ArrayList<>();
    public static ArrayList<Pembaca> skorReview2 = new ArrayList<>();
    public static ArrayList<CetakData> dataPeserta = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int pilih;
        do {
            System.out.println("==== Selamat Datang ====");
            System.out.println("1. Tampilkan skor review pembaca tertentu");
            System.out.println("2. Tampilkan seluruh data peserta komunitas");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi:");
            pilih = scanner.nextInt();

            switch (pilih){
                case 1:
                    cetakScore();
                    break;
                case 2:
                    cetakSeluruh();
                    break;
                case 3:
                    System.out.println("terima kasih..");
                    System.exit(0);
                default:
                    System.out.println("Input tidak valid!");
            }
        }while(pilih != 4);

    }
    public static void cetakScore(){
        int indeks;
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Masukan indeks nomor pembaca");
            System.out.print("Masukan indeks =");
            indeks = scanner.nextInt();
            if(indeks == 1){
                skorReviewSatu();
            }else if(indeks == 2){
                skorReviewDua();
            }
        }catch(NumberFormatException e){
            System.out.println("Inputan harus berupa angka");
        }
    }

    public static void skorReviewSatu(){
        ArrayList<Integer> skor1 = new ArrayList<>();
        skor1.add(80); skor1.add(70);
        skor1.add(80); skor1.add(70);
        skor1.add(80);
        skorReview.add(new Pembaca("haha", "1", skor1));

        Iterator<Pembaca> baca = skorReview.iterator();
        while(baca.hasNext()){
            Pembaca pembaca = baca.next();
            pembaca.tampilkanInfo();
        }
    }

    public static void skorReviewDua(){
        ArrayList<Integer> skor2 = new ArrayList<>();
        skor2.add(20); skor2.add(40);
        skor2.add(100); skor2.add(40);
        skor2.add(70);
        skorReview2.add(new Pembaca("nopal", "2", skor2));

        Iterator<Pembaca> baca2 = skorReview2.iterator();
        while(baca2.hasNext()){
            Pembaca pembaca = baca2.next();
            pembaca.tampilkanInfo();
        }
    }

    public static void cetakSeluruh(){
        ArrayList<String> namaSemua = new ArrayList<>();
        namaSemua.add("wirr");
        namaSemua.add("umam");
        namaSemua.add("Kensss");
        System.out.println("===Data Peserta===");
        Iterator<String> namaaa = namaSemua.iterator();
        while(namaaa.hasNext()){
            System.out.println(namaaa.next());
        }

    }
}
