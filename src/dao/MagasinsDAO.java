package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Magasins;

/**
 * @author ilies
 * DAO class for magasin
 */
public class MagasinsDAO extends DAO<Magasins>{

	private Connection con;
	public MagasinsDAO(Connection conn){
		super(conn);
		this.con=conn;
	}

	public Connection getConnection(){
		return this.con;
	}
	public boolean create(Magasins obj) {

		try{
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Magasins(idMagasins,nom, superficieM,idEmplacement) values ("+obj.getIdMagasin()+",\""+obj.getNom()+"\","+obj.getSuperficieM()+","+obj.getIdEmplacement()+")");	
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
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMagasins, nom, superficieM, idEmplacement FROM Magasins Where idMagasins="+ idMagasins);
			while(result.next()){
				Magasins mag = new Magasins(result.getInt("idMagasins"),result.getString("nom"), result.getInt("superficieM"), result.getInt("idEmplacement"));
				return mag;
			}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return null;
		
	}
	

}
