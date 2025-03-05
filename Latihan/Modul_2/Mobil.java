public class Mobil {
    String merk = "Toyota";
    String harga = "450.000.000";
    int kecepatan = 240;

    static void menyalakanMobil(){
        System.out.println("Mesin mobil menyala.");
    }
    static String mengemudi(String arah){
        return "Mobil bergerak ke " + arah;
    }
    String mengerem(){
        return "Berhenti.";
    }
    int topSpeed(int speed){
        return speed;
    }

    public static void main(String[] args) {
        Mobil mobil = new Mobil();
//        System.out.println(mengemudi("kanan"));
//        menyalakanMobil();
//        mobil.mengerem();
//        mobil.menyalakanMobil();
//        System.out.println(mobil.harga);
//        System.out.println(mobil.kecepatan);
    }
}
