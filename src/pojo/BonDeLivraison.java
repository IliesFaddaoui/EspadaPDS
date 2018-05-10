package pojo;
/**
 * 
 * @author aramil
 *
 */

public class BonDeLivraison {
	private int numeroBon;
	
	private String listProduits;

	
	public BonDeLivraison(int numeroBon, String listProduits) {
		this.numeroBon = numeroBon;
		this.listProduits = listProduits;
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
	
	
}
