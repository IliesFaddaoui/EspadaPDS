package pojo;

public class EtablishedProfile {
    private int idEtablishedProfile;
    private int idTypicalProfile;
    private int idClient;

    public EtablishedProfile(int idEtablishedProfile, int idTypicalProfile, int idClient) {
        this.idEtablishedProfile = idEtablishedProfile;
        this.idTypicalProfile = idTypicalProfile;
        this.idClient = idClient;
    }

    public int getIdEtablishedProfile() {
        return idEtablishedProfile;
    }

    public void setIdEtablishedProfile(int idEtablishedProfile) {
        this.idEtablishedProfile = idEtablishedProfile;
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
