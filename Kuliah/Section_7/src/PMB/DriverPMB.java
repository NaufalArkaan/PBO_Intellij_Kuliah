package PMB;
import java.util.ArrayList;
import java.util.Iterator;

public class DriverPMB {
    public static void main(String[] args) {
        String [] pilihanJurusanBudi = {"Sosiologi", "Kedokteran", "Akutansi"};
//        Calonsiswa budi = new Calonsiswa("Budi", "Yono", pilihanJurusanBudi);
//
//        Calonsiswa heru = new Calonsiswa("heru", "Budi", "Mesin", "PGSD", "");

//        System.out.println(budi.getNama());
//        for(String1 : budi.getPilhanJurusan()){
//            System.out.println("Pilihan Jurusan: " +);
//        }

//        budi.printMahasiswa();
//        heru.printMahasiswa();
        Calonsiswa [] cs = new Calonsiswa[3];
        cs[0] = new Calonsiswa("Budi", "Yono", pilihanJurusanBudi);
        cs[1] = new Calonsiswa("heru", "fadilah", "Mesin", "PGSD", "");
        cs[2] = new Calonsiswa("Asep", "alhamdulillah", "Teknik sipil", "agama islam", "pgsd");
        for(Calonsiswa data: cs){
            data.printMahasiswa();
        }

        ArrayList<Calonsiswa> listcs = new ArrayList<>();
        listcs.add(new Calonsiswa("Budi", "Yono", pilihanJurusanBudi));
        listcs.add(new Calonsiswa("heru", "fadilah", "Mesin", "PGSD", ""));
        listcs.add(new Calonsiswa("Asep", "alhamdulillah", "Teknik sipil", "agama islam", "pgsd"));
        listcs.add(new Calonsiswa("syahril", "ahmad", "Teknik mesin", "agama hindu", "pgsd"));

        Iterator<Calonsiswa> itcs = listcs.iterator();
        while (itcs.hasNext()){
            Calonsiswa data = itcs.next();
            data.printMahasiswa();
        }
    }
}
