package utama;

public class PesertaUmum extends PesertaLomba{
    public String asal;

    public PesertaUmum(String nama, String nomorPeserta, String asal){
        super(nama, nomorPeserta);
        this.asal = asal;
    }

    @Override
    public void cetakData(){
        System.out.println("=== Cetak Data ===");
        System.out.println("Nama: " + getNama() + ", Nomor Peserta: " + getNomorPeserta() + ", asal: " + asal);
    }
}
