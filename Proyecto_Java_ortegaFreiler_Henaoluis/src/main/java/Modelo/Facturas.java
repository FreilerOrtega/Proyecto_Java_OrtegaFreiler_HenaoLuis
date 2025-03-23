package Modelo;

public class Facturas {
    private int id;
    private int clientId;
    private int medicationId;
    private int quantity;

    public Facturas() {
    }

    public Facturas(int id, int clientId, int medicationId, int quantity) {
        this.id = id;
        this.clientId = clientId;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
