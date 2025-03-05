import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Farmer farmer1 = new Farmer();
        Farmer farmer2 = new Farmer();
        Plant plant1 = new Plant();
        Plant plant2 = new Plant();

        farmer1.name = "Naufal";
        farmer2.name = "Arkaan";
        plant1.name = "Sun flower";
        plant2.name = "Mushroom";

        farmer1.favourite = plant1.name;
        farmer2.favourite = plant2.name;


        System.out.println("Current date and time: " + new Date());
        farmer1.talk();
        farmer2.talk();
    }
}
