package Modelo;

public  class Persona {
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private int num_identificacion;
    private String direccion;
    private int telefono;
    private String correo;
    private int contacto_emergencia;


    public Persona(){}

    public Persona(String nombre1, String nombre2, String apellido1, String apellido2, int num_identificacion, String direccion, int telefono, String correo, int contacto_emergencia) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.num_identificacion = num_identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto_emergencia = contacto_emergencia;


    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getNum_identificacion() {
        return num_identificacion;
    }

    public void setNum_identificacion(int num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getContacto_emergencia() {
        return contacto_emergencia;
    }

    public void setContacto_emergencia(int contacto_emergencia) {
        this.contacto_emergencia = contacto_emergencia;
    }
}
