package Modelo;

public class Contractos_Adopcion {
    private int id_mascota;
    private int id_dueno;
    private String fecha ;


    public Contractos_Adopcion() {
    }

    public Contractos_Adopcion(int id_mascota, int id_dueno, String fecha) {
        this.id_mascota = id_mascota;
        this.id_dueno = id_dueno;
        this.fecha = fecha;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getId_dueno() {
        return id_dueno;
    }

    public void setId_dueno(int id_dueno) {
        this.id_dueno = id_dueno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
