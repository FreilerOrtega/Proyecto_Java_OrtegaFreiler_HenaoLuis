package Modelo;

public class Login {
    private int idLogin;  // New attribute 'idLogin'
    private String username;
    private String password;
    private int personId;

    public Login() {
    }

    public Login(String username, String password, int personId) {
        this.username = username;
        this.password = password;
        this.personId = personId;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password =
