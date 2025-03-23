package Modelo;

public class Medicamento {
    private int idMedication;  // Added idMedication attribute
    private String name;
    private int batchId;
    private String manufacturer;
    private int type;
    private String presentation;
    private int price;

    public Medicamento() {}

    public Medicamento(String name, int batchId, String manufacturer, int type, String presentation, int price) {
        this.name = name;
        this.batchId = batchId;
        this.manufacturer = manufacturer;
        this.type = type;
        this.presentation = presentation;
        this.price = price;
    }

    // Getter and Setter for 'idMedication'
    public int getIdMedication() {
        return idMedication;
    }

    public void setIdMedication(int idMedication) {
        this.idMedication = idMedication;
    }

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'batchId'
    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    // Getter and Setter for 'manufacturer'
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Getter and Setter for 'type'
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // Getter and Setter for 'presentation'
    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    // Getter and Setter for 'price'
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
