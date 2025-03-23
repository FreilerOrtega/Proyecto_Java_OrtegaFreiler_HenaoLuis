package Modelo;

public class Seguimiento_PostAdopcion {
    private int contractId;
    private String details;
    private String date;

    public Seguimiento_PostAdopcion() {
    }

    public Seguimiento_PostAdopcion(int contractId, String details, String date) {
        this.contractId = contractId;
        this.details = details;
        this.date = date;
    }

    // Getter and Setter for 'contractId'
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    // Getter and Setter for 'details'
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Getter and Setter for 'date'
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
