package Modelo;

public class Medicamento_factura {
    private int id;
    private int medicationId;
    private int quantity;

    public Medicamento_factura() {
    }

    public Medicamento_factura(int id, int medicationId, int quantity) {
        this.id = id;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
