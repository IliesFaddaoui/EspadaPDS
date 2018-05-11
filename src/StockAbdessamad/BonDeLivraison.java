package StockAbdessamad;
/**
 * 
 * @author aramil
 *
 */

public class BonDeLivraison {
	private int numeroBon;
	
	private String listProduits;
	private int idMagasin;


	public BonDeLivraison(int numeroBon, String listProduits, int idMagasin) {
		this.numeroBon = numeroBon;
		this.listProduits = listProduits;
		this.idMagasin = idMagasin;
	}
	
	public int getNumeroBon() {
		return numeroBon;
	}

	public void setNumeroBon(int numeroBon) {
		this.numeroBon = numeroBon;
	}

	public String getListProduits() {
		return listProduits;
	}

	public void setListProduits(String listProduits) {
		this.listProduits = listProduits;
	}
	
	
	public int getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}
	
	
}
