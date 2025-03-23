package Modelo;

public class Procedimientos {
    private int id ;
    private int pet_id;
    private String procedurer ;
    private String dates ;
    private int veterinarian_id;
    private int appointment_id;

    public Procedimientos() {
    }

    public Procedimientos(int id, int pet_id, String procedurer, String dates, int veterinarian_id, int appointment_id) {
        this.id = id;
        this.pet_id = pet_id;
        this.procedurer = procedurer;
        this.dates = dates;
        this.veterinarian_id = veterinarian_id;
        this.appointment_id = appointment_id;
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

    public String getProcedurer() {
        return procedurer;
    }

    public void setProcedurer(String procedurer) {
        this.procedurer = procedurer;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public int getVeterinarian_id() {
        return veterinarian_id;
    }

    public void setVeterinarian_id(int veterinarian_id) {
        this.veterinarian_id = veterinarian_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }
}
