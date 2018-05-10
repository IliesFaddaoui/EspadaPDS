package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the LinkClientTP data model
 */
public class LinkClientTP {
    private int idLinkClientTP;
    private int idTypeProfile;
    private int idClient;

    public LinkClientTP(int idEtablishedProfile, int idTypeProfile, int idClient) {
        this.idLinkClientTP = idEtablishedProfile;
        this.idTypeProfile = idTypeProfile;
        this.idClient = idClient;
    }

    public int getIdLinkClientTP() {
        return idLinkClientTP;
    }

    public void setIdLinkClientTP(int idEtablishedProfile) {
        this.idLinkClientTP = idEtablishedProfile;
    }

    public int getIdTypeProfile() {
        return idTypeProfile;
    }

    public void setIdTypeProfile(int idTypeProfile) {
        this.idTypeProfile = idTypeProfile;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
