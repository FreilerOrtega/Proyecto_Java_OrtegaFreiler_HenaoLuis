package Modelo;

public class Historial_vacuna {
    private int id;
    private int petId;
    private int vaccineId;
    private String applicationDate;
    private String nextDose;

    public Historial_vacuna() {
    }

    public Historial_vacuna(int id, int petId, int vaccineId, String applicationDate, String nextDose) {
        this.id = id;
        this.petId = petId;
        this.vaccineId = vaccineId;
        this.applicationDate = applicationDate;
        this.nextDose = nextDose;
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

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getNextDose() {
        return nextDose;
    }

    public void setNextDose(String nextDose) {
        this.nextDose = nextDose;
    }
}