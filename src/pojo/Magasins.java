package pojo;

public class Magasins {
	//ID
	private int idMagasin = 0;
	//nom du magasin
	private String nom ="";
	//super
	
	public Magasins(int idMagasin, String nom){
		this.idMagasin= idMagasin;
		this.nom = nom;
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
	
	
}
