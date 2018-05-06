package pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Anaximandro
 * @version 2
 * This is the turnover data model
 */

public class ChiffreDaffaires {
	private Date chiffreDate;
	private int idMagasin;
	private int montant;
	
	public ChiffreDaffaires(Date chiffreDate, int idMagasins, int montant) {
		this.setChiffreDate(chiffreDate);
		this.setIdMagasin(idMagasins);
		this.setMontant(montant);
	}

	public Date getChiffreDate() {
		return chiffreDate;
	}

	public void setChiffreDate(Date chiffreDate) {
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