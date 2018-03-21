package pojo;

public class Magasins {
	//ID
	private int idMagasin = 0;
	//nom du magasin
	private String nom ="";
	//superficie du mag
	private int superficieM = 0;
	//l'id de l'emplacement
	private int idEmplacement=0;
	
	public Magasins(int idMagasin, String nom, int superficieM, int idEmplacement){
		this.idMagasin= idMagasin;
		this.nom = nom;
		this.superficieM=superficieM;
		this.idEmplacement=idEmplacement;
	}
	public Magasins(){}
	
	public int getIdMagasin() {
		return idMagasin;
	}
	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getSuperficieM() {
		return superficieM;
	}
	public void setSuperficieM(int superficieM) {
		this.superficieM = superficieM;
	}
	public int getIdEmplacement() {
		return idEmplacement;
	}
	public void setIdEmplacement(int idEmplacement) {
		this.idEmplacement = idEmplacement;
	}
	
	
}
