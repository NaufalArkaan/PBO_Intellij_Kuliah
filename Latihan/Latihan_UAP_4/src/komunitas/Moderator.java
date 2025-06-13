package komunitas;

import actions.CetakData;

public class Moderator extends PesertaKomunitas implements CetakData {
    public String namaForum;
    public Moderator(String nama, String idPeserta, String namaForum){
        super(nama, idPeserta);
        this.namaForum = namaForum;
    }

    @Override
    public void tampilkanInfo(){
        System.out.println("Nama Forum: " + namaForum);
    }

    @Override
    public void dataPeserta(){
        System.out.println(getNama());
    }
}
