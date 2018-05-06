package pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Ilies
 * @version 2
 * This is the client data model
 */
public class Client {
    private int idClient;
    private String pseudo;
    private String password;
    private String ClientName;
    private String ClientSurname;
    private String phone;
    private String address;
    private String gender;

    public Client(int idClient,String pseudo, String password, String ClientName, String ClientSurname, String phone, String address, String gender) {
        this.idClient = idClient;
        this.pseudo = pseudo;
        this.password = password;
        this.ClientName = ClientName;
        this.ClientSurname = ClientSurname;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
