package komunitas;

public abstract class PesertaKomunitas {
    private String nama;
    private String idPeserta;

    public PesertaKomunitas(String nama, String idPeserta){
        this.nama = nama;
        this.idPeserta = idPeserta;
    }

    public String getNama(){
        return nama;
    }
    public String getidPeserta(){
        return idPeserta;
    }

    public abstract void tampilkanInfo();
}
