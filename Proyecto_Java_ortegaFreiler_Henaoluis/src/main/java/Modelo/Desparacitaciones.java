package Modelo;

public class Desparacitaciones {
    private int id;
    private String type;
    private String applicationDate;
    private String nextApplication;
    private int medicine_id;
    private int petId;
    private int veterinarianId;

    public Desparacitaciones() {
    }

    public Desparacitaciones(int id, String type, String applicationDate, String nextApplication, int doctorId, int petId, int veterinarianId) {
        this.id = id;
        this.type = type;
        this.applicationDate = applicationDate;
        this.nextApplication = nextApplication;
        this.medicine_id = doctorId;
        this.petId = petId;
        this.veterinarianId = veterinarianId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getNextApplication() {
        return nextApplication;
    }

    public void setNextApplication(String nextApplication) {
        this.nextApplication = nextApplication;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
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
}
 