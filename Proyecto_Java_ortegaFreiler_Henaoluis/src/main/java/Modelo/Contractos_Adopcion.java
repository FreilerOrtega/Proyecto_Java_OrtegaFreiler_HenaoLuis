package modelo;

public class Contractos_Adopcion {
    private int idContract;  // New attribute 'idContract'
    private int petId;
    private int ownerId;
    private String date;

    public Contractos_Adopcion() {
    }

    public Contractos_Adopcion(int idContract, int petId, int ownerId, String date) {
        this.idContract = idContract;  // Initialization of the new attribute
        this.petId = petId;
        this.ownerId = ownerId;
        this.date = date;
    }

    public int getIdContract() {
        return idContract;  // Getter for 'idContract'
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;  // Setter for 'idContract'
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
