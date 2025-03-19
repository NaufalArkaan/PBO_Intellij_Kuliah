public class Farmer {
    String name;
    String favourite;

    public Farmer(String name, String favourite){
        this.name = name;
        this.favourite = favourite;
    }

    void talk(){
        System.out.println("Hi, my name is: " + name + ". My favourite plants is: " + favourite);
    }
}
