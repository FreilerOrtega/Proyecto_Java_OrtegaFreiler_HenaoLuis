package Model;

public class Desparacitaciones {
    private int idDeworming;  // New attribute 'idDeworming'
    private String type;
    private String applicationDate;
    private String nextApplication;
    private int doctorId;
    private int petId;
    private int veterinarianId;

    public Desparacitaciones() {
    }

    public Desparacitaciones(int idDeworming, String type, String applicationDate, String nextApplication, int doctorId, int petId, int veterinarianId) {
        this.idDeworming = idDeworming;  // Initialize new attribute
        this.type = type;
        this.applicationDate = applicationDate;
        this.nextApplication = nextApplication;
        this.doctorId = doctorId;
        this.petId = petId;
        this.veterinarianId = veterinarianId;
    }

    public int getIdDeworming() {
        return idDeworming;  // Getter for 'idDeworming'
    }

    public void setIdDeworming(int idDeworming) {
        this.idDeworming = idDeworming;  // Setter for 'idDeworming'
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

    public int getDoctorId() {
        return doctor
