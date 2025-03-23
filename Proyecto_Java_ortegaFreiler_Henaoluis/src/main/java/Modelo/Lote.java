package Modelo;

public class Lote {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public int getEntryQuantity() {
        return entryQuantity;
    }

    public void setEntryQuantity(int entryQuantity) {
        this.entryQuantity = entryQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}