import java.util.ArrayList;
import java.util.Iterator;

public class OrangTua extends Keluarga {
    private final ArrayList<Anak> daftarAnak = new ArrayList<>();

    public OrangTua(String namaDepan, String namaBelakang){
        super(namaDepan, namaBelakang);
    }

    public void tambahAnak(Anak anak){
        daftarAnak.add(anak);
    }

    public void tampilkanDaftarAnak(){
        if(daftarAnak.isEmpty()){
            System.out.println(getNamaLengkap() + " belum memiliki anak.");
            return;
        }

        System.out.println("Daftar anak dari" + getNamaLengkap() + ":");
        Iterator<Anak> iterator = daftarAnak.iterator();
        int nomor = 1;
        while(iterator.hasNext()){
            Anak anak = iterator.next();
            System.out.println(nomor + ". " + anak.getNamaLengkap());
            nomor++;
        }
    }

    public int jumlahAnak(){
        return daftarAnak.size();
    }

    public ArrayList<Anak> getDaftarAnak(){
        return  daftarAnak;
    }

    @Override
    public void tampilkanInfo(){
        System.out.println("Orang tua: " + getNamaLengkap());
    }
}
