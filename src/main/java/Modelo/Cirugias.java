package Modelo;

public class Cirugias{
    private int id_mascota;
    private int id_veterinarios;
    private String fecha_cirujia;
    private int dias_recuperacion;

    public Cirugias() {
    }

    public Cirugias(int id_mascota, int id_veterinarios, String fecha_cirujia, int dias_recuperacion) {
        this.id_mascota = id_mascota;
        this.id_veterinarios = id_veterinarios;
        this.fecha_cirujia = fecha_cirujia;
        this.dias_recuperacion = dias_recuperacion;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getId_veterinarios() {
        return id_veterinarios;
    }

    public void setId_veterinarios(int id_veterinarios) {
        this.id_veterinarios = id_veterinarios;
    }

    public String getFecha_cirujia() {
        return fecha_cirujia;
    }

    public void setFecha_cirujia(String fecha_cirujia) {
        this.fecha_cirujia = fecha_cirujia;
    }

    public int getDias_recuperacion() {
        return dias_recuperacion;
    }

    public void setDias_recuperacion(int dias_recuperacion) {
        this.dias_recuperacion = dias_recuperacion;
    }
}
