package Modelo;

public class Medicamento_factura {
    private int invoice_id;
    private int medicationId;
    private int quantity;

    public Medicamento_factura() {
    }

    public Medicamento_factura(int invoice_id, int medicationId, int quantity) {
        this.invoice_id = invoice_id;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
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
