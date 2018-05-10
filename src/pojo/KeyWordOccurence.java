package pojo;

/**
 * @author Ilies
 * @version 1.0
 * This is the model used for keyword occurence in database
 */
public class KeyWordOccurence {
    private String nameKeyWord;
    private int keyWordOccurence;

    public KeyWordOccurence(String nameKeyWord, int keyWordOccurence) {
        this.nameKeyWord = nameKeyWord;
        this.keyWordOccurence = keyWordOccurence;
    }

    public String getNameKeyWord() {
        return nameKeyWord;
    }

    public void setNameKeyWord(String nameKeyWord) {
        this.nameKeyWord = nameKeyWord;
    }

    public int getKeyWordOccurence() {
        return keyWordOccurence;
    }

    public void setKeyWordOccurence(int keyWordOccurence) {
        this.keyWordOccurence = keyWordOccurence;
    }
}
