package analyseAnax;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Anaximandro
 * @version 2 This is the stock data model
 */

public class Stock {
	private int idMagasin = 0;
	private int idProduct = 0;
	private int Quantite = 0;
	private String dateEntree;
	private String dateSortie;
	// aramil: motifEntree: Client's return of orders
	private String motifEntree = "";

	public Stock(int idMagasin, int idProduct, int Quantite, String dateEntree, String dateSortie, String motifEntree) {
		this.idMagasin = idMagasin;
		this.idProduct = idProduct;
		this.Quantite = Quantite;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.motifEntree = motifEntree;
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

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getMotifEntree() {
		return motifEntree;
	}

	public void setMotifEntree(String motifSortie) {
		this.motifEntree = motifSortie;
	}

}