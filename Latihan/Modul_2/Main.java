import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Plant plant1 = new Plant("Sun Flower");
        Plant plant2 = new Plant("Mushroom");
        Farmer farmer1 = new Farmer("Naufal", plant1.name);
        Farmer farmer2 = new Farmer("Asep", plant2.name);

        System.out.println("Current date and time: " + new Date());
        farmer1.talk();
        farmer2.talk();
    }
}
