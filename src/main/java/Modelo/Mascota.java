package Modelo;

public class Mascota {
    private int id;
    private String nombre;
    private String especie ;
    private String raza;
    private int edad;
    private String fecha_nacimiento;
    private String sexo;
    private double peso ;
    private String foto;
    private String tatuaje;
    private String microChip;
    private int id_dueno;

    public Mascota(){}

    public Mascota(int id,String nombre, String especie, String raza, int edad, String fecha_nacimiento, String sexo, double peso, String foto, String tatuaje,String microChip, int id_dueno) {
        this.id=id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.foto = foto;
        this.tatuaje = tatuaje;
        this.microChip=microChip;
        this.id_dueno = id_dueno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTatuaje() {
        return tatuaje;
    }

    public void setTatuaje(String tatuaje) {
        this.tatuaje = tatuaje;
    }

    public String getMicroChip() {
        return microChip;
    }

    public void setMicroChip(String microChip) {
        this.microChip = microChip;
    }

    public int getId_dueno() {
        return id_dueno;
    }

    public void setId_dueno(int id_dueno) {
        this.id_dueno = id_dueno;
    }
}
