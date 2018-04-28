package pojo;

import java.util.ArrayList;

public class TypicalProfile {

    private int idTypicalProfile;
    private String profilName;
    private ArrayList<String> keyWordList;

    public int getIdTypicalProfile() {
        return idTypicalProfile;
    }

    public String getProfilName() {
        return profilName;
    }

    public ArrayList<String> getKeyWordList() {
        return keyWordList;
    }

    public void setIdTypicalProfile(int idTypicalProfile) {
        this.idTypicalProfile = idTypicalProfile;
    }

    public void setProfilName(String profilName) {
        this.profilName = profilName;
    }

    public void setKeyWordList(ArrayList<String> keyWordList) {
        this.keyWordList = keyWordList;
    }
}
