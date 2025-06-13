public class Anak extends Keluarga{
    private double[] beratBadan = new double[6];

    public Anak(String namaDepan, String namaBelakang, double[] beratBadan){
        super(namaDepan, namaBelakang);
        if(beratBadan.length != 6){
            throw new IllegalArgumentException("Data berat badan harus 6 bulan");
        }
        this.beratBadan = beratBadan;
    }

    public void tampilkanBeratBadan(){
        System.out.println("berat badan untuk: " + getNamaBelakang() + ":"  );
        for(int i = 0; i < beratBadan.length; i++){
            System.out.printf("Bulan %d: %.2f kg%n", i + 1, beratBadan[i]);
        }
    }

    @Override
    public void tampilkanInfo(){
        System.out.println("Anak " + getNamaLengkap());
    }
}
