package Modelo;

public class Padecimiento {
    private int id;
    private int id_mascota;
    private String fecha_deteccion;
    private String diagnostico;

    public Padecimiento() {
    }

    public Padecimiento( int id,int id_mascota, String fecha_deteccion, String diagnostico) {
        this.id=id;
        this.id_mascota = id_mascota;
        this.fecha_deteccion = fecha_deteccion;
        this.diagnostico = diagnostico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getFecha_deteccion() {
        return fecha_deteccion;
    }

    public void setFecha_deteccion(String fecha_deteccion) {
        this.fecha_deteccion = fecha_deteccion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
