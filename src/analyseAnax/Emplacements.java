package analyseAnax;

/**
 * @author ilies
 * Pojo class for Emplacement
 */
public class Emplacements {

    private int idEmplacement=0;
    private String localisation="";
    private int superficie=0;
    private String categorie="";
    private float tauxOccupation=0;

    public Emplacements(int idEmplacement, String localisation, int superficieE, String categorie, float tauxOccupation ){
        this.idEmplacement=idEmplacement;
        this.localisation=localisation;
        this.superficie=superficieE;
        this.categorie=categorie;
        this.tauxOccupation=tauxOccupation;
    }

    public int getIdEmplacement() {
        return idEmplacement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public int getSuperficie() {
        return superficie;
    }

    public String getCategorie() {
        return categorie;
    }

    public float getTauxOccupation() {
        return tauxOccupation;
    }

    public void setIdEmplacement(int idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setTauxOccupation(float tauxOccupation) {
        this.tauxOccupation = tauxOccupation;
    }
}
