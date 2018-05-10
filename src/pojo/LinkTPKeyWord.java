package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the LinkTPKeyWord data model
 */
public class LinkTPKeyWord {
    private int idLinkTPKeyWord;
    private int idTypeProfile;
    private int idKeyWord;

    public LinkTPKeyWord(int idLinkTPKeyWord, int idTypeProfile, int idKeyWord) {
        this.idLinkTPKeyWord = idLinkTPKeyWord;
        this.idTypeProfile = idTypeProfile;
        this.idKeyWord = idKeyWord;
    }

    public int getIdLinkTPKeyWord() {
        return idLinkTPKeyWord;
    }

    public void setIdLinkTPKeyWord(int idLinkTPKeyWord) {
        this.idLinkTPKeyWord = idLinkTPKeyWord;
    }

    public int getIdTypeProfile() {
        return idTypeProfile;
    }

    public void setIdTypeProfile(int idTypeProfile) {
        this.idTypeProfile = idTypeProfile;
    }

    public int getIdKeyWord() {
        return idKeyWord;
    }

    public void setIdKeyWord(int idKeyWord) {
        this.idKeyWord = idKeyWord;
    }
}
