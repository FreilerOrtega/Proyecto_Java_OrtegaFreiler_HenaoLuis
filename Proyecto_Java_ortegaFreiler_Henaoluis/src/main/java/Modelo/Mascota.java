package Modelo;

public class Mascota {
    private int id;
    private String nameP;
    private String species;
    private String breed;
    private int age;
    private String birth_date;
    private String gender;
    private double weight;
    private String photo;
    private int owner_id;
    private String  microChip;
    private String tatto;

    public Mascota(){}

    public Mascota(int id, String nameP, String species, String breed, int age, String birth_date, String gender, double weight, String photo, int owner_id, String microChip, String tatto) {
        this.id = id;
        this.nameP = nameP;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.birth_date = birth_date;
        this.gender = gender;
        this.weight = weight;
        this.photo = photo;
        this.owner_id = owner_id;
        this.microChip = microChip;
        this.tatto = tatto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getMicroChip() {
        return microChip;
    }

    public void setMicroChip(String microChip) {
        this.microChip = microChip;
    }

    public String getTatto() {
        return tatto;
    }

    public void setTatto(String tatto) {
        this.tatto = tatto;
    }
}
