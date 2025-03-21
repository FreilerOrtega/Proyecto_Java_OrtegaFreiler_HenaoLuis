package Modelo;

public class Login {
    private String usuario;
    private String contrasena;
    private int id_persona;


    public Login() {
    }

    public Login(String usuario, String contrasena, int id_persona) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.id_persona = id_persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
}
