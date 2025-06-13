package komunitas;

import actions.CetakData;

import java.util.ArrayList;

public class Pembaca extends PesertaKomunitas implements CetakData {
    public ArrayList<Integer> skor;
    public Pembaca(String nama, String idPeserta, ArrayList<Integer> skor){
        super(nama, idPeserta);
        this.skor = skor;
    }

    @Override
    public void tampilkanInfo(){
        System.out.println("Skor: " + skor);
    }

    @Override
    public void dataPeserta(){
        System.out.println(getNama());
    }
}
