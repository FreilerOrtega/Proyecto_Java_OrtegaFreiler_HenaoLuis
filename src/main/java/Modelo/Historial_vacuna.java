package Modelo;

public class Historial_vacuna {
    private int id_mascota;
    private int  id_vacuna;
    private String fecha_aplicacion;
    private String proxima_dosis;

    public Historial_vacuna() {
    }

    public Historial_vacuna(int id_mascota, int id_vacuna, String fecha_aplicacion, String proxima_dosis) {
        this.id_mascota = id_mascota;
        this.id_vacuna = id_vacuna;
        this.fecha_aplicacion = fecha_aplicacion;
        this.proxima_dosis = proxima_dosis;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(int id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getProxima_dosis() {
        return proxima_dosis;
    }

    public void setProxima_dosis(String proxima_dosis) {
        this.proxima_dosis = proxima_dosis;
    }
}
