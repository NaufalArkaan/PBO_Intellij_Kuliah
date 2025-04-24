public class User {
    protected String username;
    protected String password;

    void register(String username, String password){
        this.username = username;
        this.password = password;
        System.out.println("Username: " + this.username);
        System.out.println("Password: " + this.password);
    }

    void notification(){
        System.out.println("User created by User");
    }
}
