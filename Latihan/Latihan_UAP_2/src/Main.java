import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Siswa> daftarSiswa = new ArrayList<>();
    private static ArrayList<Pengajar> daftarPengajar = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        inisialisasiData();
        menuUtama();
    }

    private static void inisialisasiData(){
        ArrayList<Integer> skor1 = new ArrayList<>();
        skor1.add(90); skor1.add(80); skor1.add(98);
        skor1.add(80); skor1.add(88); skor1.add(78);
        daftarSiswa.add(new Siswa("Andi", "001", skor1));

        ArrayList<Integer> skor2 = new ArrayList<>();
        skor2.add(40); skor2.add(60); skor2.add(78);
        skor2.add(50); skor2.add(65); skor2.add(75);
        daftarSiswa.add(new Siswa("rara", "002", skor2));

        daftarPengajar.add(new Pengajar("Pak haha", "P111", "PBO"));
        daftarPengajar.add(new Pengajar("Pak Babayo", "P222", "Pemrograman Jaringan"));
    }

    private static void menuUtama(){
        int pilihan;

        do{
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tampilkan skor siswa");
            System.out.println("2. Lihat semua peserta kursus");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = validasiInputAngka();

            switch (pilihan){
                case 1:
                    cariSiswa();
                    break;
                case 2:
                    tampilkanSemuaPeserta();
                case 3:
                    System.out.println("Terima Kasi telah menggunakan program");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }while(pilihan != 3);
    }

    private static void cariSiswa() {
        System.out.print("Masukkan NIK siswa: ");
        String nik = scanner.nextLine();

        boolean ditemukan = false;
        Iterator<Siswa> iterator = daftarSiswa.iterator();
        while (iterator.hasNext()) {
            Siswa siswa = iterator.next();
            if (siswa.getNik().equalsIgnoreCase(nik)) {
                siswa.tampilkanInfo();
                siswa.tampilkanSemuaSkor();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Siswa dengan NIK tersebut tidak ditemukan.");
        }
    }

    private static void tampilkanSemuaPeserta(){
        System.out.println("\n --- Daftar Siswa ---");
        for(Siswa siswa : daftarSiswa){
            siswa.tampilkanInfo();
        }

        System.out.println("\n --- Tampilkan Pengajar ---");
        for(Pengajar pengajar : daftarPengajar){
            pengajar.tampilkanInfo();
        }
    }

    private static int validasiInputAngka(){
        while (true){
            try{
                int angka = Integer.parseInt(scanner.nextLine());
                return angka;
            }catch(NumberFormatException e){
                System.out.println("Masukan angka yang valid");
            }
        }
    }

}
