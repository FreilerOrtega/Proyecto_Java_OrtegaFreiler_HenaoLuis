package Modelo;

public class Desparacitaciones {
    private String tipo;
    private String fecha_aplicacion;
    private String proxima_aplicacion;
    private int id_medico;
    private int id_mascota;
    private int  id_veterinario;

    public Desparacitaciones() {
    }

    public Desparacitaciones(String tipo, String fecha_aplicacion, String proxima_aplicacion, int id_medico, int id_mascota, int id_veterinario) {
        this.tipo = tipo;
        this.fecha_aplicacion = fecha_aplicacion;
        this.proxima_aplicacion = proxima_aplicacion;
        this.id_medico = id_medico;
        this.id_mascota = id_mascota;
        this.id_veterinario = id_veterinario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getProxima_aplicacion() {
        return proxima_aplicacion;
    }

    public void setProxima_aplicacion(String proxima_aplicacion) {
        this.proxima_aplicacion = proxima_aplicacion;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }
}
