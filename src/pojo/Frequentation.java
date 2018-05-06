package pojo;

import java.util.ArrayList;
import java.util.Date;

public class Frequentation {
	private Date frequentationDate;
	private int idMagasin;
	private int niveauFrequentation;
	
	public Frequentation(Date frequentationDate, int idMagasins, int niveauFrequentation) {
		this.setFrequentationDate(frequentationDate);
		this.setIdMagasin(idMagasins);
		this.setNiveauFrequentation(niveauFrequentation);	
	}

	public Date getFrequentationDate() {
		return frequentationDate;
	}

	public void setFrequentationDate(Date frequentationDate) {
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