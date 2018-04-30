package pojo;

public class LinkClientTP {
    private int idLinkClientTP;
    private int idTypicalProfile;
    private int idClient;

    public LinkClientTP(int idEtablishedProfile, int idTypicalProfile, int idClient) {
        this.idLinkClientTP = idEtablishedProfile;
        this.idTypicalProfile = idTypicalProfile;
        this.idClient = idClient;
    }

    public int getIdLinkClientTP() {
        return idLinkClientTP;
    }

    public void setIdLinkClientTP(int idEtablishedProfile) {
        this.idLinkClientTP = idEtablishedProfile;
    }

    public int getIdTypicalProfile() {
        return idTypicalProfile;
    }

    public void setIdTypicalProfile(int idTypicalProfile) {
        this.idTypicalProfile = idTypicalProfile;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
