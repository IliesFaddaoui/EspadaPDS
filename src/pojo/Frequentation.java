package pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Anaximandro
 * @version 2
 * This is the attendance data model
 */

public class Frequentation {
	private String frequentationDate;
	private int idMagasin;
	private int niveauFrequentation;
	
	public Frequentation(String frequentationDate, int idMagasin, int niveauFrequentation) {
		this.frequentationDate = frequentationDate;
		this.idMagasin = idMagasin;
		this.niveauFrequentation = niveauFrequentation;	
	}

	public String getFrequentationDate() {
		return frequentationDate;
	}

	public void setFrequentationDate(String frequentationDate) {
		this.frequentationDate = frequentationDate;
	}

	public int getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}

	public int getNiveauFrequentation() {
		return niveauFrequentation;
	}

	public void setNiveauFrequentation(int niveauFrequentation) {
		this.niveauFrequentation = niveauFrequentation;
	}
}