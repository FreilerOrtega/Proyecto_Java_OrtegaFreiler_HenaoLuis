package Modelo;

public class Medicamento_factura {
    private int id_factura;
    private int id_medicamento;
    private int cantidad ;

    public Medicamento_factura() {
    }

    public Medicamento_factura(int id_factura, int id_medicamento, int cantidad) {
        this.id_factura = id_factura;
        this.id_medicamento = id_medicamento;
        this.cantidad = cantidad;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
