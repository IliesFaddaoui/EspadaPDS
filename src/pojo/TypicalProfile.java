package pojo;

import java.util.ArrayList;
/**
 * @author Ilies
 * @version 2
 * This is the TypicalProfile data model
 */
public class TypicalProfile {

    private int idTypicalProfile;
    private String profilName;

    public TypicalProfile(int idTypicalProfile, String profilName) {
        this.idTypicalProfile = idTypicalProfile;
        this.profilName = profilName;
    } 

    public int getIdTypicalProfile() {
        return idTypicalProfile;
    }

    public String getProfilName() {
        return profilName;
    }

    public void setIdTypicalProfile(int idTypicalProfile) {
        this.idTypicalProfile = idTypicalProfile;
    }

    public void setProfilName(String profilName) {
        this.profilName = profilName;
    }
}
