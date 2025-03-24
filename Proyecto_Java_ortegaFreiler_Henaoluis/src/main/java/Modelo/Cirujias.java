package Modelo;

public class Cirujias {
    private int id;
    private int petId;
    private int veterinarianId;
    private String surgeryDate;
    private int recoveryDays;
    private String recovery_status;

    public Cirujias() {
    }

    public Cirujias(int id, int petId, int veterinarianId, String surgeryDate, int recoveryDays, String recovery_status) {
        this.id = id;
        this.petId = petId;
        this.veterinarianId = veterinarianId;
        this.surgeryDate = surgeryDate;
        this.recoveryDays = recoveryDays;
        this.recovery_status = recovery_status;
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

    public int getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(int veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public String getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(String surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public int getRecoveryDays() {
        return recoveryDays;
    }

    public void setRecoveryDays(int recoveryDays) {
        this.recoveryDays = recoveryDays;
    }

    public String getRecovery_status() {
        return recovery_status;
    }

    public void setRecovery_status(String recovery_status) {
        this.recovery_status = recovery_status;
    }
}
