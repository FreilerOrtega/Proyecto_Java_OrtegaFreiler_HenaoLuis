package Modelo;

public class Lote {
    private String fecha_entrada;
    private int cantidad_entrada;
    private int cantidad_actual;
    private String fecha_vencimiento;


    public Lote() {
    }

    public Lote(String fecha_entrada, int cantidad_entrada, int cantidad_actual, String fecha_vencimiento) {
        this.fecha_entrada = fecha_entrada;
        this.cantidad_entrada = cantidad_entrada;
        this.cantidad_actual = cantidad_actual;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public int getCantidad_entrada() {
        return cantidad_entrada;
    }

    public void setCantidad_entrada(int cantidad_entrada) {
        this.cantidad_entrada = cantidad_entrada;
    }

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}
