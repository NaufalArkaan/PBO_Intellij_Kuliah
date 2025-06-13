package utama;
import actions.Selesksi;
import java.util.ArrayList;
import java.util.Iterator;

public class PesertaMahasiswa extends PesertaLomba implements Selesksi{
    public static ArrayList<Integer> skor;
    public PesertaMahasiswa(String nama, String nomorPeserta, ArrayList<Integer> skor){
        super(nama, nomorPeserta);
        this.skor = skor;
    }

    @Override
    public void cetakData(){
        System.out.println("Nama: " + getNama() + ", Nomor Peserta: " + getNomorPeserta());
    }

    @Override
    public void dataScore(){
        int tahap = 1;
        System.out.println("=== Cetak 4 Tahap ===");
        Iterator<Integer> it = skor.iterator();
        while(it.hasNext()){
            int Nilai = it.next();
            System.out.println("Tahap: " + tahap + "Score: " + Nilai);
        }
    }
}
