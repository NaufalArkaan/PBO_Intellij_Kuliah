import java.util.ArrayList;

public class Siswa extends PesertaKursus implements SkorLatihan{
    private ArrayList<Integer> skorLatihan;

    public Siswa(String nama, String NIK, ArrayList<Integer> skorLatihan){
        super(nama, NIK);
        this.skorLatihan = skorLatihan;
    }

    public void tampilkanInfo(){
        System.out.println("Siswa: " + nama + ", " + "NIK: " + NIK);
    }

    public void tampilkanSemuaSkor(){
        System.out.println("Skor atas nama " + nama + ":");
        for(int i = 0; i < skorLatihan.size(); i++){
            System.out.println("Latihan ke " + (i + 1) + ": " + skorLatihan.get(i)); //ingat pake get karena mabil data
        }
    }

}
