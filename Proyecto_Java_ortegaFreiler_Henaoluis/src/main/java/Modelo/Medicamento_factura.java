package Model;

public class Medicamento_facturado {
    private int invoiceId;  // Added invoiceId attribute
    private int medicationId;
    private int quantity;

    public Medicamento_facturado() {
    }

    public Medicamento_facturado(int invoiceId, int medicationId, int quantity) {
        this.invoiceId = invoiceId;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    // Getter and Setter for 'invoiceId'
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    // Getter and Setter for 'medicationId'
    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    // Getter and Setter for 'quantity'
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
