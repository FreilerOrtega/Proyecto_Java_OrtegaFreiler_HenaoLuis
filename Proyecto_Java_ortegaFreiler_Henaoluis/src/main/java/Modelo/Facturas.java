package Modelo;

public class Facturas {
    private int id;
    private int clientId;
    private String description;
    private int total;
    private String date;

    public Facturas() {
    }

    public Facturas(int id, int clientId, String description, int total, String date) {
        this.id = id;
        this.clientId = clientId;
        this.description = description;
        this.total = total;
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
