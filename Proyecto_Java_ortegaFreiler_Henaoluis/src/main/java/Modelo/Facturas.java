package Model;

public class Facturas {
    private int idInvoice;  // New attribute 'idInvoice'
    private int clientId;
    private int medicationId;
    private int quantity;

    public Facturas() {
    }

    public Facturas(int idInvoice, int clientId, int medicationId, int quantity) {
        this.idInvoice = idInvoice;  // Initialize the new attribute
        this.clientId = clientId;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    public int getIdInvoice() {
        return idInvoice;  // Getter for 'idInvoice'
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;  // Setter for 'idInvoice'
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
