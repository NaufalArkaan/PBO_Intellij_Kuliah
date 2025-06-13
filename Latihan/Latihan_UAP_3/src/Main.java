import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        OrangTua orangtua = new OrangTua("nopal", "amin");
        orangtua.tambahAnak(new Anak("Andi", "Santoso", new double[]{3.4, 4.1, 4.1, 4.2, 4.5, 4.6}));
        orangtua.tambahAnak(new Anak("Siti", "Santoso", new double[]{5.4, 5.1, 5.1, 5.2, 5.5, 5.6}));

        int pilihan;
        do{
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Tampilkan Daftar Anak");
            System.out.println("2. Tampilkan Berat Badan Anak");
            System.out.println("3. Tampilkan Jumlah Anak");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan){
                case 1:
                    orangtua.tampilkanDaftarAnak();
                    break;
                case 2:
                    orangtua.tampilkanDaftarAnak();
                    if(orangtua.jumlahAnak() == 0) break;

                    System.out.print("Pilih nomor anak: ");
                    int nomor = scanner.nextInt();

                    if (nomor >= 1 && nomor <= orangtua.jumlahAnak()){
                        Anak anakDipilih = orangtua.getDaftarAnak().get(nomor - 1);
                        anakDipilih.tampilkanBeratBadan();
                    }else{
                        System.out.println("Nomor anak tidak valid");
                    }
                    break;
                case 3:
                    System.out.println("Jumlah anak: " + orangtua.jumlahAnak());
                    break;
                case 4:
                    System.out.println("Terima Kasih...");
                    break;
                default:
                    System.out.println("Invalid");
            }

        }while(pilihan != 4);
        scanner.close();
    }
}
