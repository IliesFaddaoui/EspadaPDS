package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the KeyWord data model
 */
public class KeyWord {
    private int idKeyword;
    private int nameKeyWord;

    public KeyWord(int idKeyword, int nameKeyWord) {
        this.idKeyword = idKeyword;
        this.nameKeyWord = nameKeyWord;
    }

    public int getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(int idKeyword) {
        this.idKeyword = idKeyword;
    }

    public int getNameKeyWord() {
        return nameKeyWord;
    }

    public void setNameKeyWord(int nameKeyWord) {
        this.nameKeyWord = nameKeyWord;
    }
}
