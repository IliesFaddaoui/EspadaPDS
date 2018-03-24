package socketServer;

import java.sql.Date;
// Adapter avec DAO Emplacement
public class ClientDAO {
	
	private String nom;
	private String prenom;

	
	public ClientDAO(String nom, String prenom)
	{
	
		this.nom = nom;
		this.prenom = prenom;
	
	}


	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	
	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
}
