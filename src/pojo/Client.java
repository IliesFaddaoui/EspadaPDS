package pojo;

import java.util.ArrayList;
import java.util.Date;

public class Client {
    private int idClient;
    private String ClientName;
    private String ClientSurname;
    private Date birthDate;
    private String phone;
    private String address;
    private String gender;

    public Client(int idClient, String ClientName, String ClientSurname, Date birthDate, String phone, String address, String gender) {
        this.idClient = idClient;
        this.ClientName = ClientName;
        this.ClientSurname = ClientSurname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getClientName() {
        return ClientName;
    }

    public String getClientSurname() {
        return ClientSurname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }


    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setClientName(String name) {
        this.ClientName = name;
    }

    public void setClientSurname(String surname) {
        this.ClientSurname = surname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
