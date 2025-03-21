package Modelo;

public class Procedimientos {
    private int id_mascota;
    private String procedimiento_aplicado;
    private String fecha;
    private int id_veterinario;
    private int id_cita_asignada;

    public Procedimientos() {
    }

    public Procedimientos(int id_mascota, String procedimiento_aplicado, String fecha, int id_veterinario, int id_cita_asignada) {
        this.id_mascota = id_mascota;
        this.procedimiento_aplicado = procedimiento_aplicado;
        this.fecha = fecha;
        this.id_veterinario = id_veterinario;
        this.id_cita_asignada = id_cita_asignada;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getProcedimiento_aplicado() {
        return procedimiento_aplicado;
    }

    public void setProcedimiento_aplicado(String procedimiento_aplicado) {
        this.procedimiento_aplicado = procedimiento_aplicado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public int getId_cita_asignada() {
        return id_cita_asignada;
    }

    public void setId_cita_asignada(int id_cita_asignada) {
        this.id_cita_asignada = id_cita_asignada;
    }
}
