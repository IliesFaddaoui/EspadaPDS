package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the KeyWord data model
 */
public class KeyWord {
    private int idKeyword;
    private String nameKeyWord;

    public KeyWord(int idKeyword, String nameKeyWord) {
        this.idKeyword = idKeyword;
        this.nameKeyWord = nameKeyWord;
    }

    public int getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(int idKeyword) {
        this.idKeyword = idKeyword;
    }

    public String getNameKeyWord() {
        return nameKeyWord;
    }

    public void setNameKeyWord(String nameKeyWord) {
        this.nameKeyWord = nameKeyWord;
    }
}
