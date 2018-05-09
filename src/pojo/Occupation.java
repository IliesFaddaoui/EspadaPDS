package pojo;

public class Occupation {
    private int idEmplacement;
    private int idMagasin;
    private String dateEntree;
    private String dateSortie;

    public Occupation(int idEmplacement, int idMagasin, String dateEntree, String dateSortie) {
        this.idEmplacement = idEmplacement;
        this.idMagasin = idMagasin;
        this.dateEntree= dateEntree;
        this.dateSortie = dateSortie;
  
    }

	public int getIdEmplacement() {
		return idEmplacement;
	}

	public void setIdEmplacement(int idEmplacement) {
		this.idEmplacement = idEmplacement;
	}

	public int getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
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

   
}
