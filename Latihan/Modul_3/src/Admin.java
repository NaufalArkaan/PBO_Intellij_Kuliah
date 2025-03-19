public class Admin extends User {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password){
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void info() {
        System.out.println("Login berhasil sebagai Admin!");
//        super.info();
    }
}