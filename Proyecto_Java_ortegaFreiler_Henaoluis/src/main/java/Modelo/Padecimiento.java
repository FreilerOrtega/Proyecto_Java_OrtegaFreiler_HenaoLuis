package Modelo;

public class Padecimiento {
    private int id ;
    private int pet_id;
    private String detection_date;
    private String diagnosis;

    public Padecimiento() {
    }

    public Padecimiento(int id, int pet_id, String detection_date, String diagnosis) {
        this.id = id;
        this.pet_id = pet_id;
        this.detection_date = detection_date;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getDetection_date() {
        return detection_date;
    }

    public void setDetection_date(String detection_date) {
        this.detection_date = detection_date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
