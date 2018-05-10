package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the TypeProfile data model
 */
public class TypeProfile {
    private int idTypeProfile;
    private String profilName;

    public TypeProfile(int idTypeProfile, String profilName) {
        this.idTypeProfile = idTypeProfile;
        this.profilName = profilName;
    }

    public int getIdTypeProfile() {
        return idTypeProfile;
    }

    public String getProfilName() {
        return profilName;
    }

    public void setIdTypeProfile(int idTypeProfile) {
        this.idTypeProfile = idTypeProfile;
    }

    public void setProfilName(String profilName) {
        this.profilName = profilName;
    }
}
