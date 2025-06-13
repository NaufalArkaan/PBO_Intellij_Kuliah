package utama;

public abstract class PesertaLomba {
    private String nama;
    private String nomorPeserta;

    public PesertaLomba(String nama, String nomorPeserta){
        this.nama = nama;
        this.nomorPeserta = nomorPeserta;
    }

    public String getNama(){
        return nama;
    }
    public String getNomorPeserta(){
        return nomorPeserta;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNomorPeserta(String nomorPeserta){
        this.nomorPeserta = nomorPeserta;
    }

    public abstract void cetakData();
}
