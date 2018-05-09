package MappingAxel;
import pojo.Magasins;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MagasinsDAO /*extends DAO<Magasins>*/{

	private Connection con;
	/**

	public MagasinsDAO(Connection conn){
		super(conn);
		this.con=conn;
	}

	public boolean create(Magasins obj) {

		try{
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Magasins(idMagasins, magasinName, magasinType, magasinSuperficie) values ("+obj.getIdMagasin()+",\""+obj.getMagasinName()+"\","+obj.getMagasinType()+","+obj.getMagasinSuperficie()+")");	
			return true;
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return false;
	}


	public boolean delete(Magasins obj) {

		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM 'Magasins' WHERE idMagasins="+obj.getIdMagasin());		
			return true;
		} catch (SQLException e) {
				e.printStackTrace();		
			}
		return false;
	}


	public boolean update(Magasins obj) {
		return false;
	}


	public Magasins find(int idMagasins) {
		;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMagasin, magasinName, magasinType, magasinSuperficie, idEmplacement FROM Magasins Where idMagasin="+ idMagasins);
			while(result.next()){
				MappingAxel.Magasins mag = new Magasins(result.getInt("idMagasin"), result.getString("magasinName"), result.getString("magasinType"), result.getInt("magasinSuperficie"), result.getInt("idEmplacement"));
				return mag;
			}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return null;
		
	}

*/
}
