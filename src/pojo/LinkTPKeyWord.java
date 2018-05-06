package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the LinkTPKeyWord data model
 */
public class LinkTPKeyWord {
    private int idLinkTPKeyWord;
    private int idTypicalProfile;
    private int idKeyWord;

    public LinkTPKeyWord(int idLinkTPKeyWord, int idTypicalProfile, int idKeyWord) {
        this.idLinkTPKeyWord = idLinkTPKeyWord;
        this.idTypicalProfile = idTypicalProfile;
        this.idKeyWord = idKeyWord;
    }

    public int getIdLinkTPKeyWord() {
        return idLinkTPKeyWord;
    }

    public void setIdLinkTPKeyWord(int idLinkTPKeyWord) {
        this.idLinkTPKeyWord = idLinkTPKeyWord;
    }

    public int getIdTypicalProfile() {
        return idTypicalProfile;
    }

    public void setIdTypicalProfile(int idTypicalProfile) {
        this.idTypicalProfile = idTypicalProfile;
    }

    public int getIdKeyWord() {
        return idKeyWord;
    }

    public void setIdKeyWord(int idKeyWord) {
        this.idKeyWord = idKeyWord;
    }
}
