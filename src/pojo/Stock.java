package pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Anaximandro
 * @version 2
 * This is the stock data model
 */

public class Stock {
	private int idMagasin = 0;
	private int idProduct = 0;
	private int Quantite = 0;
	private Date dateEntree;
	private Date dateSortie;
	private String motifSortie = "";
	
	public Stock(int idMagasin, int idProduct, int Quantite, Date dateEntree, Date dateSortie, String motifSortie) {
		this.idMagasin = idMagasin;
		this.idProduct = idProduct;
		this.Quantite = Quantite;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.motifSortie = motifSortie;
	}

	public int getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getMotifSortie() {
		return motifSortie;
	}

	public void setMotifSortie(String motifSortie) {
		this.motifSortie = motifSortie;
	}


	
	
	
}