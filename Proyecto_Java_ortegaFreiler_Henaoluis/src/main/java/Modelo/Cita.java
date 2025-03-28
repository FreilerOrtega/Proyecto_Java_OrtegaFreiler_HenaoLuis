package Modelo;

public class Cita {
    private int id;
    private int pet_id;
    private int owner_id;
    private String dates;
    private String consultation_reason;
    private int veterinarian_id;
    private String diagnosis;
    private boolean attendance;
    private String status;
    private String hours;

    public Cita() {
    }

    public Cita(int id, int pet_id, int owner_id, String dates, String consultation_reason, int veterinarian_id, String diagnosis, boolean attendance, String status, String hours) {
        this.id = id;
        this.pet_id = pet_id;
        this.owner_id = owner_id;
        this.dates = dates;
        this.consultation_reason = consultation_reason;
        this.veterinarian_id = veterinarian_id;
        this.diagnosis = diagnosis;
        this.attendance = attendance;
        this.status = status;
        this.hours = hours;
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

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getConsultation_reason() {
        return consultation_reason;
    }

    public void setConsultation_reason(String consultation_reason) {
        this.consultation_reason = consultation_reason;
    }

    public int getVeterinarian_id() {
        return veterinarian_id;
    }

    public void setVeterinarian_id(int veterinarian_id) {
        this.veterinarian_id = veterinarian_id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}