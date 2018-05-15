package mappingAxel;

public class Magazins {
	//ID
	private int idMagasin = 0;
	private String magasinName ="";
	private String magasinType ="";
	private int magasinSuperficie = 0;

	
	
	public Magazins(int idMagasin, String magasinName, String magasinType, int magasinSuperficie){
		this.idMagasin= idMagasin;
		this.setMagasinName(magasinName);
		this.setMagasinType(magasinType);
		this.setMagasinSuperficie(magasinSuperficie);

	}
	
	
	public Magazins(){}
	

	public int getIdMagasin() {
		return idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}
	public String getMagasinName() {
		return magasinName;
	}
	public void setMagasinName(String magasinName) {
		this.magasinName = magasinName;
	}
	public String getMagasinType() {
		return magasinType;
	}
	public void setMagasinType(String magasinType) {
		this.magasinType = magasinType;
	}
	public int getMagasinSuperficie() {
		return magasinSuperficie;
	}
	public void setMagasinSuperficie(int magasinSuperficie) {
		this.magasinSuperficie = magasinSuperficie;
	}
	
}
