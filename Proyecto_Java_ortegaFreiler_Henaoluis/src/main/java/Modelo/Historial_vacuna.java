package Model;

public class Historialvacuna {
    private int idHistory;  // New attribute 'idHistory'
    private int petId;
    private int vaccineId;
    private String applicationDate;
    private String nextDose;

    public Historialvacuna() {
    }

    public Historialvacuna(int idHistory, int petId, int vaccineId, String applicationDate, String nextDose) {
        this.idHistory = idHistory;  // Initialize the new attribute
        this.petId = petId;
        this.vaccineId = vaccineId;
        this.applicationDate = applicationDate;
        this.nextDose = nextDose;
    }

    public int getIdHistory() {
        return idHistory;  // Getter for 'idHistory'
    }

    public void setIdHistory(int idHistory
