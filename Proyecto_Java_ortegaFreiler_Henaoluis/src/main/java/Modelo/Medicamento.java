package Modelo;

public class Medicamento {
    private int id;
    private String name;
    private int batchId;
    private String manufacturer;
    private int type;
    private String presentation;
    private int price;

    public Medicamento() {}

    public Medicamento(int id, String name, int batchId, String manufacturer, int type, String presentation, int price) {
        this.id = id;
        this.name = name;
        this.batchId = batchId;
        this.manufacturer = manufacturer;
        this.type = type;
        this.presentation = presentation;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
