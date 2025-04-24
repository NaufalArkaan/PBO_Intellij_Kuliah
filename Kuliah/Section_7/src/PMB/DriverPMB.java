package PMB;

public class DriverPMB {
    public static void main(String[] args) {
        String [] pilihanJurusanBudi = {"Sosiologi", "Kedokteran", "Akutansi"};
        Calonsiswa budi = new Calonsiswa("Budi", "Yono", pilihanJurusanBudi);

        Calonsiswa heru = new Calonsiswa("heru", "Budi", "Mesin", "PGSD", "");

        System.out.println(budi.getNama());
    }
}
