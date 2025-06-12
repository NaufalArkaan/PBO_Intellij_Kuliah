public abstract class PesertaKursus {
    protected String nama;
    protected String NIK;

    public PesertaKursus(String nama, String NIK){
        this.nama = nama;
        this.NIK = NIK;
    }

    public String getNama(){
        return nama;
    }

    public String getNik(){
        return NIK;
    }

    public abstract void tampilkanInfo();

}
