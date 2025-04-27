package humans;
import plants.Talkable;

public class Farmer {
    private String name;
    private String favourite;

    public Farmer(String name, String favourite){

    }
    public Farmer(String name){
        this.name = name;
        this.favourite = "No favorite plat yet";
    }
    public void talk(Talkable talkable){
        talkable.talk();
    }
}
