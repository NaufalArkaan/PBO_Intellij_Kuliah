public class Admin extends User{
    void createUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    void notification(){
        final String role = "Admin";
        System.out.println("User created by " + role);
    }
}
