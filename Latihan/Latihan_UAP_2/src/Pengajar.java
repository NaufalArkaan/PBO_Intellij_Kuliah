public class Pengajar extends PesertaKursus{
    private String kelasDiajarkan;

    public Pengajar(String nama, String NIK, String kelasDiajarkan){
        super(nama, NIK);
        this.kelasDiajarkan = kelasDiajarkan;
    }

    @Override
    public void tampilkanInfo(){
        System.out.println("Pengajar: " + nama + " | NIK: " + NIK);
        if(kelasDiajarkan != null && !kelasDiajarkan.isEmpty()){
            System.out.println("Mengajar di kelas: " + kelasDiajarkan);
        }else {
            System.out.println("Belum mengajar di kelas manapun.");
        }
    }
}
