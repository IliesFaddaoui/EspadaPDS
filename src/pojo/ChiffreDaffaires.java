package pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Anaximandro
 * @version 2
 * This is the turnover data model
 */

public class ChiffreDaffaires {
	private String chiffreDate;
	private int idMagasin;
	private int montant;
	
	public ChiffreDaffaires(String chiffreDate, int idMagasins, int montant) {
		this.setChiffreDate(chiffreDate);
		this.setIdMagasin(idMagasins);
		this.setMontant(montant);
	}

	public String getChiffreDate() {
		return chiffreDate;
	}

	public void setChiffreDate(String chiffreDate) {
		this.chiffreDate = chiffreDate;
	}

	public int getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	
	
}