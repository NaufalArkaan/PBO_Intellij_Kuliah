public abstract class Keluarga {
    private final String namaDepan;
    private final String namaBelakang;

    public Keluarga(String namaDepan, String namaBelakang){
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public String getNamaDepan(){
        return namaDepan;
    }
    public String getNamaBelakang(){
        return namaBelakang;
    }

    public String getNamaLengkap(){
        return  namaDepan + " " + namaBelakang;
    }

    public abstract void tampilkanInfo();
}
