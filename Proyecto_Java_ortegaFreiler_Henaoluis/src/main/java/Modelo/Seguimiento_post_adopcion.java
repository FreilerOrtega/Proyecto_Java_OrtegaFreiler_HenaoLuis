package Modelo;

public class Seguimiento_post_adopcion {
    private int id_contrato;
    private String detalles;
    private String fecha;

    public Seguimiento_post_adopcion() {
    }

    public Seguimiento_post_adopcion(int id_contrato, String detalles, String fecha) {
        this.id_contrato = id_contrato;
        this.detalles = detalles;
        this.fecha = fecha;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
