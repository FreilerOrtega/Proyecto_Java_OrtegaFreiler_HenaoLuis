package Modelo;

public class Seguimiento_PostAdopcion {
    private int appointment_number;
    private int contractId;
    private String details;
    private String date;

    public Seguimiento_PostAdopcion() {
    }

    public Seguimiento_PostAdopcion(int appointment_number, int contractId, String details, String date) {
        this.appointment_number = appointment_number;
        this.contractId = contractId;
        this.details = details;
        this.date = date;
    }

    public int getAppointment_number() {
        return appointment_number;
    }

    public void setAppointment_number(int appointment_number) {
        this.appointment_number = appointment_number;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
