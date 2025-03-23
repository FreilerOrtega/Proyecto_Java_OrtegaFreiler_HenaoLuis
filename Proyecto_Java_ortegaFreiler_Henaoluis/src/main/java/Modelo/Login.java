package Modelo;

public class Login {
    private int id;
    private String username;
    private String password;
    private int personId;

    public Login() {
    }

    public Login(int id, String username, String password, int personId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}