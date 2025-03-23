package Modelo;

public  class Persona {
    private int id ;
    private String first_name ;
    private String second_name ;
    private String last_name1 ;
    private String last_name2 ;
    private long id_number;
    private String address ;
    private long phone ;
    private String email ;
    private long emergency_contact;
    private String person_type;


    public Persona(){}

    public Persona(int id, String first_name, String second_name, String last_name1, String last_name2, long id_number, String address, long phone, String email, long emergency_contact, String person_type) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name1 = last_name1;
        this.last_name2 = last_name2;
        this.id_number = id_number;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.emergency_contact = emergency_contact;
        this.person_type = person_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLast_name1() {
        return last_name1;
    }

    public void setLast_name1(String last_name1) {
        this.last_name1 = last_name1;
    }

    public String getLast_name2() {
        return last_name2;
    }

    public void setLast_name2(String last_name2) {
        this.last_name2 = last_name2;
    }

    public long getId_number() {
        return id_number;
    }

    public void setId_number(long id_number) {
        this.id_number = id_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(long emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public String getAllName(){
        return first_name+" "+second_name+" "+last_name1+" "+last_name2;
    }
}

