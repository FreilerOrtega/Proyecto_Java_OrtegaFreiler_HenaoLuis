package Modelo;

public class Contractos_Adopcion {
    private int id;
    private int petId;
    private int ownerId;
    private String date;

    public Contractos_Adopcion() {
    }

    public Contractos_Adopcion(int id, int petId, int ownerId, String date) {
        this.id = id;
        this.petId = petId;
        this.ownerId = ownerId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
