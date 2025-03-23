package Modelo;

public class Lote {
    private int idBatch;  // New attribute 'idBatch'
    private String entryDate;
    private int entryQuantity;
    private int currentQuantity;
    private String expirationDate;

    public Lote() {
    }

    public Lote(String entryDate, int entryQuantity, int currentQuantity, String expirationDate) {
        this.entryDate = entryDate;
        this.entryQuantity = entryQuantity;
        this.currentQuantity = currentQuantity;
        this.expirationDate = expirationDate;
    }

    // Getter and Setter for 'idBatch'
    public int getIdBatch() {
        return idBatch;
    }

    public void setIdBatch(int idBatch) {
        this.idBatch =
