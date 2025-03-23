package Modelo;

public class Facturas {
    private int id_cliente;
    private int id_medicamento;
    private int cantidad;

    public Facturas() {
    }

    public Facturas(int id_cliente, int id_medicamento, int cantidad) {
        this.id_cliente = id_cliente;
        this.id_medicamento = id_medicamento;
        this.cantidad = cantidad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
