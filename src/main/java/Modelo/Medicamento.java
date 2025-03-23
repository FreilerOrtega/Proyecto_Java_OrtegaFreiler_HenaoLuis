package Modelo;

public class Medicamento {
    private String nombre;
    private int id_lote;
    private String fabricante;
    private int tipo;
    private String presentacion;
    private int precio;

    public Medicamento() {
    }

    public Medicamento(String nombre, int id_lote, String fabricante, int tipo, String presentacion, int precio) {
        this.nombre = nombre;
        this.id_lote = id_lote;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_lote() {
        return id_lote;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
