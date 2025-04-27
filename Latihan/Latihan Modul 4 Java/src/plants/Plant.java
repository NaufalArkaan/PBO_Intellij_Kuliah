package plants;

public class Plant extends LivingThing implements Talkable{ //implementasi interface
    protected String name;

    public  Plant(String name){
        this.name = name;
    }

    @Override
    public void talk(){
        System.out.println("i am a plant named " + name);
    }
    @Override
    public void grow(){
        System.out.println(name + " is growing slowly");
    }
}
